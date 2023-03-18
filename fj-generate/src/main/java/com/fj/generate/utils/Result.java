package com.fj.generate.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 统一返回处理类 Result对象
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:54
 */
public class Result <T> implements Serializable {
    @ApiModelProperty("错误码")
    private Integer code;
    @ApiModelProperty("错误提示")
    private String title;
    @ApiModelProperty("提示信息")
    private String message;
    @ApiModelProperty("返回数据")
    private T data;
    private Long total = 0L;
    private Long current = 0L;
    private Long size = 0L;

    public void setPage(Page<?> page) {
        if (StringUtils.notEmpty(page)) {
            this.total = page.getTotal();
            this.current = page.getCurrent();
            this.size = page.getSize();
        }

    }

    public Result<T> fail(String message) {
        this.setCode(ResultCode.FAILURE.getCode());
        this.setTitle(ResultCode.FAILURE.getMsg());
        this.setMessage(message);
        return this;
    }

    public Result<T> success(String title, Integer code, String message, Page<?> page, T data) {
        if (null != page) {
            this.setPage(page);
        }

        this.setCode(code);
        this.setTitle(title);
        this.setMessage(message);
        this.setData(data);
        return this;
    }

    public Result<T> success(String title, String message, Page<?> page, T data) {
        return this.success(title, ResultCode.SUCCESS.getCode(), message, page, data);
    }

    public Result<T> success(String message, T data) {
        return this.success(ResultCode.SUCCESS.getMsg(), message, (Page)null, data);
    }

    public Result<T> success(String message, Page<?> page, T data) {
        return this.success(ResultCode.SUCCESS.getMsg(), message, page, data);
    }

    public Result<T> success(String message) {
        return this.success(message, (T) null);
    }

    public Result<T> success(T data) {
        return this.success(ResultCode.SUCCESS.getMsg(), data);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public Long getTotal() {
        return this.total;
    }

    public Long getCurrent() {
        return this.current;
    }

    public Long getSize() {
        return this.size;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setTotal(final Long total) {
        this.total = total;
    }

    public void setCurrent(final Long current) {
        this.current = current;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label95;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label95;
                    }

                    return false;
                }

                Object this$total = this.getTotal();
                Object other$total = other.getTotal();
                if (this$total == null) {
                    if (other$total != null) {
                        return false;
                    }
                } else if (!this$total.equals(other$total)) {
                    return false;
                }

                Object this$current = this.getCurrent();
                Object other$current = other.getCurrent();
                if (this$current == null) {
                    if (other$current != null) {
                        return false;
                    }
                } else if (!this$current.equals(other$current)) {
                    return false;
                }

                label74: {
                    Object this$size = this.getSize();
                    Object other$size = other.getSize();
                    if (this$size == null) {
                        if (other$size == null) {
                            break label74;
                        }
                    } else if (this$size.equals(other$size)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$title = this.getTitle();
                    Object other$title = other.getTitle();
                    if (this$title == null) {
                        if (other$title == null) {
                            break label67;
                        }
                    } else if (this$title.equals(other$title)) {
                        break label67;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $total = this.getTotal();
        result = result * 59 + ($total == null ? 43 : $total.hashCode());
        Object $current = this.getCurrent();
        result = result * 59 + ($current == null ? 43 : $current.hashCode());
        Object $size = this.getSize();
        result = result * 59 + ($size == null ? 43 : $size.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "Result(code=" + this.getCode() + ", title=" + this.getTitle() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", total=" + this.getTotal() + ", current=" + this.getCurrent() + ", size=" + this.getSize() + ")";
    }

    public Result(final Integer code, final String title, final String message, final T data, final Long total, final Long current, final Long size) {
        this.code = code;
        this.title = title;
        this.message = message;
        this.data = data;
        this.total = total;
        this.current = current;
        this.size = size;
    }

    public Result() {
    }
}
