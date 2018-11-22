package com.test.wsdl.wsdlwrapper.web;

import com.test.wsdl.spring.*;
import com.test.wsdl.wsdlwrapper.services.BlzClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BankController {

  @Autowired
  BlzClient client;

  @GetMapping("/bank/{blz}")
  public ResponseEntity<GetBankResponseType> getBankResponseType(@PathVariable(name = "blz", required = true) String blz) {


    if(StringUtils.isEmpty(blz)){
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(client.getBank(blz));


  }

}
