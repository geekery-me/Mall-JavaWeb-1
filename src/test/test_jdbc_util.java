package test;

import utils.Jdbc_util;

import java.sql.Connection;

public class test_jdbc_util {
    public static void main(String[] args){
        Connection conn = Jdbc_util.getConn();
        System.out.println(conn);
    }
}
