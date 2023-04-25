package java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.User;
import java.sql.*;

public class UserDao {
	
public static java.sql.Connection getConnection() {
Connection con=null;
try {
Class.forName("com.mysql.jdbc.Driver") ;
con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ck1?characterEncoding=utf8","root","SINGH");
} catch(Exception e){System.out.println(e);}
return con;
}
public static int save(User u) {
int status=0;
try {
java.sql.Connection con=getConnection();
PreparedStatement ps=con.prepareStatement("Insert into record(id,name,password,sex,country) values(?,?,?,?,?)");
ps.setInt(1,u.getId());
ps.setString(2,u.getName());
ps.setString(3,u.getPassword());
ps.setString(4,u.getSex());
ps.setString(5,u.getCountry());

status=ps.executeUpdate();
}catch(Exception e) {System.out.println(e);}
return status;
}
public static int delete(User u) {
int status=0;
try {
java.sql.Connection con=getConnection();
PreparedStatement ps=con.prepareStatement("delete from record where id=?");
ps.setInt(1,u.getId());
status=ps.executeUpdate();
}catch(Exception e) {System.out.println(e);}
return status;
}
public static ArrayList<User> getAllRecords() {
ArrayList<User> list=new ArrayList<User>();
try {
java.sql.Connection con=getConnection();
PreparedStatement ps=con.prepareStatement("select * from record");
ResultSet rs=ps.executeQuery();
while(rs.next()) {
User u=new User();
u.setId(rs.getInt("id"));
u.setName(rs.getString("name"));
u.setPassword(rs.getString("password"));
u.setSex(rs.getString("sex"));
u.setCountry(rs.getString("country"));
list.add(u);
}
}catch(Exception e) {System.out.println(e);}
return list;
}
public static User getRecordById(int id){
User u=null;
try {
java.sql.Connection con=getConnection();
PreparedStatement ps=con.prepareStatement("select * from record where id=? ");
ps.setInt(1, id);
ResultSet rs=ps.executeQuery();
while(rs.next()){
u=new User();
u.setId(rs.getInt("id"));
u.setName(rs.getString("name"));
u.setPassword(rs.getString("password"));
u.setSex(rs.getString("sex"));
u.setCountry(rs.getString("country"));
}
}catch(Exception e) {System.out.println(e);}
return u;

}
}