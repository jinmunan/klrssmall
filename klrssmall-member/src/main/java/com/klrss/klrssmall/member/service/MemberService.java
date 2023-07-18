package com.klrss.klrssmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klrss.common.utils.PageUtils;
import com.klrss.klrssmall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author zhongnan
 * @email zn923042857@gmail.com
 * @date 2023-06-19 12:52:33
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

