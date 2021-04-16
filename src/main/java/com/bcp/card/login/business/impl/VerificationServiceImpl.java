package com.bcp.card.login.business.impl;

import com.bcp.card.login.business.VerificationService;
import com.bcp.card.login.dao.VerificationCodeRepository;
import com.bcp.card.login.model.api.AuthenticationCode;
import com.bcp.card.login.model.entity.VerificationCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class VerificationServiceImpl implements VerificationService {

  @Autowired
  VerificationCodeRepository verificationCodeRepository;

  @Override
  public Mono<String> saveCode(String code, String email) {

    return verificationCodeRepository.save(VerificationCode.builder().email(email).temporalCode(code).build())
            .map(verificationCode -> verificationCode.getTemporalCode())
    .doOnError(throwable -> log.error("error: {}", throwable.getMessage()));
  }

  @Override
  public Mono<VerificationCode> verifyCode(AuthenticationCode authenticationCode) {
    return verificationCodeRepository.findByTemporalCodeAndEmail(authenticationCode.getCode(),
            authenticationCode.getEmail());
  }

}
