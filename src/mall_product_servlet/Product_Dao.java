package mall_product_servlet;

import mall_basedao.ProductBaseDao;
import mall_bean.Mall_Product;
import utils.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product_Dao extends Mall_Product {

    /**
     * 添加商品
     * @return 修改记录数
     */
    public static int addProduct(Mall_Product product){
        int count=-1;
        String sql="insert into mall_product(product_name,product_descrption,product_price,product_stock,product_fid,product_cid,product_filename)"
                +"values(?,?,?,?,?,?,?)";
        count = ProductBaseDao.update(sql, product.getProduct_name(), product.getProduct_descrption(), product.getProduct_price(), product.getProduct_stock(), product.getProduct_fid(), product.getProduct_cid(),product.getProduct_filename());
        return count;
    }


    /**
     * 获取总记录数和总页数
     * @return 数组的第一个数是总记录数
     */
    public static int[] totalPage(int count,String keyword){
        int arr[] ={0,1};

        Connection conn = Jdbc_util.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="";

        try{
            if (keyword!=null){
                keyword="%"+keyword+"%";
                sql="select count(*) from mall_product where product_name like ?";
                ps = conn.prepareStatement(sql);
                ps.setObject(1,keyword);
                rs =ps.executeQuery();
            }else {
                sql="select count(*) from mall_product";
                ps = conn.prepareStatement(sql);
                rs =ps.executeQuery();
            }
            while (rs.next()) {
                arr[0] = rs.getInt(1);
                if (arr[0] % count == 0) {
                    arr[1] = arr[0] / count;
                } else {
                    arr[1] = arr[0] / count + 1;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return arr;
    }


    public static ArrayList<Mall_Product> queryAll(int cpage, int count, String keyword) {



        String sql="";
        ArrayList<Mall_Product> list=null;
        if (keyword!=null){
            keyword="%"+keyword+"%";
            sql="select * from mall_product where product_name like ? order by product_id limit ?,?";
            list = ProductBaseDao.query(sql,keyword,(cpage-1)*count,count);
        }else{
            sql="select * from mall_product order by product_id limit ?,?";
            list = ProductBaseDao.query(sql,(cpage-1)*count,count);
        }
        return list;
    }

    public static int deleteById(int id){
        int count=-1;
        String sql="delete from mall_product where product_id=?";
        count = ProductBaseDao.update(sql, id);
        return count;
    }

    public static int updateByProduct(Mall_Product p){
        int count=-2;
        String sql="update mall_product set product_name=?,product_fid=?,product_cid=?,product_descrption=?,product_stock=?,product_price=?,product_filename=? where product_id=?";
        count = ProductBaseDao.update(sql, p.getProduct_name(), p.getProduct_fid(), p.getProduct_cid(), p.getProduct_descrption(), p.getProduct_stock(), p.getProduct_price(), p.getProduct_filename(),p.getProduct_id());
        return count;
    }

    public static ArrayList<Mall_Product>  seleteByFidOrCid(String flag,int[] id){
        ArrayList<Mall_Product> query=null;
        String sql=null;
        if (flag.equals("fid")){
            sql="select * from mall_product where product_fid=?";
            query = ProductBaseDao.query(sql, id[0]);
        }else {
            sql="select * from mall_product where product_cid=?";
            query = ProductBaseDao.query(sql, id[1]);
        }
        return query;
    }

    public static Mall_Product seleteById(int id){
        Mall_Product product=null;
        String sql="select * from mall_product where product_id=?";
        ArrayList<Mall_Product> query = ProductBaseDao.query(sql, id);
        if (query.size()>0){
            product=query.get(0);
        }
        return product;
    }

    public static ArrayList<Mall_Product> selectMoreByIds(ArrayList<Integer> ids){
        ArrayList<Mall_Product> products=new ArrayList<>();
        for (int id : ids) {
            Mall_Product product = Product_Dao.seleteById(id);
            if(product!=null){
                products.add(product);
            }
        }

        return products;
    }

}
