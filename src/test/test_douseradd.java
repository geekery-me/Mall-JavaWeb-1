package test;

import utils.Jdbc_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test_douseradd {
    public static void main(String[] args) {

                PreparedStatement ps=null;
                Connection conn=null;
                try {
                    conn= Jdbc_util.getConn();
                    conn.setAutoCommit(false);
                    String sql="insert into mall_user values(?,?,?,?,?,?,?,?,?,?)";
                    ps=conn.prepareStatement(sql);
                    for (int i=51;i<=100;i++){
                       ps.setObject(1,i+1);
                       ps.setObject(2,i+1+"迪丽热巴");
                       ps.setObject(3,i+1+"password");
                       ps.setObject(4,"F");
                       ps.setObject(5,i+1+"Date");
                       ps.setObject(6,null);
                       ps.setObject(7,i+1+"qq.com");
                       ps.setObject(8,i+1+"phone");
                       ps.setObject(9,i+1+"古墓");
                       ps.setObject(10,1);

                       ps.addBatch();
                       if (i%50==0){
                           ps.executeBatch();
                           ps.clearBatch();
                       }

                    }

                    conn.commit();

                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    Jdbc_util.close(conn,ps,null);
                }

    }
}
