package com.xencio.versionrecord.controller;


import com.xencio.versionrecord.entity.Tenant;
import com.xencio.versionrecord.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    TenantService tenantService;

    @GetMapping("/test")
    public String test() {
        List<Tenant> list = tenantService.list();
        return list.toString();
    }
}
