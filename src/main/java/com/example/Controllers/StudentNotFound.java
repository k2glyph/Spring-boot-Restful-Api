package com.example.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dinesh on 6/21/2016.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="Student Not Found")
public class StudentNotFound extends RuntimeException  {
}
