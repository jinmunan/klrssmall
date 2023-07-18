package com.klrss.klrssmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klrss.common.utils.PageUtils;
import com.klrss.klrssmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 12:56:21
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

