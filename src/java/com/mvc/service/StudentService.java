/*
 * Author LiYang 7.10 
 * Test works
 */
package com.mvc.service;
import com.mvc.entity.Student;

import java.sql.*;   
import java.util.*;


class ConnectParam {
	private String driver; //db driver
	private String dburl; //db url
	private String dbuser; //user name
	private String dbpwd; //database password
	
	public void setdriver(String dr)
	{
		driver = dr;
	}
	
	public String getdriver()
	{
		return driver;
	}
	
	public void seturl(String url)
	{
		dburl = url;
	}
	
	public String geturl()
	{
		return dburl;
	}
	
	public void setdbuser(String user)
	{
		dbuser = user;
	}
	
	public String getdbuser()
	{
		return dbuser;
	}
	
	public void setdbpwd(String pwd)
	{
		dbpwd = pwd;
	}
	
	public String getdbpwd()
	{
		return dbpwd;
	}
}






public class StudentService {
	//初始化CP
	public ConnectParam setCP()
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String user = "root";
		// Java连接MySQL配置时的密码
		String password = "123456";
		ConnectParam CP = new ConnectParam();
		CP.setdriver(driver);
		CP.seturl(url);
		CP.setdbuser(user);
		CP.setdbpwd(password);
		return CP;
	}
	
	public Connection DBconn(ConnectParam CP)
	{
		try
		{
			Class.forName(CP.getdriver());
			// 连续数据库
			Connection conn = DriverManager.getConnection(CP.geturl(),CP.getdbuser(), CP.getdbpwd());
			return conn;
		}
		catch(Exception ex)
		{
			System.out.print("can not connect to db");
			return null;
		}
	}
	
	
	
	public void save(Student st)
	{
                System.out.println("run here!");
                System.out.println(st.getId());
		String sql = "insert into student values("+"'"+st.getId()+"'"+","+"'"+st.getUser()+"'"+","+"'"+st.getPsw()+"'"+");";
                //System.out.println(sql);
		StudentService sv = new StudentService();	
                //System.out.println("run here!");
	        sv.execute(sql);
	
	}
	
	public void update(Student st)
	{
		String sql = "update student set name="+"'"+st.getUser()+"'"+",psw="+"'"+st.getPsw()+"'"+" where id="+"'"+st.getId()+"'"+";";
		System.out.println(sql);
                StudentService sv = new StudentService();
		try{
			sv.execute(sql);
		}
		catch(Exception ex)
		{
			System.out.println("修改失败");
		}
	}
	
	public void delete(Student st)
	{
		String sql = "delete from student where id="+st.getId()+";";
                System.out.println(sql);
		StudentService sv = new StudentService();
		try{
			sv.execute(sql);
		}
		catch(Exception ex)
		{
			System.out.println("修改失败");
		}
	}
	
	public ResultSet createQuery(String sql)
	{
		try
		{
			StudentService sv = new StudentService();
			ConnectParam CP = sv.setCP();
			Connection conn = sv.DBconn(CP);
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 执行SQL语句
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		}
		catch(Exception ex)
		{
			  System.out.println("Can not connect to the database!");
			  return null;
		}
	}
	
        public Student getOneStudent(String id)
        {
            Student st =new Student();
            StudentService sv =new StudentService();
            String sql = "select * from student where id="+id;
            ResultSet rs = sv.createQuery(sql);
            try
            {
                while(rs.next())
                {
                    st.setId(rs.getString("id"));
                    st.setUser(rs.getString("name"));
                    st.setPsw(rs.getString("psw"));
                 }
            }
            catch(Exception ex)
            {
                System.out.println("Get one user failed");
            }
            return st;
        }
        
        
	public void execute(String query)
	{
		try
		{
			StudentService sv = new StudentService();
			ConnectParam CP = sv.setCP();
			Connection conn = sv.DBconn(CP);
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 执行SQL语句
                        //System.out.println("run here!");
                        //System.out.println(query);
                        statement.executeUpdate(query);
                        //conn.close();
			//statement.executeQuery(query);
                       
                        
		}
		catch(Exception ex)
		{
			  System.out.println("Can not connect to the database!!!");
		}
	}
	
	public static void main(String []args)
	{
		StudentService sv = new StudentService();
                Student st = new Student();
                //st.setId("3");
                //st.setUser("kate");
                //st.setPsw("123456");
                //sv.save(st);
                //sv.delete(st);
                //sv.update(st);
                st = sv.getOneStudent("2");
                System.out.println(st.getUser());
		//ResultSet rs = sv.createQuery("select * from student");
                //sv.execute("insert into student values('3','kitty','123456');");
                /*
		try
		{
			while(rs.next())
			{
				System.out.print(rs.getString("name")+"\n");
				System.out.print(rs.getString("psw"));
			}
		}
		catch(Exception ex)
		{
			System.out.print("can not get the result");
		}*/
	}
}