package com.hanjie.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.hanjie.mapper.base.MyMapper;
import com.hanjie.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceimpl<T> implements BaseService<T>{

    @Autowired
    private MyMapper<T> myMapper;

    public MyMapper<T> getMyMapper() {
        return myMapper;
    }

    @Override
    public List<T> list() {
        return myMapper.selectList(null);
    }

    @Override
    public List<T> search(Wrapper<T> wrapper) {
        return myMapper.selectList(wrapper);
    }

    @Override
    public T getById(Long id) {
        return myMapper.selectById(id);
    }

    @Override
    public int save(T t) {
        return myMapper.insert(t);
    }

    @Override
    public int update(T t) {
        return myMapper.updateById(t);
    }

    @Override
    public int deleteById(Long id) {
        return myMapper.deleteById(id);
    }

    @Override
    public int batchDeleteByIds(List<Long> ids) {
        return myMapper.deleteBatchIds(ids);
    }
}
