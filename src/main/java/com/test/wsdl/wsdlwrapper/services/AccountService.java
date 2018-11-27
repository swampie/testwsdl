package com.test.wsdl.wsdlwrapper.services;

import com.test.wsdl.documi.account.AccountGetLoginLinkResponse;
import com.test.wsdl.wsdlwrapper.clients.DocumiAccountClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AccountService {

  @Autowired
  private final DocumiAccountClient documiAccountClient;

  public AccountService(DocumiAccountClient documiAccountClient) {
    this.documiAccountClient = documiAccountClient;
  }

  public Future<AccountGetLoginLinkResponse> getAsyncLoginResponse(final String token, AsyncHandler<AccountGetLoginLinkResponse> handler) {
     return documiAccountClient.getAsyncLogin(token, handler);

  }
}
