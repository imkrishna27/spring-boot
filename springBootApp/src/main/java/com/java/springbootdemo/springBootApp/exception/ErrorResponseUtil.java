package com.java.springbootdemo.springBootApp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseUtil {
    private String message;

    private Integer status;
}
