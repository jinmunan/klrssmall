package com.klrss.klrssmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klrss.common.utils.PageUtils;
import com.klrss.klrssmall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 10:58:51
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 树形结构展示三级分类列表
     */
    List<CategoryEntity> listWithTree();

    /**
     * 批量删除
     */
    void removeMenuByIds(List<Long> asList);
}

