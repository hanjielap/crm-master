package com.hanjie.controller;

import com.hanjie.common.http.AxiosResult;
import com.hanjie.controller.base.BaseController;
import com.hanjie.domin.entity.Admin;
import com.hanjie.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor//和@Autowired效果一样
public class AdminController extends BaseController {


    private final AdminService adminService;

    /**
     *查询所有
     */
    @GetMapping
    public AxiosResult<List<Admin>> list(){
        List<Admin> list = adminService.list();
        return AxiosResult.success(list);
    }

    /**
     * 根据id查询
     */
    @GetMapping("{id}")
    public AxiosResult<Admin> findById(@PathVariable Long id){
        Admin byId = adminService.getById(id);
        return AxiosResult.success(byId);
    }
    /**
     *添加
     */
    @PostMapping
    public AxiosResult<Void> add(@RequestBody  Admin admin){
        return toAxios(adminService.save(admin));
    }

    /**
     * 修改
     */
    @PutMapping
    public AxiosResult<Void> update(@RequestBody  Admin admin){
        return toAxios(adminService.update(admin));
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable  Long id){
        return toAxios(adminService.deleteById(id));
    }


}
