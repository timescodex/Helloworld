/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import java.sql.*; 
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author yang
 */

@Controller
@RequestMapping("/zhujie")
public class TestController
{
    @RequestMapping(value="/show",method=RequestMethod.GET)
    public ModelAndView show()
    {
        //show the first page:
        Map mp =new HashMap();
        StudentService sv = new StudentService();
        ResultSet list = sv.createQuery("select * from student;");
	List<Student> users = new ArrayList<Student>();
	Student user;
        try
        {
            while(list.next()){
                user = new Student();
                user.setId(list.getString("id"));
                user.setUser(list.getString("name"));
                user.setPsw(list.getString("psw"));
                users.add(user);
            }
        }
        catch(Exception ex)
        {
            System.out.println("show part");
        }
        
        
        mp.put("users",users);
        Iterator iter = mp.entrySet().iterator(); 
        return new ModelAndView("showstudent",mp);
    }
    
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public ModelAndView add()
    {
        //String url = "redirect:/zhujie/save";
        return new ModelAndView("addstudent");
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request)
    {
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String psw = request.getParameter("psw");
        Student st = new Student();
        st.setId(number);
        st.setUser(name);
        st.setPsw(psw);
        StudentService sv = new StudentService();
        sv.save(st);
        String url = "redirect:/zhujie/show.do";
        return new ModelAndView(url);
    }
    
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request)
    {
        String number  = request.getParameter("sid");
        StudentService sv = new StudentService();
        Student st = sv.getOneStudent(number);
        //String url = "redirect:/zhujie/updatesave";
        return new ModelAndView("updatestudent","student",st);
    }
    
    @RequestMapping(value="/updatesave",method = RequestMethod.POST)
    public ModelAndView updatesave(HttpServletRequest request)
    {
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String psw = request.getParameter("psw");
        Student st = new Student();
        st.setId(number);
        st.setUser(name);
        st.setPsw(psw);
        StudentService sv = new StudentService();
        sv.update(st);
        String url="redirect:/zhujie/show.do";
        return new ModelAndView(url);
    }
    
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request)
    {
        String number = request.getParameter("sid");
        StudentService sv = new StudentService();
        Student st = sv.getOneStudent(number);
        sv.delete(st);
        String url="redirect:/zhujie/show.do";
        return new ModelAndView(url);
    }
    
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request)
    {
        Map mp =new HashMap();
        String student_id = request.getParameter("search_sid");
        StudentService sv = new StudentService();
        Student st = sv.getOneStudent(student_id);
	List<Student> users = new ArrayList<Student>();
        users.add(st);
        mp.put("users",users);
        return new ModelAndView("showstudent",mp);
    }
    
    //@RequestMapping("/start/{name}/{age}")
    /*
    public String start(@PathVariable("name") String name,@PathVariable("age") int age)
    {
        System.out.println("姓名：" + name + ", 年龄：" + age);
        return "start";
    }
    @RequestMapping(value="/linda", method=RequestMethod.GET)
    public ModelAndView getMethod()
    {
        return new ModelAndView("index","msg","Test!!!!");
        //return "index";
    }
    @RequestMapping(value="/linda", method=RequestMethod.POST)
    public String postMethod()
    {
        return "postPage";
    }*/
}
