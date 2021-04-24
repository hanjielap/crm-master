package com.hanjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanjie.common.page.PageResult;
import com.hanjie.domin.criteria.AdminCriteria;
import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.AdminRole;
import com.hanjie.domin.vo.AdminVo;
import com.hanjie.mapper.AdminMapper;
import com.hanjie.mapper.AdminRoleMapper;
import com.hanjie.service.AdminService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import com.hanjie.transfer.AdminTransfer;
import com.sun.jnlp.BasicServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl extends BaseServiceimpl<Admin> implements AdminService {

    private final AdminMapper adminMapper;
    private final AdminTransfer adminTransfer;
    private final AdminRoleMapper adminRoleMapper;

    /**
     * 分页条件查询
     */
    @Override
    public PageResult<AdminVo> searchPage(AdminCriteria adminCriteria) {
        PageHelper.startPage(adminCriteria.getCurrentPage(), adminCriteria.getPageSize());
        LambdaQueryWrapper<Admin> lambda = new QueryWrapper<Admin>().lambda();

        if (!StringUtils.isEmpty(adminCriteria.getAdminName())) {
            lambda.like(Admin::getAdminName, adminCriteria.getAdminName());
        }
        if (!StringUtils.isEmpty(adminCriteria.getAdminPhone())) {
            lambda.eq(Admin::getAdminPhone, adminCriteria.getAdminPhone());
        }

        if (adminCriteria.getDeptId() != null && adminCriteria.getDeptId() != 0) {
            lambda.eq(Admin::getDeptId, adminCriteria.getDeptId());
        }
        if (!StringUtils.isEmpty(adminCriteria.getStartTime())) {
            lambda.between(Admin::getCreateTime, adminCriteria.getStartTime(), adminCriteria.getEndTime());
        }
        List<Admin> admins = adminMapper.selectList(lambda);
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        List<AdminVo> adminVos = adminTransfer.setSex(admins);
        return new PageResult<AdminVo>(pageInfo.getTotal(), adminVos);
    }


    /**
     * 添加员工 并添加角色
     */
    @Override
    public int saveAdminAndRoles(Admin admin) {
        //保存员工信息
        int save = this.save(admin);
        //拿到角色id
        Set<Long> roleIds = admin.getRoleIds();
        //添加角色 拿到实体类
        roleIds.forEach(roleId->{
            //添加
            adminRoleMapper.insert(new AdminRole(admin.getId(),roleId));
        });
        return save;

    }

    /**
     * 修改 获取角色 已经员工信息  根据id查询
     */
    @Override
    public Admin getAdminAndRoleIdsById(Long id) {
        //根据id拿到当前员工信息
        Admin byId = this.getById(id);
        //根据员工信息 拿到当前对应的角色信息
        List<AdminRole> adminRoles = adminRoleMapper.selectList(new QueryWrapper<AdminRole>().lambda().eq(AdminRole::getAdminId, id));
        //拿到角色信息并赋值 过去 返回
        byId.setRoleIds(adminRoles.stream().map(AdminRole::getRoleId).collect(Collectors.toSet()));
        return byId;
    }

    /**
     * 更新用户和用户的角色
     */
    @Override
    public int updateAdminAndRoles(Admin admin) {
        //先删除当前员工说对应的所有角色
        adminRoleMapper.delete(new UpdateWrapper<AdminRole>().lambda().eq(AdminRole::getAdminId, admin.getId()));
        //添加最新的角色信息
        admin.getRoleIds().forEach(roleId -> adminRoleMapper.insert(new AdminRole(admin.getId(), roleId)));
        //修改
        return this.update(admin);
    }


}
