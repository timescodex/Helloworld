/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import java.sql.ResultSet;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

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

public class SearchController extends AbstractController {
@Override
protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
        Map mp =new HashMap();
        String student_id = request.getParameter("search_sid");
        StudentService sv = new StudentService();
        Student st = new Student();
        st = sv.getOneStudent(student_id);
	List<Student> users = new ArrayList<Student>();
        users.add(st);
        mp.put("users",users);
        return new ModelAndView("showstudent",mp);
    }
}