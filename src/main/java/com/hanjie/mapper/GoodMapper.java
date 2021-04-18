package com.hanjie.mapper;

import com.hanjie.domin.criteria.GoodCriteria;
import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Good;
import com.hanjie.domin.vo.GoodVo;
import com.hanjie.mapper.base.MyMapper;

import java.util.List;

public interface GoodMapper extends MyMapper<Good> {

    List<GoodVo> searchCriteria(GoodCriteria goodCriteria);
}
