package com.rt.serviceImpl;

import com.rt.entity.Student;
import com.rt.repository.StudentRepository;
import com.rt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository StudentRepository;

	public void saveStudent(Student st) {
		 StudentRepository.save(st);
	}

	@Override
	public List<Student> allStudent() {
		List<Student> student = StudentRepository.findAll();
		if(!student.isEmpty()){
			return student;
		}
		else{
			return null;
		}
	}

	@Override
	public Student updateStudent(Student st) {
     Student student = StudentRepository.save(st);
	 return  student;
	}

	@Override
	public boolean deleteStudent(int id) {
		boolean exists = StudentRepository.existsById(id);
		if (exists) {
			StudentRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
