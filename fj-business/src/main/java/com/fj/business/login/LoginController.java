package com.fj.business.login;

import com.fj.generate.utils.Constants;
import com.fj.generate.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 登录
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/29 19:15
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Integer> login(HttpServletRequest request, @RequestParam String user, @RequestParam String password) {
        Result<Integer> result = new Result<>();
        // 假装登录
        if (user.equals("111") && password.equals("111")) {
            result.success(Constants.SUC_LOGIN_SUCCESS);
        }
        return result;
    }
}
