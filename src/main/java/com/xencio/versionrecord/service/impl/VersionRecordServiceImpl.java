package com.xencio.versionrecord.service.impl;

import com.xencio.versionrecord.common.response.CommonResult;
import com.xencio.versionrecord.entity.VersionRecord;
import com.xencio.versionrecord.mapper.VersionRecordMapper;
import com.xencio.versionrecord.service.VersionRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public CommonResult deleteVersionRecord(String id) {

        VersionRecord versionRecord = vrMapper.selectById(id);
        if (versionRecord == null) return CommonResult.failed("删除记录不存在");
        versionRecord.setIsDelete(1);
        int num = vrMapper.updateById(versionRecord);
        return num == 1? CommonResult.success(null, "修改成功"): CommonResult.failed("");
    }
}

