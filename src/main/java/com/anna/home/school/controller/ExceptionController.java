package com.anna.home.school.controller;

import com.anna.home.school.dto.ErrorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, SQLException.class})
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(404);
        errorDto.setDescription(ex.getMessage());
        ResponseEntity<ErrorDto> responseEntity = ResponseEntity.status(404).body(errorDto);
        return responseEntity;
    }

}
