package com.fj.business.student.domain.pojo;

import com.fj.generate.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李丰轩
 * @since 2023-03-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Student对象", description="")
public abstract class Student extends BaseEntity {

    private static final long serialVersionUID=1L;

	@ApiModelProperty(value = "主键", example = "1")
	@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

	@ApiModelProperty(value = "年龄", example = "1")
    private Integer age;

	@ApiModelProperty(value = "性别", example = "1")
    private Integer gender;

    @ApiModelProperty(value = "留言")
    private String remark;


}
