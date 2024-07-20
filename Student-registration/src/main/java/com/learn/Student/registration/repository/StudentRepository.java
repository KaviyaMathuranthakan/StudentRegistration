package com.learn.Student.registration.repository;

import com.learn.Student.registration.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {


    List<Student> findalll();
}
