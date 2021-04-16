package com.bcp.card.login.expose.web;

import com.bcp.card.login.business.LoginService;
import com.bcp.card.login.business.SendSmsService;
import com.bcp.card.login.business.VerificationService;
import com.bcp.card.login.model.api.*;
import com.bcp.card.login.model.entity.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LoginController {

  @Autowired
  LoginService loginService;

  @Autowired
  SendSmsService sendSmsService;

  @Autowired
  VerificationService verificationService;

  @PostMapping
  public Mono<UserResponse> login(@RequestBody UserForm userFormMono){
    return loginService.userLogin(userFormMono);
  }

  @PostMapping("/sendMessage")
  public Mono<SendMessageResponse> sendMessage(@RequestBody AuthenticationForm authenticationForm){

    return sendSmsService.sendSms(authenticationForm)
            .flatMap(s -> verificationService.saveCode(s, authenticationForm.getEmail()))
            .map(this::toSendMessageResponse);
  }

  private SendMessageResponse toSendMessageResponse(String code) {
    return SendMessageResponse.builder().code(code).status(200).build();
  }

  private VerificationCodeResponse toVerificationCodeResponse(VerificationCode verificationCode) {
    if (Objects.isNull(verificationCode) ){
      return VerificationCodeResponse.builder().message("Fallo la verificación").status(500).build();
    }
    return VerificationCodeResponse.builder().message("Verificación exitosa").status(200).build();
  }

  private Mono<VerificationCodeResponse> toVerificationCodeResponseError() {
      return Mono.just(VerificationCodeResponse.builder().message("Fallo la verificación").status(500).build());
  }

  @PostMapping("/verifyCode")
  public Mono<VerificationCodeResponse> verifyCode(@RequestBody AuthenticationCode authenticationCode) {
    return verificationService.verifyCode(authenticationCode)
            .map(this::toVerificationCodeResponse)
            .switchIfEmpty(this.toVerificationCodeResponseError());
  }


}
