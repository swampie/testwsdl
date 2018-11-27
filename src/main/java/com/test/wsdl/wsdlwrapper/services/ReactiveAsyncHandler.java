package com.test.wsdl.wsdlwrapper.services;

import reactor.core.publisher.MonoSink;

import javax.xml.ws.AsyncHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ReactiveAsyncHandler {

  public static <T> AsyncHandler<T> into(MonoSink<T> sink) {
    return res -> {
      try {
        sink.success(res.get(1, TimeUnit.MILLISECONDS));
      } catch (InterruptedException | ExecutionException | TimeoutException e) {
        sink.error(e);
      }
    };
  }
}
