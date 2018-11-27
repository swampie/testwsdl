package com.test.wsdl.wsdlwrapper.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.test.wsdl.documi.account.AccountGetLoginLinkResponse;
import com.test.wsdl.wsdlwrapper.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.Future;

import static com.test.wsdl.wsdlwrapper.services.ReactiveAsyncHandler.into;

@RestController
public class DocumiAccountController {

  @Autowired
  private AccountService accountService;


  @PostMapping("/documi/account/login")
  public Mono<AccountGetLoginLinkResponse> getLogin(@RequestBody TokenHolder token) {
    return Mono.create(sink -> accountService.getAsyncLoginResponse(token.getToken(), into(sink)));

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
