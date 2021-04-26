package com.hanjie.common.async;

import com.hanjie.common.util.ServletUtils;
import com.hanjie.common.util.SpringContainerUtils;
import com.hanjie.domin.entity.LoginLog;
import com.hanjie.mapper.LoginLogMapper;

import java.time.LocalDateTime;

public class RunnableFactory {

    /**
     * 添加日志 异步任务
     */

    public static Runnable insertLoginLog(String adminName, int status, String message){
        //不在容器的方法 使用getbena方法
        //拿到LoginLogMapper方法
        LoginLogMapper bean = SpringContainerUtils.getBean(LoginLogMapper.class);
        //添加日志
        LoginLog loginLog = new LoginLog()
                .setAdminName(adminName)//用户名
                .setLoginStatus(status)//状态
                .setMessage(message)//消息
                .setLoginAddress(ServletUtils.getLoginAddress(ServletUtils.getRequest()))//使用电脑地址
                .setRequestIp(ServletUtils.getRequestIp(ServletUtils.getRequest()))//使用电脑ip地址
                .setBroswerName(ServletUtils.getUserAgent(ServletUtils.getRequest()).getBrowser().getName())//使用电脑游览器
                .setOsName(ServletUtils.getUserAgent(ServletUtils.getRequest()).getOperatingSystem().getName())//使用电脑系统名称
                .setLoginTime(LocalDateTime.now());//当前时间

        Runnable runnable=()->{
            //添加日志
            bean.insert(loginLog);
        };
        return runnable;
    }
}
