package com.xencio.versionrecord.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Maserhe
 * @since 2023-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VersionRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime updatedTime;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 0 没有删除, 1, 删除
     */
    private Integer isDelete;


}
