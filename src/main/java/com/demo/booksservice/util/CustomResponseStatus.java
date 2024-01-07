package com.demo.booksservice.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomResponseStatus {

    SUCCESS(0, "Success"),
    NOT_FOUND(1, "Not Found"),
    EXCEPTION(2, "Exception");

    final Integer code;
    final String message;

}