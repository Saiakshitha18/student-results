package com.student.results.service;

import com.student.results.entity.StudentResult;
import com.student.results.repository.StudentResultRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StudentResultService {

    private final StudentResultRepository studentResultRepository;

    // Constructor Injection
    public StudentResultService(StudentResultRepository studentResultRepository) {
        this.studentResultRepository = studentResultRepository;
    }


    // 1. Get all students
    public List<StudentResult> getAllStudents() {

        return studentResultRepository.getAllStudents();
    }


    // 2. Get student by roll number
    public StudentResult getStudentByRollNumber(String rollNumber) {

        return studentResultRepository
                .getStudentByRollNumber(rollNumber)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found with roll number: " + rollNumber
                        )
                );
    }


    // 3. Get students by result - PASS / FAIL
    public List<StudentResult> getStudentsByResult(String result) {

        return studentResultRepository.getStudentsByResult(result);
    }


    // 4. Get students above given percentage
    public List<StudentResult> getStudentsAbovePercentage(BigDecimal percentage) {

        return studentResultRepository
                .getStudentsAbovePercentage(percentage);
    }


    // 5. Create a new student result
    public StudentResult createStudent(StudentResult studentResult) {

        return studentResultRepository.save(studentResult);
    }


    // 6. Update existing student result
    public StudentResult updateStudent(
            Long id,
            StudentResult updatedStudent) {

        StudentResult existingStudent =
                studentResultRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Student not found with id: " + id
                                )
                        );

        existingStudent.setStudentName(
                updatedStudent.getStudentName());

        existingStudent.setRollNumber(
                updatedStudent.getRollNumber());

        existingStudent.setClassName(
                updatedStudent.getClassName());

        existingStudent.setMaths(
                updatedStudent.getMaths());

        existingStudent.setPhysics(
                updatedStudent.getPhysics());

        existingStudent.setChemistry(
                updatedStudent.getChemistry());

        existingStudent.setEnglish(
                updatedStudent.getEnglish());

        existingStudent.setComputerScience(
                updatedStudent.getComputerScience());

        existingStudent.setTotalMarks(
                updatedStudent.getTotalMarks());

        existingStudent.setPercentage(
                updatedStudent.getPercentage());

        existingStudent.setResult(
                updatedStudent.getResult());

        return studentResultRepository.save(existingStudent);
    }


    // 7. Delete student
    public void deleteStudent(Long id) {

        StudentResult student =
                studentResultRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Student not found with id: " + id
                                )
                        );

        studentResultRepository.delete(student);
    }
}