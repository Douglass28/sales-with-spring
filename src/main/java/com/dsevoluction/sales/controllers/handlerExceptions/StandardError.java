package com.dsevoluction.sales.controllers.handlerExceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
