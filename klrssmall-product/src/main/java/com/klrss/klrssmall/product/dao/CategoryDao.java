package com.klrss.klrssmall.product.dao;

import com.klrss.klrssmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 10:58:51
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
