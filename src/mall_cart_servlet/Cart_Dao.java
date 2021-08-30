package mall_cart_servlet;

import mall_basedao.CartBaseDao;
import mall_bean.Mall_Cart;

import java.util.ArrayList;

public class Cart_Dao {

    public static int cartAdd(Mall_Cart c){
        int count =-1;
        String sql="insert into mall_cart values(null,?,?,?,?,?,?,?,?)";
        count = CartBaseDao.update(sql, c.getCart_p_filename(), c.getCart_p_name(), c.getCart_p_price(), c.getCart_p_stock(), c.getCart_p_id(), c.getCart_quantity(), c.getCart_u_id(), c.getCart_valid());
        return count;
    }


    /**
     * 通过用户id查
     * @param id 用户id
     * @return
     */
    public static ArrayList<Mall_Cart> selectAll(String id){
        ArrayList<Mall_Cart> carts=null;
        String sql="select * from mall_cart where cart_valid=1 and cart_u_id=? order by  cart_id desc";
        carts= CartBaseDao.query(sql,id);
        return carts;
    }


    public static Mall_Cart selectCartByPidAndUid(String uid,int pid){
        Mall_Cart cart=null;
        String sql="select * from mall_cart where cart_p_id=? and cart_u_id=?";
        ArrayList<Mall_Cart> query = CartBaseDao.query(sql, pid, uid);
        if (query.size()>0){
            cart=query.get(0);
        }
        return cart;
    }

    public static int updateByid(int cart_id, int newcount){
        int count=-1;
        String sql="update mall_cart set cart_quantity=? where cart_id=?";
        count = CartBaseDao.update(sql, newcount, cart_id);
        return count;
    }


    public static int deleteById(int id){
        int count=-1;
        String sql="delete from mall_cart where cart_id=?";
        count = CartBaseDao.update(sql, id);
        return count;
    }

    public static Mall_Cart selectByCartId(int id){
        Mall_Cart cart=null;
        String sql="select * from mall_cart where cart_id=?";
        ArrayList<Mall_Cart> query =null;
        query = CartBaseDao.query(sql,id);
        if (query!=null){
            cart=query.get(0);
        }
        return cart;
    }
}
