package com.flyer.springboot.rest.data;

import com.flyer.springboot.rest.domain.User;
import com.vip.vjtools.vjkit.number.RandomUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class UserData {

    public static List<User> generatList(int num, boolean withId) {
        List<User> resultList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            resultList.add(generatOne(withId, null));
        }
        return resultList;
    }

    public static User generatOne(boolean withId) {
        return generatOne(withId, null);
    }

    public static User generatOneWithGivenId(Long withGivenId) {
        return generatOne(false, withGivenId);
    }

    private static User generatOne(boolean withId, Long withGivenId) {
        User user = new User();
        if (withId) {
            user.setId(RandomUtil.nextLong());
        } else {
            if (withGivenId != null) {
                user.setId(withGivenId);
            }
        }

        user.setAddTime(new Date());
        user.setOpenId("open_id_" + RandomUtil.randomStringFixLength(20));
        user.setUnionId("union_id_" + RandomUtil.randomStringFixLength(2));
        user.setCellphone("cellphone_" + RandomUtil.randomStringFixLength(20));
        user.setWechat("wechat_" + RandomUtil.randomStringFixLength(20));
        user.setNickName("nick_name_" + RandomUtil.randomStringFixLength(20));
        user.setCountry("country_" + RandomUtil.randomStringFixLength(20));
        user.setLanguage("language_" + RandomUtil.randomStringFixLength(20));
        user.setProvince("province_" + RandomUtil.randomStringFixLength(20));
        user.setCity("city_" + RandomUtil.randomStringFixLength(20));
        user.setSex(RandomUtil.nextInt(10));
        user.setHeadImgUrl("head_img_url_" + RandomUtil.randomStringFixLength(20));
        user.setRemark("remark_" + RandomUtil.randomStringFixLength(20));
        return user;
    }
}
