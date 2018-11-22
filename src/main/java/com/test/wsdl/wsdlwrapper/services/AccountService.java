package com.test.wsdl.wsdlwrapper.services;

import com.test.wsdl.documi.AccountGetLoginLinkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.wsdl.wsdlwrapper.clients.DocumiAccountClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AccountService {

  @Autowired
  private final DocumiAccountClient documiAccountClient;

  public AccountService(DocumiAccountClient documiAccountClient) {
    this.documiAccountClient = documiAccountClient;
  }

  @Async
  public CompletableFuture<AccountGetLoginLinkResponse> getLoginResponse(final String token) {
    return CompletableFuture.completedFuture(documiAccountClient.getLogin(token));
  }
}
