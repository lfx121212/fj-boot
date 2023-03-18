package com.fj.generate.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 通用实体类
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:33
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(
            exist = false
    )
    private transient String redisKey;

    public BaseEntity() {
    }

    public String getRedisKey() {
        return this.redisKey;
    }

    public BaseEntity setRedisKey(final String redisKey) {
        this.redisKey = redisKey;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseEntity)) {
            return false;
        } else {
            BaseEntity other = (BaseEntity)o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseEntity;
    }

    public int hashCode() {
        boolean result = true;
        return 1;
    }

    public String toString() {
        return "BaseEntity(redisKey=" + this.getRedisKey() + ")";
    }
}
