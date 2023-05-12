package com.xencio.versionrecord.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 添加记录的vo类
 *
 * @author Maserhe
 * @date 2023/05/12 15:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddVersionRecordVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime date;

    /**
     * 前端版本
     */
    private String frontEndVersion;

    /**
     * 后端版本
     */
    private String backEndVersion;

    /**
     * 前端地址
     */
    private String frontEndAddress;

    /**
     * 后端地址
     */
    private String backEndAddress;

    /**
     * 环境
     */
    private String environment;

    /**
     * 部署人
     */
    private String deployedBy;

    /**
     * 评论
     */
    private String remarks;


    /**
     * 租户id
     */
    private Integer tenantId;



}
