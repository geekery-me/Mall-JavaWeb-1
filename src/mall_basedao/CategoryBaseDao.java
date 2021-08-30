package mall_basedao;

import mall_bean.Mall_Category;
import utils.Jdbc_util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;


public class CategoryBaseDao {
    /**
     * 数据的增删改即更新
     * @return 修改的条数
     */
    public static int update(String sql,Object...objects)  {

        PreparedStatement ps=null;
        Connection conn=null;
        try {
            conn= Jdbc_util.getConn();
            ps=conn.prepareStatement(sql);
            for (int i=0;i<objects.length;i++){
                ps.setObject(i+1, objects[i]);

            }
            int count = ps.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Jdbc_util.close(conn,ps,null);
        }
        return -1;
    }




    public static ArrayList<Mall_Category> query(String sql,Object...objects){
        ArrayList<Mall_Category> list=null;
        PreparedStatement ps=null;
        Connection conn=null;
        ResultSet rs=null;
        ResultSetMetaData rsmd=null;
        try {
            conn = Jdbc_util.getConn();
            ps  = conn.prepareStatement(sql);
            if (objects!=null){
                for (int i=0;i<objects.length;i++){
                    ps.setObject(i+1,objects[i]);
                }
            }

            rs = ps.executeQuery();//结果集
            rsmd = rs.getMetaData();//元数据
            list=new ArrayList<>();
            int count = rsmd.getColumnCount();//获取列数
            while(rs.next()) {
                //每一行都创建一个对象
                Mall_Category mall_category = Mall_Category.class.newInstance();
                for (int i = 0; i < count; i++) {
                    Object args = rs.getObject(i + 1);
                    //获取每一个列的名字
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //获取属性
                    Field f = mall_category.getClass().getDeclaredField(columnLabel);
                    f.setAccessible(true);
                    f.set(mall_category, args);
                }
                list.add(mall_category);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Jdbc_util.close(conn,ps,rs);
        }
        return null;

    }

}
