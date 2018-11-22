package com.test.wsdl.wsdlwrapper.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import javax.annotation.PostConstruct;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ObjectFactoryLocator {

  Map<String, Object> objectFactoryCache = new Hashtable<>();
  private final static ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);

  @PostConstruct
  public void initializeCache() {
    provider.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile("ObjectFactory")));
    Set<BeanDefinition> candidates =
            provider.findCandidateComponents("com.test.wsdl.documi");

    for (BeanDefinition b: candidates) {
      System.out.println(">>>>>>>>>> " + b.getBeanClassName());
    }

  }
}
