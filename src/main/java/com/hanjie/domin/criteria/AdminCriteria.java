package com.hanjie.domin.criteria;


import com.hanjie.domin.criteria.base.BaseQueryCriteria;
import lombok.Data;

/**
 * 员工的搜索条件
 */
@Data
public class AdminCriteria extends BaseQueryCriteria {

    private String adminName;

    private String adminPhone;

    private Long deptId;


}
