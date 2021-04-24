package com.hanjie.service.impl;

import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.AdminRole;
import com.hanjie.service.AdminRoleService;
import com.hanjie.service.AdminService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminRoleServiceimpl extends BaseServiceimpl<AdminRole> implements AdminRoleService {
}
