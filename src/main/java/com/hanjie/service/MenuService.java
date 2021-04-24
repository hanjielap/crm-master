package com.hanjie.service;

import com.hanjie.common.page.PageResult;
import com.hanjie.domin.criteria.MenuCriteria;
import com.hanjie.domin.entity.Menu;
import com.hanjie.domin.entity.RoleMenu;
import com.hanjie.domin.vo.MenuVo;
import com.hanjie.service.base.BaseService;

import java.util.List;

public interface MenuService extends BaseService<Menu> {

    /**
     * 获得所有的菜单通过树型展示  分页
     * @return
     */
    PageResult<MenuVo> getMenuTree(MenuCriteria menuCriteria);


    /**
     * 不分页的情况
     * @return
     */
    List<MenuVo> getAllMenuTree();
}
