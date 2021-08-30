package mall_user_servlet;

import mall_basedao.UserBaseDao;
import mall_bean.Mall_User;
import utils.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User_dao extends UserBaseDao implements UserDao {
    @Override
    public  int adduser(Mall_User user) {

        String sql="insert into mall_user values(?,?,?,?,?,?,?,?,?,?)";
        String user_id = user.getUser_id();
        String user_name = user.getUser_name();
        String user_password = user.getUser_password();
        String user_sex = user.getUser_sex();
        String user_birthday = user.getUser_birthday();
        String user_email = user.getUser_email();
        String user_phone = user.getUser_phone();
        String user_address = user.getUser_address();
        int count = UserBaseDao.update(sql,user_id,user_name,user_password,user_sex, user_birthday,null,user_email,user_phone,user_address,1);
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
                sql="select count(*) from mall_user where user_name like ?";
                ps = conn.prepareStatement(sql);
                ps.setObject(1,keyword);
                rs =ps.executeQuery();
            }else {
                sql="select count(*) from mall_user";
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

    public int deleteByID(String user_id){
        int count =0;
        String sql="delete from mall_user where user_id=? and user_status=1";
        count = UserBaseDao.update(sql, user_id);
        return count;
    }
    @Override
    public int deleteusers(Object...objects) {
        int count =0;
        return count;
    }

    @Override
    public int updateuser(Object...objects) {

        int count=0;
        String sql="update `mall_user` set user_name=?,user_password=?, user_sex=? ,user_birthday=? ,user_email=? ,user_phone=? ,user_address=? where user_id=?";

        count  = UserBaseDao.update(sql, objects);
        return count;
    }

    public Mall_User queryUserByID(String user_id){
        Mall_User user=null;
        String sql="select * from mall_user where user_id=?";
        if (UserBaseDao.query(Mall_User.class,sql,user_id).size()!=0){
            user= UserBaseDao.query(Mall_User.class, sql, user_id).get(0);
        }
        return user;
    }

    public int login(String user_id,String user_password){
        int count=-1;
        Mall_User mall_user=null;
        String sql="select count(*) from mall_user where user_id=? and user_password=?";
        try {
            Connection conn = Jdbc_util.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ps.setString(2,user_password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public ArrayList<Mall_User> queryAll(int cpage, int count, String keyword) {



        String sql="";
        ArrayList<Mall_User> list=null;
        if (keyword!=null){
            keyword="%"+keyword+"%";
            sql="select * from mall_user where user_name like ? order by user_id limit ?,?";
            list = UserBaseDao.query(Mall_User.class, sql,keyword,(cpage-1)*count,count);
        }else{
            sql="select * from mall_user order by user_id limit ?,?";
            list = UserBaseDao.query(Mall_User.class, sql,(cpage-1)*count,count);
        }
        return list;
    }
}
