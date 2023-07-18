package com.klrss.klrssmall.coupon.dao;

import com.klrss.klrssmall.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 12:43:30
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
