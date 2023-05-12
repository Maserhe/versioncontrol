package com.xencio.versionrecord.service;

import com.xencio.versionrecord.common.response.CommonResult;
import com.xencio.versionrecord.entity.VersionRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Maserhe
 * @since 2023-05-08
 */
public interface VersionRecordService extends IService<VersionRecord> {

    CommonResult deleteVersionRecord(String id);

}
