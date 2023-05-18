package com.xencio.versionrecord.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Maserhe
 * @date 2023/05/18 11:24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionRecordVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 日期
     */
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
    private String tenant;

    /**
     * 0 没有删除, 1, 删除
     */
    private Integer isDelete = 0;
}
