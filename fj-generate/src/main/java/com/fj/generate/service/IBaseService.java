package com.fj.generate.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fj.generate.entity.BaseEntity;
import com.github.yulichang.interfaces.MPJBaseJoin;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * service接口通用
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:42
 */
public interface IBaseService<T extends BaseEntity> {

    int isSaveSuccess(T entity);

    int isSaveSuccess(List<T> entityList);

    int isSaveSuccessNeedId(T entity, String colom);

    int isSaveSuccessNeedId(List<T> entityList, String colom);

    int isUpdateSuccess(Wrapper<T> updateWrapper);

    int isUpdateSuccess(T setEntity, T whereEntity);

    int isUpdateSuccess(T setEntity, Wrapper<T> updateWrapper);

    int isUpdateSuccess(T setEntity, List<T> whereEntityList);

    int isDeleteSuccess(T entity);

    int isDeleteSuccess(Wrapper<T> deleteWrapper);

    int isDeleteSuccess(Map<String, Object> columnMap);

    List<T> queryList(T entity);

    List<T> queryList(Wrapper<T> queryWrapper);

    Page<T> queryList(T entity, long current, long size);

    Page<T> queryList(Page<T> page, T entity);

    Page<T> queryList(Wrapper<T> queryWrapper, long current, long size);

    Page<T> queryList(Page<T> page, Wrapper<T> queryWrapper);

    List<T> queryList(Map<String, Object> columnMap);

    T findObject(T entity);

    T findObject(Wrapper<T> queryWrapper);

    Integer queryCount(T entity);

    Integer queryCount(Wrapper<T> queryWrapper);

    int findMaxColumnByInt(T entity, String column);

    int findMaxColumnByInt(QueryWrapper<T> queryWrapper, String column);

    Object findMaxColumnByObject(T entity, String column);

    Object findMaxColumnByObject(QueryWrapper<T> queryWrapper, String column);

    List<Map<String, Object>> queryMap(Wrapper<T> queryWrapper);

    Page<Map<String, Object>> queryMap(Wrapper<T> queryWrapper, long current, long size);

    List<T> executeQuerySql(String sql);

    List<T> executeQuerySql(String sql, long current, long size);

    Page<T> executeQuerySql(Page<T> page, String sql);

    List<Map<String, Object>> executeQuerySqlMap(String sql);

    Page<Map<String, Object>> executeQuerySqlPageMap(String sql);

    int executeUpdateSql(String sql);

    int executeDeleteSql(String sql);

    Object findSequence(String sequenceName);

    Date findDataBaseDate();

    List<T> queryJoinList(MPJBaseJoin<T> wrapper);

    Page<T> queryJoinList(MPJBaseJoin<T> wrapper, long current, long size);

    Page<T> queryJoinList(Page<T> page, MPJBaseJoin<T> wrapper);

    Long queryJoinCount(MPJBaseJoin<T> wrapper);
}
