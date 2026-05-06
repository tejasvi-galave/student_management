package com.rt.service;

import com.rt.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

	void saveStudent(Student st);

	Student updateStudent(Student st);

	List<Student> allStudent();

	boolean deleteStudent(int id);

}
