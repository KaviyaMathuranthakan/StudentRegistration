package com.learn.Student.registration.controller;


import com.learn.Student.registration.domain.Student;
import com.learn.Student.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;


    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Student> liststudent = service.listall();
        model.addAttribute("liststudent",
                liststudent);
        System.out.println("Get/");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("student",new Student());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student")Student std){
        service.save(std);
        return"redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Student std = service.get(id);
        mav.addObject("student", std);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}
