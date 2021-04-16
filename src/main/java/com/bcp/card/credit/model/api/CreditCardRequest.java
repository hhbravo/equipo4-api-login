package com.bcp.card.credit.model.api;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CreditCardRequest {


    private Long idtarjeta;
    private String nrotarjeta;
    private String nombretarjeta;
    private String aliastarjeta;
    private String cvv;
    private Date fechaexpiración;
    private String estado;
    private BigDecimal saldodisponible;
    private String modena;
    private String nrocuentacargocreacion;
    private Boolean prendido;
    private Boolean comopraxinternet;
    private Boolean compraxextranjero;
    private Boolean pagosmoviles;
    private Boolean notificacion;
    private String correo;
    private String celular;
    private Date fechacreacion;
    private Long idusuario;

}
