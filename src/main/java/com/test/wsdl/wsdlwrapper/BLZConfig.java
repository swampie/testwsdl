package com.test.wsdl.wsdlwrapper;

import com.test.wsdl.wsdlwrapper.clients.DocumiAccountClient;
import com.test.wsdl.wsdlwrapper.services.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@EnableAsync
public class BLZConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {

    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.test.wsdl.documi.account");
    return marshaller;
  }


  @Bean
  public DocumiAccountClient accountClient(Jaxb2Marshaller jaxb2Marshaller) {
    DocumiAccountClient client = new DocumiAccountClient("https://servizi-demo.youdox.it/fatturazione/api/AccountService.svc");
    client.setMarshaller(jaxb2Marshaller);
    client.setUnmarshaller(jaxb2Marshaller);
    return client;
  }

  @Bean
  public AccountService accountService(DocumiAccountClient documiAccountClient) {
    return new AccountService(documiAccountClient);
  }

}
