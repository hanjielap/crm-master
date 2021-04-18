package com.hanjie.mapper;

import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Brand;
import com.hanjie.mapper.base.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface BrandMapper extends MyMapper<Brand> {


    @Select("select brand_name from base_brand  where id=#{id}")
    String getBrandNameById(Long id);
}
