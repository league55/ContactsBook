package com.contactsBook.configuration;

import com.contactsBook.configuration.mvc.ServletConfig;
import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import com.contactsBook.services.ContactServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 *
 */

@Configuration
@ComponentScan({"com.contactsBook.repository", "com.contactsBook.services"})

@Import({EntityConfig.class, ServletConfig.class})
public class AppConfig {

}