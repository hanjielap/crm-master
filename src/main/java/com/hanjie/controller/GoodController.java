package com.hanjie.controller;

import com.hanjie.common.http.AxiosResult;
import com.hanjie.controller.base.BaseController;
import com.hanjie.domin.entity.Good;
import com.hanjie.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("good")
@RequiredArgsConstructor//和@Autowired效果一样
public class GoodController extends BaseController {


    private final GoodService goodService;

    /**
     *查询所有
     */
    @GetMapping
    public AxiosResult<List<Good>> list(){
        List<Good> list = goodService.list();
        return AxiosResult.success(list);
    }

    /**
     * 根据id查询
     */
    @GetMapping("{id}")
    public AxiosResult<Good> findById(@PathVariable Long id){
        Good byId = goodService.getById(id);
        return AxiosResult.success(byId);
    }
    /**
     *添加
     */
    @PostMapping
    public AxiosResult<Void> add(@RequestBody  Good Good){
        return toAxios(goodService.save(Good));
    }

    /**
     * 修改
     */
    @PutMapping
    public AxiosResult<Void> update(@RequestBody  Good Good){
        return toAxios(goodService.update(Good));
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable  Long id){
        return toAxios(goodService.deleteById(id));
    }


}
