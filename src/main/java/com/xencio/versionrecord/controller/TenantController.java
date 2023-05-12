package com.xencio.versionrecord.controller;


import com.xencio.versionrecord.common.response.CommonResult;
import com.xencio.versionrecord.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2023-05-08
 */
@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    /**
     * 获取 租户所有列表
     * @return
     */
    @GetMapping("/list")
    public CommonResult getAllTenantList() {
        return CommonResult.success(tenantService.list());
    }





}
