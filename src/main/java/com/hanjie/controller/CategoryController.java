package com.hanjie.controller;

import com.hanjie.common.http.AxiosResult;
import com.hanjie.controller.base.BaseController;
import com.hanjie.domin.entity.Category;

import com.hanjie.domin.vo.CategoryVo;
import com.hanjie.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor//和@Autowired效果一样
public class CategoryController extends BaseController {


    private final CategoryService categoryService;

    /**
     *查询所有 树状列表
     */
    @GetMapping
    public AxiosResult<List<CategoryVo>> list(){
        List<CategoryVo> list = categoryService.buildTree();
        return AxiosResult.success(list);
    }

    /**
     * 根据id查询
     */
    @GetMapping("{id}")
    public AxiosResult<Category> findById(@PathVariable Long id){
        Category byId = categoryService.getById(id);
        return AxiosResult.success(byId);
    }
    /**
     *添加
     */
    @PostMapping
    public AxiosResult<Void> add(@RequestBody  Category Category){
        return toAxios(categoryService.save(Category));
    }

    /**
     * 修改
     */
    @PutMapping
    public AxiosResult<Void> update(@RequestBody  Category Category){
        return toAxios(categoryService.update(Category));
    }

    /**
     * 删除  以及删除下面的子项
     */
    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable  Long id){

        int row=categoryService.deleSelfAndChildrenById(id);
        return toAxios(row);
    }


    /**
     * 返回联机选择框    信息
     */
    @GetMapping("selectTree")
    public AxiosResult<List<CategoryVo>> getSelectTree(){
        List<CategoryVo> list= categoryService.getSelectTree();
        return AxiosResult.success(list);
    }

    /**
     * 通过父id拿到 分类
     */
    @GetMapping("findByPid")
    public AxiosResult<List<CategoryVo>> findByPid(long parentId){
        List<CategoryVo> list=categoryService.getByParentId(parentId);
        return AxiosResult.success(list);
    }


}
