package com.hanjie.service.impl;

import com.hanjie.domin.entity.Menu;
import com.hanjie.domin.entity.RoleMenu;
import com.hanjie.service.MenuService;
import com.hanjie.service.RoleMenuService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleMenuServiceimpl  extends BaseServiceimpl<RoleMenu> implements RoleMenuService {
}
