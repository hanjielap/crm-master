package com.hanjie.service.impl;

import com.hanjie.domin.entity.Dept;
import com.hanjie.service.DeptService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeptServiceImpl extends BaseServiceimpl<Dept> implements DeptService {
}
