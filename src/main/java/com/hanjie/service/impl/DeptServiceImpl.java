package com.hanjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanjie.common.util.TreeUtils;
import com.hanjie.domin.entity.Dept;
import com.hanjie.domin.vo.DeptVo;
import com.hanjie.mapper.DeptMapper;
import com.hanjie.service.DeptService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import com.hanjie.transfer.DeptTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DeptServiceImpl extends BaseServiceimpl<Dept> implements DeptService {

    private final DeptMapper deptMapper;


    private final DeptTransfer deptTransfer;

    /**
     * 获得所有的部门 （Tree方式）
     */
    @Override
    public List<DeptVo> getDeptTree() {
        List<Dept> list = this.list();
        List<DeptVo> deptVos = deptTransfer.addChildrenProperties(list);
        List<DeptVo> deptVos1 = TreeUtils.bulidTree(deptVos);
        return deptVos1;

    }

    /**
     * 拿到所有的部门 （懒加载方式） 通过id找孩子
     */
    @Override
    public List<DeptVo> getChildrenById(long id) {
        List<Dept> depts = deptMapper.selectList(new QueryWrapper<Dept>().lambda().eq(Dept::getParentId, id).orderByAsc(Dept::getDeptSort));
        return deptTransfer.toVO(depts);
    }

    /**
     * 员工修改回显部门
     */
    @Override
    public List<DeptVo> getDeptVoTree(Long id, List<Dept> list) {
        //获得部门id
        Dept dept = getById(id);
        //获得父id
        Long parentId = dept.getParentId();
        //拿到所有的一级部门
        List<Dept> depts = deptMapper.selectList(new QueryWrapper<Dept>().lambda().eq(Dept::getParentId, parentId));
        list.addAll(depts);
        //如果父id ==0
        if (parentId==0){
            //转换成vo
            return deptTransfer.toVO(list);
        }else {
            //如果不等于0 继续调用
            return getDeptVoTree(parentId,list);
        }

    }
}
