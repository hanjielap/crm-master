package com.hanjie.controller;

import com.hanjie.common.http.AxiosResult;
import com.hanjie.controller.base.BaseController;
import com.hanjie.domin.entity.Dept;

import com.hanjie.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dept")
@RequiredArgsConstructor//和@Autowired效果一样
public class DeptController extends BaseController {


    private final DeptService deptService;

    /**
     *查询所有
     */
    @GetMapping
    public AxiosResult<List<Dept>> list(){
        List<Dept> list = deptService.list();
        return AxiosResult.success(list);
    }

    /**
     * 根据id查询
     */
    @GetMapping("{id}")
    public AxiosResult<Dept> findById(@PathVariable Long id){
        Dept byId = deptService.getById(id);
        return AxiosResult.success(byId);
    }
    /**
     *添加
     */
    @PostMapping
    public AxiosResult<Void> add(@RequestBody  Dept Dept){
        return toAxios(deptService.save(Dept));
    }

    /**
     * 修改
     */
    @PutMapping
    public AxiosResult<Void> update(@RequestBody  Dept Dept){
        return toAxios(deptService.update(Dept));
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable  Long id){
        return toAxios(deptService.deleteById(id));
    }


}
