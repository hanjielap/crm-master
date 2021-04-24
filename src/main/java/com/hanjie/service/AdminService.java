package com.hanjie.service;

import com.hanjie.common.page.PageResult;
import com.hanjie.domin.criteria.AdminCriteria;
import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.vo.AdminVo;
import com.hanjie.service.base.BaseService;

public interface AdminService extends BaseService<Admin> {

    /**
     * 分页条件查询
     */
    PageResult<AdminVo> searchPage(AdminCriteria adminCriteria);


    /**
     * 添加员工 并添加角色
     */
    int saveAdminAndRoles(Admin admin);

    /**
     * 修改 获取角色
     */
    Admin getAdminAndRoleIdsById(Long id);



    /**
     * 更新用户和用户的角色
     * @param admin
     * @return
     */
    int updateAdminAndRoles(Admin admin);

}
