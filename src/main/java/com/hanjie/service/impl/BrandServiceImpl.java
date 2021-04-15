package com.hanjie.service.impl;

import com.hanjie.domin.entity.Brand;
import com.hanjie.service.BrandService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends BaseServiceimpl<Brand> implements BrandService {
}
