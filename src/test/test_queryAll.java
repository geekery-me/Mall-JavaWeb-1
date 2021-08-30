package test;

import mall_basedao.UserBaseDao;
import mall_bean.Mall_User;

import java.util.ArrayList;

public class test_queryAll {
    public static void main(String[] args) {
        String sql="select user_id from mall_user where user_name=? ";
        ArrayList<Mall_User> user = UserBaseDao.query(Mall_User.class, sql, "小龙女");
        System.out.println(user.size());
    }
}
