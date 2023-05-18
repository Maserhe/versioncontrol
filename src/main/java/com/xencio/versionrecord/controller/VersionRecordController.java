package com.xencio.versionrecord.controller;


import cn.hutool.core.bean.BeanUtil;
import com.xencio.versionrecord.common.model.AddVersionRecordVo;
import com.xencio.versionrecord.common.model.SelectPageVo;
import com.xencio.versionrecord.common.response.CommonResult;
import com.xencio.versionrecord.entity.VersionRecord;
import com.xencio.versionrecord.service.VersionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2023-05-08
 */
@RestController
@RequestMapping("/version-record")
public class VersionRecordController {

    @Autowired
    private VersionRecordService vrService;

    @PostMapping("/add")
    public CommonResult addVersionRecord(@RequestBody AddVersionRecordVo vo) {

        VersionRecord newVr = new VersionRecord();
        BeanUtil.copyProperties(vo, newVr);
        LocalDateTime now = LocalDateTime.now();
        newVr.setCreatedTime(now);
        newVr.setUpdatedTime(now);
        boolean res = vrService.save(newVr);
        return res? CommonResult.success("添加成功"): CommonResult.failed("添加失败");
    }


    @PostMapping("/change")
    public CommonResult changeVersionRecord() {
        return CommonResult.success("");
    }


    /**
     * 删除记录
     * @param id
     * @return
     */
    @GetMapping("/del/{id}")
    public CommonResult delVersionRecord(@PathVariable String id) {
        return vrService.deleteVersionRecord(id);
    }


    /**
     *  分页查询接口
     * @param spv
     * @return
     */
    @PostMapping("/query")
    public CommonResult selectPage(@RequestBody SelectPageVo spv) {

        return vrService.selectPage(spv);
    }

}
