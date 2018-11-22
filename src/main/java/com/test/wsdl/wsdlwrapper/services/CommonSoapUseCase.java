package com.test.wsdl.wsdlwrapper.services;


import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public abstract class CommonSoapUseCase<IN, OUT> extends WebServiceGatewaySupport {


  public OUT exchange(IN input) {
    return null;
  }

}
