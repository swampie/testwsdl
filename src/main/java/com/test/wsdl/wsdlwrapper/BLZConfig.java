package com.test.wsdl.wsdlwrapper;

import com.test.wsdl.wsdlwrapper.services.BlzClient;
import com.test.wsdl.wsdlwrapper.services.DocumiAccountClient;
import com.test.wsdl.wsdlwrapper.utils.ObjectFactoryLocator;
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
  public ObjectFactoryLocator locator(){
    return new ObjectFactoryLocator();
  }

  @Bean
  DocumiAccountClient accountClient(Jaxb2Marshaller jaxb2Marshaller){
      DocumiAccountClient client = new DocumiAccountClient("https://servizi-demo.youdox.it/fatturazione/api/AccountService.svc");
      client.setMarshaller(jaxb2Marshaller);
      client.setUnmarshaller(jaxb2Marshaller);
      return  client;
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
