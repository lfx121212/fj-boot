package com.fj.business;

import com.fj.generate.entity.Generate;
import com.fj.generate.utils.GenerateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * annotation
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/19 2:51
 */
@RestController
public class demo {
    @GetMapping("/get")
    public void ex() {
        GenerateUtils.executeRun(new Generate());
    }
}
