package com.test.wsdl.wsdlwrapper.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.test.wsdl.documi.account.AccountGetLoginLinkResponse;
import com.test.wsdl.wsdlwrapper.services.DocumiAccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumiAccountController {

  @Autowired
  private DocumiAccountClient client;

  @PostMapping("/documi/account/login")
  public ResponseEntity<AccountGetLoginLinkResponse> getLogin(@RequestBody TokenHolder token) {
    return ResponseEntity.ok(client.getLogin(token.getToken()));
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
