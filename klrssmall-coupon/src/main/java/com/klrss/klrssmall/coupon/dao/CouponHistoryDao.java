package com.klrss.klrssmall.coupon.dao;

import com.klrss.klrssmall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 12:43:29
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
