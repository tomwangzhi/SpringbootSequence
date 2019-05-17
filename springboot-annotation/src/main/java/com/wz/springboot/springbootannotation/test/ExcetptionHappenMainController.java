package com.wz.springboot.springbootannotation.test;

import com.wz.springboot.springbootannotation.exception.UserNotExistsException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 执行顺序：Filter -> Interceptor -> ControlerAdvice -> Aspect -> Controller
@RestController
public class ExcetptionHappenMainController {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public boolean testGlobalExceptionCatch(@PathVariable("id") String id) {
        if(id.equals("1")) {
            throw new UserNotExistsException("500", "用户不存在");
        } else {
            return true;
        }
    }
}
