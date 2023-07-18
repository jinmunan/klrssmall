package com.klrss.klrssmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klrss.common.utils.PageUtils;
import com.klrss.klrssmall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 10:58:51
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

