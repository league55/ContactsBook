package com.contactsBook.configuration;

import com.contactsBook.configuration.mvc.ServletConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 *
 */

@Configuration
@ComponentScan({"com.contactsBook.repository", "com.contactsBook.services", "com.contactsBook.validator"})

@Import({EntityConfig.class, ServletConfig.class})
public class AppConfig {

}