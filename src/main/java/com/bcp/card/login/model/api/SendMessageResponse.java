package com.bcp.card.login.model.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMessageResponse {
    private Integer status;
    private String code;
}
