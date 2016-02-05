package com.contactsBook.validator;

import com.contactsBook.entity.MappedContact;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by mixmax on 05.02.16.
 */
public class ContactValidator implements Validator {
    public boolean supports(Class aClass) {
        return MappedContact.class.equals(aClass);
    }

    public void validate(Object o, Errors e) {

        ValidationUtils.rejectIfEmptyOrWhitespace(e, "tel", "tel.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "firstName", "ferstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "lastName", "lastName.empty");
        MappedContact mp = (MappedContact) o;

        if (mp.getFirstName().length() < 3 || mp.getFirstName().length() > 15) {
            e.rejectValue("firstName", "inapporiate lenght");
        }
        if (mp.getLastName().length() < 2 || mp.getLastName().length() > 20) {
            e.rejectValue("lastName", "inapporiate lenght");
        }
        if (mp.getTel().length() < 9 || mp.getTel().length() > 12) {
            e.rejectValue("tel", "inapporiate tel lenght");
        }


    }
}
