package com.student.results.repository;

import com.student.results.entity.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface StudentResultRepository
        extends JpaRepository<StudentResult, Long> {

    // 1. JPQL: Get all students
    @Query("SELECT s FROM StudentResult s")
    List<StudentResult> getAllStudents();


    // 2. JPQL: Find student by roll number
    @Query("SELECT s FROM StudentResult s WHERE s.rollNumber = :rollNumber")
    Optional<StudentResult> getStudentByRollNumber(
            @Param("rollNumber") String rollNumber
    );


    // 3. JPQL: Find students by result - PASS / FAIL
    @Query("SELECT s FROM StudentResult s WHERE s.result = :result")
    List<StudentResult> getStudentsByResult(
            @Param("result") String result
    );


    // 4. JPQL: Find students whose percentage is greater than given value
    @Query("SELECT s FROM StudentResult s WHERE s.percentage > :percentage")
    List<StudentResult> getStudentsAbovePercentage(
            @Param("percentage") BigDecimal percentage
    );
}