package com.test.wsdl.wsdlwrapper.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.test.wsdl.wsdlwrapper.services.AccountService;
import com.test.wsdl.wsdlwrapper.services.AsyncAccountHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumiAccountController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private AsyncAccountHandler asyncAccountHandler;

  @PostMapping("/documi/account/login")
  public ResponseEntity<Void> getLogin(@RequestBody TokenHolder token) {
    /*
    Questa chiamata é asincrona quindi possiamo invocare senza
    aspettare il ritorno
      */

    asyncAccountHandler.receiveAccount(accountService.getLoginResponse(token.getToken()));
    return ResponseEntity.accepted().build();
  }

  static class TokenHolder {
    private final String token;

    @JsonCreator
    public TokenHolder(String token) {
      this.token = token;
    }

    public String getToken() {
      return token;
    }
  }
}
