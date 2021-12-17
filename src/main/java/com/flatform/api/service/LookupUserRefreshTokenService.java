package com.flatform.api.service;

import com.flatform.api.model.dto.RefreshTokenDTO;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface LookupUserRefreshTokenService {
    public List getNewAccessToken(String refreshTokenDTO, String memberId) throws UnsupportedEncodingException;
}