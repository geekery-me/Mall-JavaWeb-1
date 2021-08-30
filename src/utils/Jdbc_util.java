package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc_util {
    //用静态代码块的方法初始化连接池

    private static DataSource source;
    static{
        try {
            Properties pros=new Properties();
            InputStream is = Jdbc_util.class.getClassLoader().getResourceAsStream("utils/druid.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
            System.out.println(source);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConn()  {
        Connection conn=null;
        try {
            conn=source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){

        try{
            if(rs !=null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(ps !=null){
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn !=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
