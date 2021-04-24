package com.hanjie.mapper;

import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Dept;
import com.hanjie.mapper.base.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface DeptMapper extends MyMapper<Dept> {


    /**
     * 查询是否有孩子
     */
    @Select("select count(1) from base_dept where parent_id=#{id}")
    int getChildrenCount(Long id);
}
