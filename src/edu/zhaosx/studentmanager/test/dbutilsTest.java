package edu.zhaosx.studentmanager.test;

import edu.zhaosx.studentmanager.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class dbutilsTest {
    public static void add(){
        Connection conn = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            conn = JDBCUtils.getConnection();
            String sql = "insert into stu(id,name,age)values(?,?,?)";
            int insertCount  =queryRunner.update(conn,sql,"1009","NAME_9",9);
            System.out.println(insertCount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        add();
    }
}
