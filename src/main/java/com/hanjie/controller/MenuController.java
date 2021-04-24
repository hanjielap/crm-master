package com.hanjie.controller;

import com.hanjie.common.http.AxiosResult;
import com.hanjie.common.page.PageResult;
import com.hanjie.controller.base.BaseController;
import com.hanjie.domin.criteria.BrandCriteria;
import com.hanjie.domin.criteria.MenuCriteria;
import com.hanjie.domin.entity.Brand;
import com.hanjie.domin.entity.Menu;
import com.hanjie.domin.vo.BrandVo;

import com.hanjie.domin.vo.MenuVo;
import com.hanjie.service.MenuService;
import com.hanjie.transfer.BrandTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController  extends BaseController {

    private final MenuService menuService;



    /**
     * 分页条件查询
     */
    @GetMapping
    public AxiosResult<PageResult<MenuVo>> list(MenuCriteria menuCriteria) {
        return AxiosResult.success(menuService.getMenuTree(menuCriteria));
    }

    /**
     * 查询所有菜单的Tree
     *
     * @return
     */
    @GetMapping("tree")
    public AxiosResult<List<MenuVo>> getMenuTree() {
        List<MenuVo> rootfolder = new ArrayList<>();
        List<MenuVo> list = menuService.getAllMenuTree();
        MenuVo menuVo = new MenuVo();
        menuVo.setId(0L);
        menuVo.setMenuTitle("主目录");
        menuVo.setChildren(list);
        rootfolder.add(menuVo);
        return AxiosResult.success(rootfolder);
    }




    /**
     * 添加功能
     */

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Menu menu) {
        System.out.println(menu);
        return toAxios(menuService.save(menu));
    }


    /**
     * 修改功能
     */

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Menu menu) {
        return toAxios(menuService.update(menu));
    }


    @GetMapping("{id}")
    public AxiosResult<Menu> findById(@PathVariable Long id) {
        return AxiosResult.success(menuService.getById(id));
    }


    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id) {
        return toAxios(menuService.deleteById(id));
    }

}
