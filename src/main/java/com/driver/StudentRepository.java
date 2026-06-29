package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
       studentMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        List<String> list=new ArrayList<>();

        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            list.add(student);
            teacherStudentMapping.put(teacher,list);
        }
    }

    public Student findStudent(String student){
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        return teacherStudentMapping.get(teacher);
    }

    public List<String> findAllStudents(){
        // your code goes here
        List<String> ans=new ArrayList<>();
        for(Map.Entry<String,Student> map:studentMap.entrySet()){
            ans.add(map.getKey());
        }
        return ans;

    }

    public void deleteTeacher(String teacher){
        // your code goes here
        teacherMap.remove(teacher);
    }

    public void deleteAllTeachers(){
        // your code goes here
        teacherMap.clear();
    }
}