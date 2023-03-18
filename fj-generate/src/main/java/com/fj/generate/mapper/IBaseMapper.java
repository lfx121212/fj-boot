package com.fj.generate.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fj.generate.entity.BaseEntity;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * mapper通用
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:40
 */
public interface IBaseMapper<T extends BaseEntity> extends MPJBaseMapper<T> {
    List<Map<String, Object>> executeSql(@Param("sql") String sql);

    Page<List<Map<String, Object>>> executeSqlByPage(Page<T> page, @Param("sql") String sql);

    Object findSequence(@Param("sequenceName") String sequenceName);

    String findDataBaseDate();
}
