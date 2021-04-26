package com.hanjie.common.perm;


import com.hanjie.common.exception.PermException;
import com.hanjie.common.http.EnumStatus;
import com.hanjie.common.util.TokenService;
import com.hanjie.domin.entity.Menu;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * 用来处理按钮权限的aop切面
 */
@Aspect
@Component
public class MyAspect {


    @Autowired
    private TokenService tokenService;


    @Before("pointCut()")
    public void checkPerm(JoinPoint joinPoint) throws IOException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //拿到方法
        Method method = signature.getMethod();
        //拿到方法的内容
        HasPerm annotation = method.getAnnotation(HasPerm.class);
        //判断是否为空
        if (annotation != null) {
            //判断是否有权限
            List<Menu> perms = tokenService.getLoginAdmin().getPerms();
            String perm = annotation.perm();
            //是否有一个数值
            boolean b = perms.stream().anyMatch(menu -> perm.equals(menu.getPermission()));
            if (!b) {
                //如果没有 则抛出 无权限的异常
                throw new PermException(EnumStatus.NO_PERM);
            }


        }


    }

    @Pointcut("@annotation(com.hanjie.common.perm.HasPerm)")
    public void pointCut() {

    }
}
