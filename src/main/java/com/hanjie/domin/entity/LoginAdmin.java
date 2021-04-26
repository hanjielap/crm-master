package com.hanjie.domin.entity;

import lombok.Data;

import java.util.List;

/**
 * 开发者：辉哥
 * 特点： 辉哥很帅
 * 开发时间：2021/4/23 14:57
 * 文件说明：
 */
@Data
public class LoginAdmin {

    /**
     * token的使用  保存到token之中
     */

    private String uuid;

    private Admin admin;

    private List<Menu> perms;
}
