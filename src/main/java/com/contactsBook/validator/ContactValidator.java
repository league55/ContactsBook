package com.contactsBook.validator;

import com.contactsBook.models.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by mixmax on 05.02.16.
 */

@Component
public class ContactValidator implements Validator {
    public boolean supports(Class aClass) {
        return Contact.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors e) {

        ValidationUtils.rejectIfEmptyOrWhitespace(e, "tel", "contact.tel.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "firstName", "contact.firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "lastName", "contact.lastName.empty");
        /*Contact mp = (Contact) o;

        if (mp.getFirstName().length() < 3 || mp.getFirstName().length() > 15) {
            e.rejectValue("contact.firstName", "inapporiate lenght");
        }
        if (mp.getLastName().length() < 2 || mp.getLastName().length() > 20) {
            e.rejectValue("contact.lastName", "inapporiate lenght");
        }
        if (mp.getTel().length() < 9 || mp.getTel().length() > 12) {
            e.rejectValue("contact.tel", "inapporiate tel lenght");
        }
*/
    }
}
