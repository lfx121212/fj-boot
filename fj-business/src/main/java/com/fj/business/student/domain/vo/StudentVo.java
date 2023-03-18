package com.fj.business.student.domain.vo;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fj.generate.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fj.business.student.domain.pojo.Student;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李丰轩
 * @since 2023-03-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("FJ.student")
@ApiModel(value="StudentVo对象", description="")
public class StudentVo extends Student {

    private static final long serialVersionUID=1L;
}
