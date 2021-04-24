package com.hanjie.controller;

import com.hanjie.common.http.AxiosResult;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.RequiredArgsConstructor;
import org.ehcache.core.spi.service.ServiceFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录的控制
 */
@RestController
@RequestMapping("common")
@RequiredArgsConstructor//和@Autowired效果一样
public class CommonController {

    /**
     * 登录验证码
     */
    @GetMapping("getCaptcha/{uuid}")
    public AxiosResult<String> getCaptcha(@PathVariable String uuid) throws IOException {
        System.out.println(uuid);
        //向外写图片
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 6);
        String verCode = specCaptcha.text().toLowerCase();
        System.out.println(verCode);
        return AxiosResult.success(specCaptcha.toBase64());

    }

}
