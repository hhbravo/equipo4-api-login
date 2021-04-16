package com.bcp.card.login.model.api;

import lombok.Data;

@Data
public class AuthenticationForm{
  private String phoneNumber;
  private String email;
}
