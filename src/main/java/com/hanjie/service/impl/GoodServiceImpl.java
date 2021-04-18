package com.hanjie.service.impl;

import com.github.pagehelper.PageHelper;
import com.hanjie.domin.criteria.GoodCriteria;
import com.hanjie.domin.entity.Good;
import com.hanjie.domin.vo.GoodVo;
import com.hanjie.mapper.GoodMapper;
import com.hanjie.service.GoodService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodServiceImpl extends BaseServiceimpl<Good> implements GoodService {

    private final GoodMapper goodMapper;
    /**
     *商品的分页条件查询
     */
    @Override
    public List<GoodVo> searchPage(GoodCriteria goodCriteria) {
        //PageHelper.startPage(goodCriteria.getCurrentPage(),goodCriteria.getPageSize());
        //条件拼接 使用 xml文件写拼接
        List<GoodVo> list=goodMapper.searchCriteria(goodCriteria);
        return list;
    }
}
