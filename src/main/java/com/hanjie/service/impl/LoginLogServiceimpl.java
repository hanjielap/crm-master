package com.hanjie.service.impl;

import com.hanjie.domin.entity.LoginLog;
import com.hanjie.service.LoginLogService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginLogServiceimpl extends BaseServiceimpl<LoginLog> implements LoginLogService {
}
