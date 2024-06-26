package com.worshipplanner.mssecurity.exception;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;

public class CustomExpiredJwtException extends ExpiredJwtException {
    public CustomExpiredJwtException(Header header, Claims claims, String message) {
        super(header, claims, message);
    }
}
