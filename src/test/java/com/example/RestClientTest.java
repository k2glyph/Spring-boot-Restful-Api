package com.example;

import com.example.model.Student;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.List;
/**
 * Created by advanced on 6/21/2016.
 */
public class RestClientTest extends Assert {
    RestTemplate template=new RestTemplate();
    private static  String BASE_URI="http://localhost:8080/students";
    @Test
    public void test_get_all_student_For_Object(){
        List<Student> list=template.getForObject(BASE_URI,List.class);
         assertNotNull(list);
    }
    @Test
    public void test_get_all_student_For_Entity(){
        ResponseEntity<List> response=template.getForEntity(BASE_URI,List.class);
        assertEquals(response.getStatusCode().value(),200);
    }
    @Test(expected = HttpClientErrorException.class)
    public void test_delete_operation_Failed_Exception(){
        ResponseEntity<String> response=template.exchange(BASE_URI+"/100", HttpMethod.DELETE,null,String.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    @Test(expected = HttpClientErrorException.class)
    public void test_delete_operation_success(){
        template.delete(BASE_URI+"/1");
        ResponseEntity<Student> response=template.getForEntity(BASE_URI+"/1",Student.class);
    }
}
