package com.hanjie.domin.vo;

import com.hanjie.domin.vo.base.BaseVo;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVo extends BaseVo {
    /**
     * 分类名称
     */
    private String catetoryName;

    /**
     * 分类父id 如果是顶级分类 父id 为0
     */
    private Long parentId;

    /**
     * 分类等级 一共三级分类 1 2 3
     */
    private Integer categoryLevel;

    /**
     * 返回树状结构children
     */
    List<CategoryVo> children;


}
