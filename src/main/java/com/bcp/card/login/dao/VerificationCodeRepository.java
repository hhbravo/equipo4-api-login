package com.bcp.card.login.dao;

import com.bcp.card.login.model.entity.VerificationCode;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface VerificationCodeRepository extends ReactiveCrudRepository<VerificationCode, Integer> {

    Mono<VerificationCode> findByTemporalCodeAndEmail(String code, String email);
}
