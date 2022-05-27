package com.mkdata.app.controllers;

import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.commons.ErrorMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroController {
  @ExceptionHandler(ErroNaoEncontrado.class)
  public ResponseEntity<ErrorMessage> entityNotFound(ErroNaoEncontrado e) {
    ErrorMessage err = new ErrorMessage(e.getMessage());
    err.setStatus(HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }
}
