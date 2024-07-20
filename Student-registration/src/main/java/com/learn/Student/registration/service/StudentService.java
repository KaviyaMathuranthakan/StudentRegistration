package com.learn.Student.registration.service;

import com.learn.Student.registration.domain.Student;
import com.learn.Student.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired

    private StudentRepository repo;

    public List<Student> listall(){
        return repo.findalll();
    }

    public void save(Student std){
        repo.save(std);
    }

    public Student get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }



}
