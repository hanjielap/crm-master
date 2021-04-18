package com.hanjie.service;

import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Category;
import com.hanjie.domin.vo.CategoryVo;
import com.hanjie.service.base.BaseService;

import java.util.List;

public interface CategoryService extends BaseService<Category> {
    //查询所有分类  展示树形结构
    List<CategoryVo> buildTree();

    //下拉框信息
    List<CategoryVo> getSelectTree();

    /**
     * 删除信息 以及删除下面的子详
     * @param id
     * @return
     */
    int deleSelfAndChildrenById(Long id);

    /**
     * 通过父id查
     * @return
     */
    List<CategoryVo> getByParentId(long parentId);
}
