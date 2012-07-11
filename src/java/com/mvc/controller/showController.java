/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

/**
 *
 * @author yang
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import java.util.*;
import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import java.sql.*;  

public class showController extends AbstractController {
@Override
protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        ModelAndView showmav = new ModelAndView("showstudent");
        Map mp =new HashMap();
        StudentService sv = new StudentService();
        ResultSet list = sv.createQuery("select * from student;");
	List<Student> users = new ArrayList<Student>();
	Student user;
	while(list.next()){
            user = new Student();
            user.setId(list.getString("id"));
            user.setUser(list.getString("name"));
            user.setPsw(list.getString("psw"));
            users.add(user);
	}
        
        
        mp.put("users",users);
        Iterator iter = mp.entrySet().iterator(); 
        while (iter.hasNext()) { 
              Map.Entry entry = (Map.Entry) iter.next(); 
              Object key = entry.getKey(); 

              Object val = entry.getValue(); 
              System.out.print(key);
              System.out.print(val);
              
        } 
        return new ModelAndView("showstudent",mp);
    }
}