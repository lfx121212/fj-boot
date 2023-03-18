package com.fj.business.student.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fj.business.student.domain.vo.StudentVo;
import com.fj.business.student.service.IStudentService;
import com.fj.common.utils.LoggerUtil;
import com.fj.generate.controller.BaseController;
import com.fj.generate.utils.Constants;
import com.fj.generate.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 李丰轩
 * @since 2023-03-19
 */
@Api
@RestController
@Scope("prototype")
@RequestMapping("/student/student")
public class StudentController extends BaseController {

    @Autowired
    private IStudentService studentService;

    @ApiOperation(value = "chaxun ")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<List<StudentVo>> get(HttpServletRequest request) {
        Result<List<StudentVo>> result = new Result();
        LambdaQueryWrapper<StudentVo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        try {
            List<StudentVo> list = studentService.queryList(lambdaQueryWrapper);
            result.success(Constants.SUC_QUERY,list);
        } catch (Exception e) {
            LoggerUtil.printErr(e);
        }
        return result;
    }
}

