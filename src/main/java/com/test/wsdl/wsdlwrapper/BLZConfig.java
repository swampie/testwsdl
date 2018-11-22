package com.test.wsdl.wsdlwrapper;

import com.test.wsdl.wsdlwrapper.services.BlzClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.StringWriter;

@Configuration
public class BLZConfig {
  @Bean
  public Jaxb2Marshaller marshaller() {

    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.test.wsdl.spring");
    return marshaller;
  }

  @Bean
  BlzClient blzClient(Jaxb2Marshaller marshaller) {
    BlzClient client = new BlzClient();
    client.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
