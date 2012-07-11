/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author yang
 */
public class DeleteController extends AbstractController{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse arg1) throws Exception {    
        //System.out.println(request.getParameter("sid"));
        String student_id = request.getParameter("sid");
        StudentService sv = new StudentService();
        //construct a sql to the user from db:
        //String sql = "select * from student where id="+student_id;
        Student st = new Student();
        st = sv.getOneStudent(student_id);
        sv.delete(st);
        String url = "redirect:/show.do";
        return new ModelAndView(url);
    }
}