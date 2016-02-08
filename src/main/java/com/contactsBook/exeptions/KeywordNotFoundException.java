package com.contactsBook.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mixmax on 07.02.16.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Keyword")
public class KeywordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public KeywordNotFoundException(String key) {
        super(key + " not available");
    }
}
