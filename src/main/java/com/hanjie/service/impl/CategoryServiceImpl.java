package com.hanjie.service.impl;

import com.hanjie.domin.entity.Category;
import com.hanjie.service.CategoryService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceimpl<Category> implements CategoryService {
}
