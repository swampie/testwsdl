package com.test.wsdl.wsdlwrapper.services;

import com.test.wsdl.documi.AccountGetLoginLinkResponse;
import com.test.wsdl.documi.AccountGetUserDataResponse;
import com.test.wsdl.documi.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;


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

  public AccountGetUserDataResponse getUserData(String token) {
    JAXBElement<String> jaxbAccountGetUserData = OBJECT_FACTORY.createAccountGetUserDataToken(token);
    JAXBElement<AccountGetUserDataResponse> response = (JAXBElement<AccountGetUserDataResponse>) getWebServiceTemplate()
            .marshalSendAndReceive(getDefaultUri(), jaxbAccountGetUserData);
    return response.getValue();

  }
}
