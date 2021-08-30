package mall_basedao;

import utils.Jdbc_util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class UserBaseDao {



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

    /**
     * 通用查询操作
     * @param clazz 实体 的类
     * @param <T> 实体的类
     * @return 查到的结果集
     */
    public static <T> ArrayList<T> query(Class<T> clazz, String sql, Object...objects){
        PreparedStatement ps=null;
        Connection conn=null;
        ResultSet rs=null;
        ArrayList<T> list=null;

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
                T t=clazz.newInstance();
                for (int i = 0; i < count; i++) {
                    Object args = rs.getObject(i + 1);
                    //获取每一个列的名字
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //获取属性
                    Field f = clazz.getDeclaredField(columnLabel);
                    if (columnLabel.equals("user_status")){
                        args=Integer.valueOf(args.toString());
                    }
                    f.setAccessible(true);
                    f.set(t, args);
                }
                list.add(t);
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
