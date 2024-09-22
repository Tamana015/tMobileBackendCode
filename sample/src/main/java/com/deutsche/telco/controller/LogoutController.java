package com.deutsche.telco.controller;

import com.deutsche.telco.dto.ResponseDto;
import com.deutsche.telco.enums.ErrorCode;
import com.deutsche.telco.exceptions.TokenNotFoundException;
import com.deutsche.telco.model.TokenBlacklist;
import com.deutsche.telco.repository.TokenBlacklistRepository;
import com.deutsche.telco.utils.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static com.deutsche.telco.constants.StringConstants.FAILED_MESSAGE;
import static com.deutsche.telco.constants.StringConstants.SUCCESS_MESSAGE;

@RestController
@RequestMapping("/api")
public class LogoutController {

    @Autowired
    private TokenBlacklistRepository tokenBlacklistRepository;

    @GetMapping(value = "/logout")
    public ResponseDto<Boolean> logout(HttpServletRequest request) {
        String accessToken;
        try {
            accessToken = RequestContext.getAccessToken();
        } catch (Exception e) {
            throw new TokenNotFoundException("Invalid Access Token");
        }
        if (Objects.isNull(accessToken) || accessToken.isBlank())
            return new ResponseDto<>(FAILED_MESSAGE, ErrorCode.TOKEN_NOT_FOUND.getErrorCode(), ErrorCode.TOKEN_NOT_FOUND.getErrorMsg(), null);

        TokenBlacklist tokenBlackList = new TokenBlacklist();
        tokenBlackList.setToken(accessToken);
        tokenBlacklistRepository.save(tokenBlackList);

        return new ResponseDto<>(
                SUCCESS_MESSAGE,
                ErrorCode.SUCCESS.getErrorCode(),
                ErrorCode.SUCCESS.getErrorMsg(),
                true
        );
    }
}
