package com.hanjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanjie.common.page.PageResult;
import com.hanjie.domin.criteria.MenuCriteria;
import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.entity.Menu;
import com.hanjie.domin.vo.MenuVo;
import com.hanjie.service.AdminService;
import com.hanjie.service.MenuService;
import com.hanjie.service.base.impl.BaseServiceimpl;
import com.hanjie.transfer.MenuTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceimpl extends BaseServiceimpl<Menu> implements MenuService {

    private final MenuTransfer menuTransfer;

    /**
     *获得所有的菜单  分页情况
     */
    @Override
    public PageResult<MenuVo> getMenuTree(MenuCriteria menuCriteria) {
        //分页开启
        PageHelper.startPage(menuCriteria.getCurrentPage(), menuCriteria.getPageSize());
        //条件查询拿到数据
        List<Menu> root = this.search(new QueryWrapper<Menu>().lambda().eq(Menu::getParentId, 0));
        //放到PageInfo
        PageInfo<Menu> pageInfo = new PageInfo<>(root);
        //转换vo
        List<MenuVo> rootVo = menuTransfer.toVO(root);
        //进行排序
        Collections.sort(rootVo, (t, t1) -> t.getMenuSort() - t1.getMenuSort());
        // 条件查询 并找孩子  找二级数据
        // ne 条件getParentId 不等于 0的数据
        List<Menu> other = this.search(new QueryWrapper<Menu>().lambda().ne(Menu::getParentId, 0));
        List<MenuVo> otherVo = menuTransfer.toVO(other);
        //在不等于 0 的一级数据中找孩子
        rootVo.forEach(item -> getChildren(item, otherVo));
        return new PageResult<MenuVo>(pageInfo.getTotal(), rootVo);





    }

    /**
     *获得所有的菜单  无分页
     */
    @Override
    public List<MenuVo> getAllMenuTree() {
        //获得当前的所有信息
        List<Menu> list = this.list();
        //根据sorted进行排序
        List<Menu> root = list.stream().filter(item -> item.getParentId().longValue() == 0).sorted((t, t1) -> t.getMenuSort() - t1.getMenuSort()).collect(Collectors.toList());
        //删除一个集合中 存在另一个集合中的元素的数据
        list.removeAll(root);
        //转换
        List<MenuVo> menuVos = menuTransfer.toVO(list);
        List<MenuVo> rootVo = menuTransfer.toVO(root);
        //找二级 数据 并且遍历一层删一层
        rootVo.forEach(item->getChildren(item,menuVos));
        return rootVo;

    }


    /**
     * 找孩子
     */
    public void getChildren(MenuVo menuVo, List<MenuVo> list) {
        List<MenuVo> second = list.stream().filter(item -> item.getParentId().longValue() == menuVo.getId().longValue()).sorted((t, t1) -> t.getMenuSort() - t1.getMenuSort()).collect(Collectors.toList());
        if (second != null && second.size() > 0) {
            menuVo.setChildren(second);
            list.removeAll(second);
            second.forEach(item -> {
                getChildren(item, list);
            });

        }

    }
}
