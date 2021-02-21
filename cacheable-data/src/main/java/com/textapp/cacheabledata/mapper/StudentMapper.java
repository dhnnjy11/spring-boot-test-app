package com.textapp.cacheabledata.mapper;

import com.textapp.cacheabledata.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM students")
    public List<Student> getStudents();
}
