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
public class updateSaveController  extends AbstractController{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String psw = request.getParameter("psw");
        //System.out.println(name);
        Student st = new Student();
        st.setId(number);
        st.setUser(name);
        st.setPsw(psw);
        StudentService sv = new StudentService();
        sv.update(st);
        String url = "redirect:/show.do";
        return new ModelAndView(url);  
    }

}