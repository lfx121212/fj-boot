package com.fj.generate.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fj.common.utils.LoggerUtil;
import com.fj.generate.entity.BaseEntity;
import com.fj.generate.exception.MyException;
import com.fj.generate.mapper.IBaseMapper;
import com.fj.generate.service.IBaseService;
import com.fj.generate.utils.DateUtil;
import com.fj.generate.utils.SerializeUtil;
import com.fj.generate.utils.StringUtils;
import com.github.yulichang.interfaces.MPJBaseJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Blob;
import java.util.*;

/**
 * <p>
 * service接口实现通用
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:43
 */
public class BaseServiceImpl<T extends BaseEntity> implements IBaseService<T>, Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private IBaseMapper<T> baseMapper;
    private Class<T> clazz;

    public BaseServiceImpl() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) type;
        this.clazz = (Class) pType.getActualTypeArguments()[0];
    }

    @Transactional
    public int isSaveSuccess(T entity) {
        return this.baseMapper.insert(entity);
    }

    @Transactional
    public int isSaveSuccess(List<T> entityList) {
        int count = 0;

        BaseEntity entity;
        for(Iterator var3 = entityList.iterator(); var3.hasNext(); count += this.isSaveSuccess((T) entity)) {
            entity = (BaseEntity)var3.next();
        }

        return count;
    }

    @Transactional
    public int isSaveSuccessNeedId(T entity, String colom) {
        if (StringUtils.isEmpty(entity)) {
            throw new MyException("entity is null");
        } else {
            List<T> entityList = new ArrayList();
            entityList.add(entity);
            return this.isSaveSuccessNeedId((List)entityList, colom);
        }
    }

    @Transactional
    public int isSaveSuccessNeedId(List<T> entityList, String colom) {
        Integer count = 0;
        if (null != entityList && entityList.size() != 0) {
            Integer maxId;
            try {
                T t = (T) this.clazz.getDeclaredConstructor().newInstance();
                maxId = this.findMaxColumnByInt(t, colom);
            } catch (Exception var15) {
                LoggerUtil.printErr("查询表 " + ((TableName)this.clazz.getAnnotation(TableName.class)).value() + " " + colom + "最大值错误：" + var15.getMessage());
                throw new MyException("查询表 " + ((TableName)this.clazz.getAnnotation(TableName.class)).value() + " " + colom + "最大值错误：" + var15.getMessage());
            }

            BaseEntity t2;
            for(Iterator var6 = entityList.iterator(); var6.hasNext(); count = count + this.isSaveSuccess((T) t2)) {
                t2 = (BaseEntity)var6.next();
                maxId = maxId + 1;
                Field[] fields;
                if (t2.getClass().getSimpleName().toUpperCase().endsWith("VO")) {
                    fields = t2.getClass().getSuperclass().getDeclaredFields();
                } else {
                    fields = t2.getClass().getDeclaredFields();
                }

                Field[] var9 = fields;
                int var10 = fields.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    Field field = var9[var11];
                    if (field.getName().equals(colom)) {
                        field.setAccessible(true);

                        try {
                            field.set(t2, maxId);
                            break;
                        } catch (Exception var14) {
                            LoggerUtil.printErr(var14.getMessage());
                            throw new MyException(var14.getMessage());
                        }
                    }
                }
            }

            return count;
        } else {
            throw new MyException("entityList is null");
        }
    }

    @Transactional
    public int isUpdateSuccess(Wrapper<T> updateWrapper) {
        return this.baseMapper.update((T) null, updateWrapper);
    }

    @Transactional
    public int isUpdateSuccess(T setEntity, T whereEntity) {
        UpdateWrapper<T> updateWrapper = new UpdateWrapper(whereEntity);
        return this.isUpdateSuccess(setEntity, (Wrapper)updateWrapper);
    }

    @Transactional
    public int isUpdateSuccess(T setEntity, Wrapper<T> updateWrapper) {
        return this.baseMapper.update(setEntity, updateWrapper);
    }

    @Transactional
    public int isUpdateSuccess(T setEntity, List<T> whereEntityList) {
        int count = 0;
        if (null != whereEntityList && whereEntityList.size() > 0) {
            Iterator var4 = whereEntityList.iterator();

            while(var4.hasNext()) {
                T t = (T) var4.next();
                T whereEntity = this.findObject(t);
                if (null != whereEntity) {
                    count += this.isUpdateSuccess(setEntity, whereEntity);
                }
            }
        }

        return count;
    }

    @Transactional
    public int isDeleteSuccess(T entity) {
        Wrapper<T> wrapper = new QueryWrapper(entity);
        return this.isDeleteSuccess((Wrapper)wrapper);
    }

    @Transactional
    public int isDeleteSuccess(Wrapper<T> wrapper) {
        return this.baseMapper.delete(wrapper);
    }

    @Transactional
    public int isDeleteSuccess(Map<String, Object> columnMap) {
        return this.baseMapper.deleteByMap(columnMap);
    }

    @Transactional(
            readOnly = true
    )
    public List<T> queryList(T entity) {
        QueryWrapper<T> queryWrapper = new QueryWrapper(entity);
        return this.queryList((Wrapper)queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public List<T> queryList(Wrapper<T> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Page<T> queryList(T entity, long current, long size) {
        QueryWrapper<T> queryWrapper = new QueryWrapper(entity);
        Page<T> page = this.getPage(current, size);
        return this.queryList(page, (Wrapper)queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Page<T> queryList(Page<T> page, T entity) {
        QueryWrapper<T> queryWrapper = new QueryWrapper(entity);
        return this.queryList(page, (Wrapper)queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Page<T> queryList(Wrapper<T> queryWrapper, long current, long size) {
        Page<T> page = this.getPage(current, size);
        return this.queryList(page, queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Page<T> queryList(Page<T> page, Wrapper<T> queryWrapper) {
        return (Page)this.baseMapper.selectPage(page, queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public List<T> queryList(Map<String, Object> columnMap) {
        return this.baseMapper.selectByMap(columnMap);
    }

    @Transactional(
            readOnly = true
    )
    public T findObject(T entity) {
        QueryWrapper<T> queryWrapper = new QueryWrapper(entity);
        return (T) this.findObject((Wrapper)queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public T findObject(Wrapper<T> queryWrapper) {
        return (T) this.baseMapper.selectOne(queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Integer queryCount(T entity) {
        QueryWrapper<T> queryWrapper = new QueryWrapper(entity);
        return this.queryCount((Wrapper)queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Integer queryCount(Wrapper<T> queryWrapper) {
        return this.baseMapper.selectCount(queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public List<Map<String, Object>> queryMap(Wrapper<T> queryWrapper) {
        return this.baseMapper.selectMaps(queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Page<Map<String, Object>> queryMap(Wrapper<T> queryWrapper, long current, long size) {
        Page page = this.getPage(current, size);
        return (Page)this.baseMapper.selectMapsPage(page, queryWrapper);
    }

    @Transactional(
            readOnly = true
    )
    public int findMaxColumnByInt(T entity, String column) {
        QueryWrapper<T> queryWrapper = new QueryWrapper(entity);
        int currentMaxValue = this.findMaxColumnByInt(queryWrapper, column);
        return currentMaxValue;
    }

    @Transactional(
            readOnly = true
    )
    public int findMaxColumnByInt(QueryWrapper<T> queryWrapper, String column) {
        int currentMaxValue = 0;
        Object obj = this.findMaxColumnByObject(queryWrapper, column);
        if (StringUtils.notEmpty(obj) && StringUtils.isNumeric(obj.toString())) {
            currentMaxValue = Integer.valueOf(obj.toString());
        }

        return currentMaxValue;
    }

    @Transactional(
            readOnly = true
    )
    public Object findMaxColumnByObject(QueryWrapper<T> queryWrapper, String column) {
        Object currentMaxValue = null;
        column = column.toUpperCase();
        String sqlStr = null;
        queryWrapper.select(new String[]{"max(" + column + ") as " + column});
        List<Map<String, Object>> list = this.queryMap(queryWrapper, 1L, 1L).getRecords();
        if (null != list && list.size() > 0) {
            Map<String, Object> resultMap = (Map)list.get(0);
            String str = resultMap.get(column).toString();
            if (StringUtils.notEmpty(str)) {
                currentMaxValue = str;
            }
        }

        return currentMaxValue;
    }

    @Transactional(
            readOnly = true
    )
    public Object findMaxColumnByObject(T entity, String column) {
        QueryWrapper<T> queryWrapper = new QueryWrapper(entity);
        Object currentMaxValue = this.findMaxColumnByObject(queryWrapper, column);
        return currentMaxValue;
    }

    @Transactional(
            readOnly = true
    )
    public List<T> executeQuerySql(String sql) {
        Page<T> tPage = this.executeQuerySql((Page)null, sql);
        List<T> list = tPage.getRecords();
        return list;
    }

    @Transactional(
            readOnly = true
    )
    public List<T> executeQuerySql(String sql, long current, long size) {
        Page<T> page = this.getPage(current, size);
        page = this.executeQuerySql(page, sql);
        List<T> arrayList = page.getRecords();
        return arrayList;
    }

    @Transactional(
            readOnly = true
    )
    public List<Map<String, Object>> executeQuerySqlMap(String sql) {
        return this.baseMapper.executeSql(sql);
    }

    @Transactional(
            readOnly = true
    )
    public Page<Map<String, Object>> executeQuerySqlPageMap(String sql) {
        Page page = new Page();
        List<Map<String, Object>> list = this.executeQuerySqlMap(sql);
        page.setTotal((long)list.size());
        page.setSize(1L);
        page.setCurrent((long)list.size());
        page.setRecords(list);
        return page;
    }

    @Transactional
    public int executeUpdateSql(String sql) {
        List<Map<String, Object>> maps = this.baseMapper.executeSql(sql);
        return maps.size();
    }

    @Transactional
    public int executeDeleteSql(String sql) {
        List<Map<String, Object>> maps = this.baseMapper.executeSql(sql);
        return maps.size();
    }

    @Transactional(
            readOnly = true
    )
    public Page<T> executeQuerySql(Page page, String sql) {
        if (StringUtils.isEmpty(page)) {
            page = this.executeQuerySqlPageMap(sql);
        } else {
            page = this.baseMapper.executeSqlByPage(page, sql);
        }

        List<T> arrayList = new ArrayList();
        List<Map<String, Object>> list = page.getRecords();
        if (StringUtils.notEmpty(list)) {
            Iterator var5 = list.iterator();

            label43:
            while(true) {
                Map record;
                do {
                    if (!var5.hasNext()) {
                        break label43;
                    }

                    record = (Map)var5.next();
                } while(StringUtils.isEmpty(record));

                Set<String> strings = record.keySet();
                JSONObject jsonObject = new JSONObject();
                Iterator var9 = strings.iterator();

                while(var9.hasNext()) {
                    String key = (String)var9.next();
                    Object value = record.get(key);
                    if (!StringUtils.isEmpty(value)) {
                        if (null != value && value instanceof Blob) {
                            value = SerializeUtil.serializeBlobToByteArray((Blob)value);
                        }

                        jsonObject.put(StringUtils.toCamelName(key, false), value);
                    }
                }

                if (jsonObject.size() > 0) {
                    T t = (T) JSONObject.parseObject(jsonObject.toJSONString(), this.clazz);
                    arrayList.add(t);
                }
            }
        }

        page.setRecords(arrayList);
        return page;
    }

    @Transactional(
            readOnly = true
    )
    public Object findSequence(String sequenceName) {
        return this.baseMapper.findSequence(sequenceName);
    }

    @Transactional(
            readOnly = true
    )
    public Date findDataBaseDate() {
        try {
            String dateStr = this.baseMapper.findDataBaseDate();
            if (StringUtils.notEmpty(dateStr)) {
                return DateUtil.getDate(dateStr, DateUtil.SDF.toPattern());
            } else {
                throw new MyException("Get DataBase System Time is Null");
            }
        } catch (Exception var2) {
            throw new MyException("获取数据库当前时间错误：" + var2.getMessage());
        }
    }

    private Page getPage(long current, long size) {
        Page page = new Page();
        if (0L < current) {
            page.setCurrent(current);
        } else {
            page.setCurrent(1L);
        }

        if (0L < size) {
            page.setSize(size);
        } else {
            page.setSize(15L);
        }

        return page;
    }

    @Transactional(
            readOnly = true
    )
    public List<T> queryJoinList(MPJBaseJoin<T> wrapper) {
        return this.baseMapper.selectJoinList(this.clazz, wrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Page<T> queryJoinList(MPJBaseJoin<T> wrapper, long current, long size) {
        Page<T> page = this.getPage(current, size);
        return this.queryJoinList(page, wrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Page<T> queryJoinList(Page<T> page, MPJBaseJoin<T> wrapper) {
        return (Page)this.baseMapper.selectJoinPage(page, this.clazz, wrapper);
    }

    @Transactional(
            readOnly = true
    )
    public Long queryJoinCount(MPJBaseJoin<T> wrapper) {
        return this.baseMapper.selectJoinCount(wrapper);
    }
}
