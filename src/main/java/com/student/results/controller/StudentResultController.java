package com.student.results.controller;

import com.student.results.entity.StudentResult;
import com.student.results.service.StudentResultService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentResultController {

    private final StudentResultService studentResultService;

    // Constructor Injection
    public StudentResultController(StudentResultService studentResultService) {
        this.studentResultService = studentResultService;
    }


    // 1. Get all students
    // GET http://localhost:8080/api/students
    @GetMapping
    public List<StudentResult> getAllStudents() {
        return studentResultService.getAllStudents();
    }


    // 2. Get student by roll number
    // GET http://localhost:8080/api/students/roll/STU001
    @GetMapping("/roll/{rollNumber}")
    public StudentResult getStudentByRollNumber(
            @PathVariable String rollNumber) {

        return studentResultService.getStudentByRollNumber(rollNumber);
    }


    // 3. Get students by result
    // GET http://localhost:8080/api/students/result/PASS
    @GetMapping("/result/{result}")
    public List<StudentResult> getStudentsByResult(
            @PathVariable String result) {

        return studentResultService.getStudentsByResult(result);
    }


    // 4. Get students above percentage
    // GET http://localhost:8080/api/students/percentage/80
    @GetMapping("/percentage/{percentage}")
    public List<StudentResult> getStudentsAbovePercentage(
            @PathVariable BigDecimal percentage) {

        return studentResultService.getStudentsAbovePercentage(percentage);
    }


    // 5. Create new student
    // POST http://localhost:8080/api/students
    @PostMapping
    public StudentResult createStudent(
            @RequestBody StudentResult studentResult) {

        return studentResultService.createStudent(studentResult);
    }


    // 6. Update existing student
    // PUT http://localhost:8080/api/students/1
    @PutMapping("/{id}")
    public StudentResult updateStudent(
            @PathVariable Long id,
            @RequestBody StudentResult studentResult) {

        return studentResultService.updateStudent(id, studentResult);
    }


    // 7. Delete student
    // DELETE http://localhost:8080/api/students/1
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentResultService.deleteStudent(id);

        return "Student deleted successfully";
    }
}