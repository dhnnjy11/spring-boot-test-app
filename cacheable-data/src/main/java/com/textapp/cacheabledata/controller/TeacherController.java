package com.textapp.cacheabledata.controller;

import com.textapp.cacheabledata.entity.Student;
import com.textapp.cacheabledata.service.StudentService;
import com.textapp.cacheabledata.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class TeacherController
{

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public String findAllTeachers() throws ExecutionException, InterruptedException {
      log.info("get all teacher list");
        return teacherService.getAllTeachers();
    }

    @GetMapping("/")
    public String hello(){
        return "Welcome to demo cacheable application!";
    }
}
