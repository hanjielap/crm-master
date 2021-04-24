package com.hanjie.service;

import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Dept;
import com.hanjie.domin.vo.DeptVo;
import com.hanjie.service.base.BaseService;

import java.util.List;

public interface DeptService extends BaseService<Dept> {
    /**
     * 查询所有部门（Tree的方式 ）
     * @return
     */
    List<DeptVo> getDeptTree();
    /**
     * 查询所有部门 通过id找孩子（懒加载方式 ）
     * @return
     */
    List<DeptVo> getChildrenById(long id);

    /**
     *员工修改回显 部门
     */
    List<DeptVo> getDeptVoTree(Long id, List<Dept> list);
}
