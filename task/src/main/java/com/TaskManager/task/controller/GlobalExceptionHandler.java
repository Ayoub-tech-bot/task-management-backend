package com.TaskManager.task.controller;

import com.TaskManager.task.domain.dto.CreateTaskRequestDto;
import com.TaskManager.task.domain.dto.ErrorDto;
import com.TaskManager.task.domain.dto.TaskDto;
import com.TaskManager.task.exception.TaskNotFoundException;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handelValidationExceptions(MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage )
                .orElse("Validation failed");

        ErrorDto errorDto = new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDto> handelTaskNotFoundExceptions(TaskNotFoundException ex) {
        UUID id = ex.getId();
        String format = String.format("Task with id %s not found", id);
        ErrorDto errorDto = new ErrorDto(format);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);

    }
}
