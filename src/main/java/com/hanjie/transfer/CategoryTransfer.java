package com.hanjie.transfer;


import com.hanjie.domin.entity.Brand;
import com.hanjie.domin.entity.Category;
import com.hanjie.domin.vo.BrandVo;
import com.hanjie.domin.vo.CategoryVo;
import com.hanjie.transfer.base.BaseTransfer;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransfer extends BaseTransfer<Category, CategoryVo> {
}
