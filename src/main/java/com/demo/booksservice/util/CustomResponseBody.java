package com.demo.booksservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponseBody<T> {

    CustomResponseStatus status;
    T body;

}