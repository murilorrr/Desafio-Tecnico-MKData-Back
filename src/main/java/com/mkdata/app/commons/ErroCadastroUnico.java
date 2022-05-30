package com.mkdata.app.commons;

public class ErroCadastroUnico extends Exception {
  public ErroCadastroUnico() {
    super("Já existe um usuário com este cadastro");
  }
}
