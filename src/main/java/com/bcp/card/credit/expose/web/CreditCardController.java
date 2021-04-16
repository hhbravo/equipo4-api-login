package com.bcp.card.credit.expose.web;

import com.bcp.card.credit.business.CreditCardService;
import com.bcp.card.credit.model.api.CreditCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

/*    @PostMapping()
    public Mono<String> saveCreditCard(@RequestBody CreditCardRequest request) {
       // creditCardService.
        return null;
    }*/
}
