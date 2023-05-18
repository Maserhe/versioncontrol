package com.xencio.versionrecord.common.model;

import com.xencio.versionrecord.entity.VersionRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果的类
 *
 * @author Maserhe
 * @date 2023/05/18 10:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultVo implements Serializable {

    private static final long serialVersionUID = 1L;

    Long total;

    Long currentPage;

    Long pageSize;

    List<VersionRecordVo> list;

}
