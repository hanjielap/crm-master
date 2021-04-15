package com.hanjie.service.impl;

import com.hanjie.domin.entity.Admin;
import com.hanjie.service.AdminService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import com.sun.jnlp.BasicServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl extends BaseServiceimpl<Admin> implements AdminService {
}
