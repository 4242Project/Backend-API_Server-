package com.flatform.api.service;



import java.io.UnsupportedEncodingException;
import java.util.List;

public interface LookupUserRefreshTokenService {
    List<String> getNewAccessToken(String refreshTokenValue, String userId) throws UnsupportedEncodingException;
}
