package com.sdw.library.auditable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @description: Implementacion del auditor.
 * @author: Felipe Monzón
 * @date: 8 dic. 2020
 * @enterprise: Coppel DSB III
 * @version: 1.0.0
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

  @Bean
  public AuditorAware<String> auditorProvider() {
    /*
     * if you are using spring security, you can get the currently logged username with following
     * code segment. SecurityContextHolder.getContext().getAuthentication().getName()
     */
    return () -> Optional.ofNullable("felipe");
  }
}
