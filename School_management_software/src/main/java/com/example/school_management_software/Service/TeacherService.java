package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

   public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
   }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);

        if(oldTeacher==null){
            throw new ApiException("Teacher is not found");
        }
        oldTeacher.setName(oldTeacher.getName());
        oldTeacher.setAge(oldTeacher.getAge());
        oldTeacher.setEmail(oldTeacher.getEmail());
        oldTeacher.setSalary(oldTeacher.getSalary());

        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher =teacherRepository.findTeacherById(id);

        if(teacher==null){
            throw new ApiException("teacher is not found");
        }

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id){
        return teacherRepository.findTeacherById(id);
    }
}
