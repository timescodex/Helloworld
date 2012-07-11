/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;
import com.mvc.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author yang
 */

public class AddController extends AbstractController{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        return new ModelAndView("addstudent");
    }
 
}
