package com.textapp.cacheabledata.service;

import com.textapp.cacheabledata.entity.Student;
import com.textapp.cacheabledata.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    final private StudentMapper studentMapper;

    @Cacheable(value="student", key = "#id", condition = "#id > 2")
    public Student getStudentByID(int id){
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*2);
            Student studentData = geStudentData().stream().filter(x->x.getId() == id).findAny().get();
            return studentData;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return new Student(1,"Jay");
    }

    private List<Student> geStudentData(){
        List<Student> students = new ArrayList<>();
        students = studentMapper.getStudents();
        return students;
    }
}
