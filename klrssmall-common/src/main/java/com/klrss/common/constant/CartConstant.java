package com.klrss.common.constant;

/**
 * 购物车常量
 *
 * @author zhongnan
 */
public class CartConstant {
    /**
     * 购物车临时用户 COOKIE
     */
    public static final String TEMP_USER_COOKIE_NAME = "user-key";
    /**
     * 购物车临时用户 COOKIE 过期时间
     */
    public static final int TEMP_USER_COOKIE_TIME_OUT = 60 * 60 * 24 * 30;

    public final static String CART_PREFIX = "kkmall:cart:";
}
