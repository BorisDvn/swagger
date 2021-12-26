package com.example.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(description = "Error Response Model")
public class ErrorResponse {

    @ApiModelProperty(notes = "Error Code", name = "code", value = "200")
    private int code;


    @ApiModelProperty(notes = "Status", name = "status", value = "SUCCESS")
    private String status;


    @ApiModelProperty(notes = "Message", name = "message", value = "Invalid field")
    private String message;
}
