package com.mkdata.app.commons;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {
  private Instant instant;
  private int status;
  private String message;

  public ErrorMessage(String message) {
    this.message = message;
    instant = Instant.now();
  }

}
