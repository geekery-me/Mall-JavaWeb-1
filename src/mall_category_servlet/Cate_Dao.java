package mall_category_servlet;

import mall_basedao.CategoryBaseDao;
import mall_bean.Mall_Category;

import java.util.ArrayList;

public class Cate_Dao {
    /**
     * 查询所有分类数据
     * @return 分类列表
     */
    public static ArrayList<Mall_Category> selectAll(){
        String sql="select * from mall_category order by cate_id";
        ArrayList<Mall_Category> list=null;
        list = CategoryBaseDao.query(sql, null);
        return list;
    }

    public static int addCate(Mall_Category cate){
        int count=-1;
        String sql="insert into mall_category(cate_name,cate_parent_id) values(?,?)";
        count= CategoryBaseDao.update(sql, cate.getCate_name(), cate.getCate_parent_id());
        return count;
    }
    public static Mall_Category selectByID(int id){
        Mall_Category cate=null;
        String sql="select * from mall_category where cate_id=?";
        ArrayList<Mall_Category> list = CategoryBaseDao.query(sql, id);
        if (list!=null){
            cate=list.get(0);
        }
        return cate;
    }

    public static int updateByID(Mall_Category cate){
        int count=-1;
        String sql="update mall_category set cate_name=? ,cate_parent_id=? where cate_id=?";
        count = CategoryBaseDao.update(sql, cate.getCate_name(), cate.getCate_parent_id(),cate.getCate_id());
        return count;
    }

    public static int deleteByID(int id){
        int count=-1;
        String sql="delete from mall_category where cate_id=?";
        count = CategoryBaseDao.update(sql,id);
        return count;
    }


    public static ArrayList<Mall_Category> selectCate(String flag){
        String sql=null;
        ArrayList<Mall_Category> list=null;
        if (flag.equals("father")){
            sql="select * from mall_category where cate_parent_id=0 ";
        }else {
            sql="select * from mall_category where cate_parent_id!=0 "  ;
        }
        list = CategoryBaseDao.query(sql, null);
        return list;
    }
}
