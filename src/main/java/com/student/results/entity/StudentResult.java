package com.student.results.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "student_results")
public class StudentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "roll_number", nullable = false, unique = true)
    private String rollNumber;

    @Column(name = "class_name")
    private String className;

    private Integer maths;

    private Integer physics;

    private Integer chemistry;

    private Integer english;

    @Column(name = "computer_science")
    private Integer computerScience;

    @Column(name = "total_marks")
    private Integer totalMarks;

    private BigDecimal percentage;

    private String result;


    // Required by JPA
    public StudentResult() {
    }


    // Constructor
    public StudentResult(String studentName,
                         String rollNumber,
                         String className,
                         Integer maths,
                         Integer physics,
                         Integer chemistry,
                         Integer english,
                         Integer computerScience,
                         Integer totalMarks,
                         BigDecimal percentage,
                         String result) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.className = className;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
        this.english = english;
        this.computerScience = computerScience;
        this.totalMarks = totalMarks;
        this.percentage = percentage;
        this.result = result;
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    public Integer getChemistry() {
        return chemistry;
    }

    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getComputerScience() {
        return computerScience;
    }

    public void setComputerScience(Integer computerScience) {
        this.computerScience = computerScience;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}