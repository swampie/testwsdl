package com.test.wsdl.wsdlwrapper.services;

import com.test.wsdl.documi.AccountGetLoginLinkResponse;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncAccountHandler {

  @Async
  public void receiveAccount(CompletableFuture<AccountGetLoginLinkResponse> response){

    try {
      Thread.sleep(2000);
      response.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
