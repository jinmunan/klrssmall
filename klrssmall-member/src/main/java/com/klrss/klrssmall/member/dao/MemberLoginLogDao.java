package com.klrss.klrssmall.member.dao;

import com.klrss.klrssmall.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 12:52:33
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
