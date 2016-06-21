package com.example.Controllers;

import com.example.model.Address;
import com.example.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    private boolean update=false;
    private static List<Student> studentList = new ArrayList<Student>();

    static {
        studentList.add(new Student(1, "Bhaii", "Magar",new Address("lalbandi -6","Kathmandu","Nepal")));
        studentList.add(new Student(2, "Dai", "Uncle",new Address("new Baneshower -15","Kathmandu","Nepal")));
        studentList.add(new Student(3, "Magar", "Fuche",new Address("tinkune -14","Kathmandu","Nepal")));
        studentList.add(new Student(4, "Dai", "Bhai",new Address("maitidevi -50","Kathmandu","Nepal")));
        studentList.add(new Student(5, "Yubraj", "Paudel",new Address("Ratna park -1","Kathmandu","Nepal")));
    }

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> getAllStudent() {
        if(studentList.isEmpty()){
            throw  new StudentNotFound();
        }
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
        throw new StudentNotFound();
    }
    @RequestMapping(value = "",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StudentRespone addStudent(@RequestBody Student s) {
        StudentRespone s1=new StudentRespone();
        studentList.add(s);
        s1.setMsg("Successfully Create Student");
        return s1;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public StudentRespone updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                s.setFirstname(student.getFirstname());
                s.setLastname(student.getLastname());
                s.setAddress(student.getAddress());
                update=true;
                break;
            }
        }
        if(update){
            return new StudentRespone("Successfully student updated");

        }else{
            throw new StudentNotFound();
        }
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public StudentRespone deleteStudent(@PathVariable("id") int id ){
        Student deleteStudent=null;
        for(Student s:studentList){
            if(s.getId()==id){
                deleteStudent=s;
            }
        }
        if(deleteStudent==null){
            throw new StudentNotFound();
        }else{
            studentList.remove(deleteStudent);
            return new StudentRespone("Student Successfully Deleted");
        }
    }

}
