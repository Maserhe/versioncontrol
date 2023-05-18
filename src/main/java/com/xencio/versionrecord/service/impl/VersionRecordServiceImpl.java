package com.xencio.versionrecord.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xencio.versionrecord.common.model.PageResultVo;
import com.xencio.versionrecord.common.model.SelectPageVo;
import com.xencio.versionrecord.common.model.VersionRecordVo;
import com.xencio.versionrecord.common.response.CommonResult;
import com.xencio.versionrecord.entity.Tenant;
import com.xencio.versionrecord.entity.VersionRecord;
import com.xencio.versionrecord.mapper.TenantMapper;
import com.xencio.versionrecord.mapper.VersionRecordMapper;
import com.xencio.versionrecord.service.TenantService;
import com.xencio.versionrecord.service.VersionRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Maserhe
 * @since 2023-05-08
 */
@Service
public class VersionRecordServiceImpl extends ServiceImpl<VersionRecordMapper, VersionRecord> implements VersionRecordService {

    @Autowired
    private VersionRecordMapper vrMapper;


    @Autowired
    private TenantService tenantService;

    @Override
    public CommonResult deleteVersionRecord(String id) {

        VersionRecord versionRecord = vrMapper.selectById(id);
        if (versionRecord == null) return CommonResult.failed("删除记录不存在");
        versionRecord.setIsDelete(1);
        int num = vrMapper.updateById(versionRecord);
        return num == 1? CommonResult.success(null, "修改成功"): CommonResult.failed("");
    }


    /**
     * 分页查询接口
     * @param spv
     * @return
     */
    @Override
    public CommonResult selectPage(SelectPageVo spv) {

        QueryWrapper<VersionRecord> vrQueryWrapper = new QueryWrapper<>();

        // 1. 判断租户id 是否为空，不为空 先筛选
        if (spv.getTenantId() != null) vrQueryWrapper.eq("tenant_id", spv.getTenantId());
        vrQueryWrapper.orderByDesc("date");

        // 2. 过滤其他字段,
        // 3. 分页构建
        Page<VersionRecord> page = new Page<>(spv.getCurrentPage(), spv.getPageSize());
        IPage<VersionRecord> recordIPage = vrMapper.selectPage(page, vrQueryWrapper);

        List<Tenant> tenants = tenantService.list();

        // 4. 构造返回前端的页面
        List<VersionRecord> records = recordIPage.getRecords();
        List<VersionRecordVo> res = new ArrayList<>();

        records.forEach(t-> {
            VersionRecordVo newVo = new VersionRecordVo();
            BeanUtil.copyProperties(t, newVo);
            tenants.stream().filter(tenant -> tenant.getId() == t.getId())
                    .findFirst().ifPresent(tenant -> newVo.setTenant(tenant.getName()));
            res.add(newVo);
        });

        PageResultVo prv = new PageResultVo();
        prv.setCurrentPage(recordIPage.getCurrent());
        prv.setPageSize(recordIPage.getSize());
        prv.setTotal(recordIPage.getTotal());
        prv.setList(res);

        return CommonResult.success(prv);
    }
}

