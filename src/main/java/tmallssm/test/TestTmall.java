package tmallssm.test;

import java.sql.*;

public class TestTmall {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm_loc?useUnicode=true&characterEncoding=utf8","root", "admin");
            Statement s=c.createStatement();
        ){
            ResultSet rs=s.executeQuery("SELECT * FROM category");
            while (rs.next()){
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                System.out.println("id:"+id+",name:"+name);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
