package edu.zhaosx.studentmanager.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import edu.zhaosx.studentmanager.Student;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Queue;

public class JDBCUtils {

    private static DataSource source;
    static {
        try {
            Properties properties = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("edu/zhaosx/studentmanager/ini/druid.ini");
            properties.load(is);
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    public static void closeConnection(Connection conn){
        try {
            DbUtils.close(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static ResultSet res;
    static {

    }
    public static ResultSet getResult(){
        return res;
    }

    public static int insertDate(String table,Student student){
        Connection conn = null;
        int insertCount = 0;
        try {
            QueryRunner queryRunner = new QueryRunner();
            conn = JDBCUtils.getConnection();
            String sql = "insert into ?(id,name,age)values(?,?,?)";
            insertCount  =queryRunner.update(conn,sql,table,student.id,student.name,student.school);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return insertCount;
    }

    public static int deleteDate(String table,String id){
        Connection conn = null;
        int insertCount = 0;
        try {
            QueryRunner queryRunner = new QueryRunner();
            conn = JDBCUtils.getConnection();
            String sql = "delete from ? where id in (?)";
            insertCount  =queryRunner.update(conn,sql,table,id);
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return insertCount;
    }

    public static List<Object> searchDate(String table,Student s){
        Connection conn = null;
        List<Object> list = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,school from ? where id = ? and name = ? and school = ?";
            BeanListHandler<Object>handler = new BeanListHandler<>(Object.class);
            list = runner.query(conn,sql,handler);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return list;
    }


}
