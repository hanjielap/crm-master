package com.hanjie.transfer;


import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Brand;
import com.hanjie.domin.entity.Dept;
import com.hanjie.domin.vo.AdminVo;
import com.hanjie.domin.vo.BrandVo;
import com.hanjie.mapper.DeptMapper;
import com.hanjie.transfer.base.BaseTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AdminTransfer extends BaseTransfer<Admin, AdminVo> {



    private final DeptMapper deptMapper;

    public List<AdminVo> setSex(List<Admin> list) {
        //先转换成vo对象
        List<AdminVo> adminVos = super.toVO(list);
        //遍历vo对象
        for (int i = 0; i < adminVos.size(); i++) {
            //拿到entity对象
            Admin admin = list.get(i);
            //拿到admin对象中的dept中的id
            Dept dept = deptMapper.selectById(admin.getDeptId());
            AdminVo adminVo = adminVos.get(i);
           //判断是否非空 并给部门名称进行赋值
            adminVo.setDeptName(dept==null?"":dept.getDeptName());
            //对adminvo中的性别进行赋值
            if (admin.getGender() == 0) {
                adminVo.setSex("男");
            } else if (admin.getGender() == 1) {
                adminVo.setSex("女");
            } else {
                adminVo.setSex("未知");
            }
        }
        return adminVos;
    }



}
