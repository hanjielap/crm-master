package com.hanjie.service;

import com.hanjie.domin.criteria.GoodCriteria;
import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Good;
import com.hanjie.domin.vo.GoodVo;
import com.hanjie.service.base.BaseService;

import java.util.List;

public interface GoodService extends BaseService<Good> {
    /**
     *商品的分页条件查询
     */
    List<GoodVo> searchPage(GoodCriteria goodCriteria);
}
