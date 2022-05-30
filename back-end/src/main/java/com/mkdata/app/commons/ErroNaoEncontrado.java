package com.mkdata.app.commons;

public class ErroNaoEncontrado extends Exception {
  public ErroNaoEncontrado(String nomeDaEntidade) {
    super(nomeDaEntidade + " não encontrado.");
  }
}
