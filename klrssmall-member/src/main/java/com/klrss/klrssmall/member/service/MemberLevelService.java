package com.klrss.klrssmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klrss.common.utils.PageUtils;
import com.klrss.klrssmall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 12:52:33
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

