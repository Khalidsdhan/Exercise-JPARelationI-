package com.example.school_management_software.Repository;

import com.example.school_management_software.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);
}
