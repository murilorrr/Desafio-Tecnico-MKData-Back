package com.mkdata.app.controllers;

import java.util.HashMap;
import java.util.Map;

import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.commons.ErrorMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class ErroController {
  @ExceptionHandler(ErroNaoEncontrado.class)
  public ResponseEntity<ErrorMessage> entityNotFound(ErroNaoEncontrado e) {
    ErrorMessage err = new ErrorMessage(e.getMessage());
    err.setStatus(HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}
