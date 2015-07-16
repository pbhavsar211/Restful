package com.mycompany;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bhavsarer on 7/15/15.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="No Order Found")
public class OrderNotFoundException extends RuntimeException {



}
