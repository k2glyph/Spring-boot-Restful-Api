package com.example.Controllers;

import com.example.model.Student;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinesh on 6/20/2016.
 */
@Controller
@RequestMapping("/students")
public class StudentController {
    private static List<Student> studentList = new ArrayList<Student>();

    static {
        studentList.add(new Student(1, "Bhaii", "Magar"));
        studentList.add(new Student(2, "Dai", "Uncle"));
        studentList.add(new Student(3, "Magar", "Fuche"));
        studentList.add(new Student(4, "Dai", "Bhai"));
        studentList.add(new Student(5, "Yubraj", "Paudel"));
    }

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> getAllStudent() {
        return studentList;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Student getStudent(@PathVariable("id") int id) {
        for(Student s:studentList){
            if(s.getId()==id){
                return s;
            }
        }
        return null;
    }
    @RequestMapping(value = "",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addStudent(@RequestBody Student s) {
        studentList.add(s);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                s.setFirstname(student.getFirstname());
                s.setLastname(student.getLastname());
            }
        }
        return student;
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteStudent(@PathVariable("id") int id ){
        Student deleteStudent=null;
        for(Student s:studentList){
            if(s.getId()==id){
                deleteStudent=s;

            }
        }
        if(deleteStudent==null){

        }else{
            studentList.remove(deleteStudent);
        }
    }

}
