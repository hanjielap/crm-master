package com.hanjie.service;

import com.hanjie.common.page.PageResult;
import com.hanjie.domin.criteria.RoleCriteria;
import com.hanjie.domin.entity.Role;
import com.hanjie.domin.entity.RoleMenu;
import com.hanjie.domin.vo.RoleVo;
import com.hanjie.service.base.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    /**
     *角色分页查询
     */
    PageResult<RoleVo> searchPage(RoleCriteria roleCriteria);

    RoleVo findById(Long id);


    /**
     * 给角色赋予权限
     * @param roleId
     * @param menuIds
     * @return
     */
    int setRoleMenu(Long roleId, List<Long> menuIds);

    /**
     * 获取角色的权限（不全的） 只用于前端展示而已
     */

    List<Long> getRoleTreeMenuForShow(Long roleId);
}
