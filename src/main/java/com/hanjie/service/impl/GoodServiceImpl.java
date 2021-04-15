package com.hanjie.service.impl;

import com.hanjie.domin.entity.Good;
import com.hanjie.service.GoodService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodServiceImpl extends BaseServiceimpl<Good> implements GoodService {
}
