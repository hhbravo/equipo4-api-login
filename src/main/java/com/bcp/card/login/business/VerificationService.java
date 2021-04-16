package com.bcp.card.login.business;

import com.bcp.card.login.model.api.AuthenticationCode;
import com.bcp.card.login.model.entity.VerificationCode;
import reactor.core.publisher.Mono;

public interface VerificationService {
  Mono<String> saveCode(String code, String email);

  Mono<VerificationCode> verifyCode(AuthenticationCode authenticationCode);
}
