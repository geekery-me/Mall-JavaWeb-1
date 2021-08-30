package mall_basedao;

import mall_bean.Mall_Cart;
import utils.Jdbc_util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class CartBaseDao {
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




    public static ArrayList<Mall_Cart> query(String sql, Object...objects){
        ArrayList<Mall_Cart> list=null;
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
                Mall_Cart cart = Mall_Cart.class.newInstance();
                for (int i = 0; i < count; i++) {
                    Object args = rs.getObject(i + 1);
                    //获取每一个列的名字
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    if(columnLabel.equals("cart_p_price")){
                        args=Double.valueOf(args.toString());
                    }
                    if(columnLabel.equals("cart_p_stock")||columnLabel.equals("cart_p_id")||columnLabel.equals("cart_quantity")){
                        args=Integer.valueOf(args.toString());
                    }
                    //获取属性
                    Field f = cart.getClass().getDeclaredField(columnLabel);
                    f.setAccessible(true);
                    f.set(cart, args);
                }
                list.add(cart);
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
