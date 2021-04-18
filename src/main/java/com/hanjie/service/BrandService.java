package com.hanjie.service;

import com.hanjie.common.page.PageResult;
import com.hanjie.domin.criteria.BrandCriteria;
import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Brand;
import com.hanjie.domin.vo.BrandVo;
import com.hanjie.service.base.BaseService;

import java.util.List;

public interface BrandService extends BaseService<Brand> {

    /**
     * 分页条件查询
     * 一个给前台传的Vo实体对象
     * 一个是封装的条件方法
     */
    PageResult<BrandVo> searchPage(BrandCriteria brandCriteria);
}
