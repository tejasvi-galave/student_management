	package com.rt.contrl;

    import com.rt.entity.Student;
    import com.rt.service.StudentService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @Tag(name="student controler", description = "APIs for managing students")
    @RequestMapping ("/student")
    public class StudentController {

        @Autowired
        StudentService studentService;

        @PostMapping("/register")
        @Operation(summary = "Register a new student")
        public void add(@RequestBody Student st) {
             studentService.saveStudent(st);
        }

        @Operation(summary = "update studnet details")
        @PutMapping("/update")
        public Student updateStudent(@RequestBody Student st) {
            Student student = studentService.updateStudent(st);
            return student;
        }

        @GetMapping("/all")
        @Operation(summary = "Get all students")
        public ResponseEntity<List<Student>> allStudent() {
            List<Student> student = studentService.allStudent();
            return ResponseEntity.ok(student);
        }

        @Operation(summary = "Delete student by ID")
        @DeleteMapping("/delete-by-id/{id}")
        public Boolean deleteStudent(@PathVariable int id) {
        Boolean isDelete = studentService.deleteStudent(id);
        return isDelete;
        }
    }

