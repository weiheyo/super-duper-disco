import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DbUtil {
    /*
    1.添加学生
     */
    public static void addSome(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要添加的学生个数：");
        int number = input.nextInt();
        Connection c = getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into 学生 values(?,?,?)";
        try {
            pstmt = c.prepareStatement(sql);
            for(int i = 0;i<number;i++) {
                System.out.println("请输入学号：");
                int num = input.nextInt();
                System.out.println("请输入姓名：");
                String name = input.next();
                System.out.println("请输入班级：");
                String ban = input.next();
                pstmt.setInt(1, num);//为占位符赋值
                pstmt.setString(2, name);
                pstmt.setString(3, ban);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("添加成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(pstmt);
            DbUtil.close(c);
        }
    }
    /*
    2.删除学生
     */
    public static void deleteOne(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        int num = input.nextInt();
        String sql = "delete from 学生 where 学号=?";
        Connection c = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = c.prepareStatement(sql);
            pstmt.setInt(1,num);
            if(pstmt.executeUpdate()>0){//根据返回的影响到的数据的条数判断是否操作成功
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(pstmt);
            DbUtil.close(c);
        }
    }
    /*
    3.修改学生信息
     */
    public static void updateOne(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        int num = input.nextInt();
        System.out.println("请输入需要更改的信息：");
        System.out.println("1-姓名");
        System.out.println("2-班级");
        System.out.println("3-学号");
        int i = input.nextInt();
        String sql=null;
        if(i==1){
            sql = "update 学生 set 姓名=? where 学号=?";//根据需要更改的信息选择sql语句
        }
        if(i==2){
            sql = "update 学生 set 班级=? where 学号=?";
        }
        if(i==3){
            sql = "update 学生 set 学号=? where 学号=?";
        }
        Connection c = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = c.prepareStatement(sql);
            if(i==1){
                System.out.println("请输入更改后的姓名：");
                String str2 = input.next();
                pstmt.setString(1,str2);
            }
            if(i==2){
                System.out.println("请输入更改后的班级：");
                String str2 = input.next();
                pstmt.setString(1,str2);
            }
            if(i==3){
                System.out.println("请输入更改后的学号：");
                int num2 = input.nextInt();
                pstmt.setInt(1,num2);
            }
            pstmt.setInt(2,num);
            if(pstmt.executeUpdate()>0){//根据返回的影响到的数据的条数判断是否操作成功
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(pstmt);
            DbUtil.close(c);
        }
    }
    /*
    4.0选择如何查询
     */
    public static void querySome(){
        Scanner input = new Scanner(System.in);
        System.out.println("1-按学号查询");
        System.out.println("2-按姓名查询");
        System.out.println("3-按班级查询");
        int key2 = input.nextInt();
        if(key2==1){
            System.out.println("请输入学号：");
            try{//可能会有输入不匹配异常
                int num = input.nextInt();
                queryOneNum(num);
            } catch (InputMismatchException e){
                e.printStackTrace();
            }
        }
        if (key2==2){
            System.out.println("请输入姓名：");
            String name = input.next();
            queryOneName(name);
        }
        if (key2==3){
            System.out.println("请输入班级：");
            String ban = input.next();
            queryOneBan(ban);
        }
    }
    /*
    4.1按班级查询
     */
    public static void queryOneBan(String ban){
        String sql = "select * from 学生 where 班级=?";
        Connection c = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = c.prepareStatement(sql);
            pstmt.setString(1,ban);//为占位符赋值
            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("学号："+rs.getInt(1)+"  姓名："+rs.getString(2)+"  班级："+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs);
            DbUtil.close(pstmt);
            DbUtil.close(c);
        }
    }
    /*
    4.2按姓名查询
     */
    public static void queryOneName(String name){
        String sql = "select * from 学生 where 姓名=?";
        Connection c = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = c.prepareStatement(sql);
            pstmt.setString(1,name);//为占位符赋值
            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("学号："+rs.getInt(1)+"  姓名："+rs.getString(2)+"  班级："+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs);
            DbUtil.close(pstmt);
            DbUtil.close(c);
        }
    }
    /*
    4.3按学号查询
     */
    public static void queryOneNum(int num){
        String sql = "select * from 学生 where 学号=?";
        Connection c = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = c.prepareStatement(sql);
            pstmt.setInt(1,num);//为占位符赋值
            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("学号："+rs.getInt(1)+"  姓名："+rs.getString(2)+"  班级："+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs);
            DbUtil.close(pstmt);
            DbUtil.close(c);
        }
    }
    /*
    5.查询全部学生
     */
    public static void queryAll(){
        String sql = "select * from 学生";
        Connection c = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = c.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("学号："+rs.getInt(1)+"  姓名："+rs.getString(2)+"  班级："+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs);
            DbUtil.close(pstmt);
            DbUtil.close(c);
        }
    }
    /*
    连接的方法
     */
    public static Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//使用此驱动连接数据库
            String url = "jdbc:mysql://localhost:3306/学生管理系统?characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
            String user = "weihe";
            String password = "122328mysql@";
            c = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {                        //避免出现空指针异常
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}