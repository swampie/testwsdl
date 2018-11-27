package com.test.wsdl.wsdlwrapper.clients;


import com.test.wsdl.documi.account.AccountGetLoginLinkResponse;
import com.test.wsdl.documi.account.AccountGetUserDataResponse;
import com.test.wsdl.documi.account.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.AsyncHandler;
import java.util.concurrent.Future;


public class DocumiAccountClient extends WebServiceGatewaySupport{


  public DocumiAccountClient(String serviceEndpoint) {
    setDefaultUri(serviceEndpoint);
  }

  private final static ObjectFactory OBJECT_FACTORY = new ObjectFactory();

  public AccountGetLoginLinkResponse getLogin(String token ) {

    JAXBElement<String> jaxbAccountGetLoginLink = OBJECT_FACTORY.createAccountGetLoginLinkToken(token);

    JAXBElement<AccountGetLoginLinkResponse> response = (JAXBElement<AccountGetLoginLinkResponse>) getWebServiceTemplate()
            .marshalSendAndReceive(getDefaultUri(), jaxbAccountGetLoginLink);

    logger.info(">> Response: "  + response);
    return response.getValue();
  }

  public Future<AccountGetLoginLinkResponse> getAsyncLogin(String token, AsyncHandler<AccountGetLoginLinkResponse> o ) {
    com.test.wsdl.documi.account.AccountService accountService = new com.test.wsdl.documi.account.AccountService();
    return (Future<AccountGetLoginLinkResponse>) accountService.getBasicHttpBindingIAccountService().accountGetLoginLinkAsync(token, o);
  }




  public AccountGetUserDataResponse getUserData(String token) {
    JAXBElement<String> jaxbAccountGetUserData = OBJECT_FACTORY.createAccountGetUserDataToken(token);
    JAXBElement<AccountGetUserDataResponse> response = (JAXBElement<AccountGetUserDataResponse>) getWebServiceTemplate()
            .marshalSendAndReceive(getDefaultUri(), jaxbAccountGetUserData);
    return response.getValue();

  }
}
