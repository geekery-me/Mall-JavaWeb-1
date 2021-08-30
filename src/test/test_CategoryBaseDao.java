package test;

import mall_basedao.CategoryBaseDao;
import mall_bean.Mall_Category;

import java.util.ArrayList;

public class test_CategoryBaseDao {
    public static void main(String[] args) {
        String sql="select * from mall_category";
        ArrayList<Mall_Category> list = CategoryBaseDao.query(sql, null);
        System.out.println(list);
    }
}
