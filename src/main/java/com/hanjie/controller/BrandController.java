package com.hanjie.controller;

import com.hanjie.common.http.AxiosResult;
import com.hanjie.controller.base.BaseController;
import com.hanjie.domin.entity.Brand;

import com.hanjie.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
@RequiredArgsConstructor//和@Autowired效果一样
public class BrandController extends BaseController {


    private final BrandService brandService;

    /**
     *查询所有
     */
    @GetMapping
    public AxiosResult<List<Brand>> list(){
        List<Brand> list = brandService.list();
        return AxiosResult.success(list);
    }

    /**
     * 根据id查询
     */
    @GetMapping("{id}")
    public AxiosResult<Brand> findById(@PathVariable Long id){
        Brand byId = brandService.getById(id);
        return AxiosResult.success(byId);
    }
    /**
     *添加
     */
    @PostMapping
    public AxiosResult<Void> add(@RequestBody  Brand Brand){
        return toAxios(brandService.save(Brand));
    }

    /**
     * 修改
     */
    @PutMapping
    public AxiosResult<Void> update(@RequestBody  Brand Brand){
        return toAxios(brandService.update(Brand));
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable  Long id){
        return toAxios(brandService.deleteById(id));
    }


}
