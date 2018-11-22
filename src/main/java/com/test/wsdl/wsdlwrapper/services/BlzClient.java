package com.test.wsdl.wsdlwrapper.services;


import com.test.wsdl.spring.GetBankResponseType;
import com.test.wsdl.spring.GetBankType;
import com.test.wsdl.spring.ObjectFactory;
import com.test.wsdl.spring.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class BlzClient extends WebServiceGatewaySupport {

  private String serviceEndpoint = "http://www.thomas-bayer.com/axis2/services/BLZService";
  private ObjectFactory objectFactory = new ObjectFactory();

  private static final Logger logger = LoggerFactory.getLogger(BlzClient.class);

  public GetBankResponseType getBank(String blzCode) {
    logger.info("> :getBank");

    GetBankType request = objectFactory.createGetBankType();
    request.setBlz(blzCode);

    JAXBElement<GetBankType> jaxbBankType = objectFactory.createGetBank(request);

    JAXBElement<GetBankResponseType> response = (JAXBElement<GetBankResponseType>) getWebServiceTemplate()
            .marshalSendAndReceive(serviceEndpoint, jaxbBankType);


    logger.info(">> Response: ", response);
    return response.getValue();
  }
}
