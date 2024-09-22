package com.deutsche.telco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ResponseDto<T> {
    private String status;
    private Integer statusCode;
    private String message;
    @JsonInclude
    private T response;
    private Map<String,Object> responseData;

    public ResponseDto(String status, Integer statusCode, String message, T response){
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.response = response;
    }


}
