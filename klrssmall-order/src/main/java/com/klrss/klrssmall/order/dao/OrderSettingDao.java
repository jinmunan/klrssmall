package com.klrss.klrssmall.order.dao;

import com.klrss.klrssmall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 12:56:22
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
