package com.car.center.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private int status;

    private String message;

    private Date timestamp;

    List<String> errors;

    ErrorResponse(String message){
        this.message = message;
    }
}
