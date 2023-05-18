package com.xencio.versionrecord.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页查询实体类
 *
 * @author Maserhe
 * @date 2023/05/17 09:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectPageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id  可以为空
     */
    Integer tenantId;


    /**
     * 过滤字段
     */
    String filterMsg;


    Integer currentPage;


    Integer pageSize;


}
