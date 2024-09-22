package com.deutsche.telco.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.deutsche.telco.constants.StringConstants.AUTH_HEADER;

public class RequestContext {
    public static String getEmailId() {
        ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        String emailId = null;
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            emailId = (String) request.getAttribute("emailId");
        }
        return emailId;
    }
    public static String getAccessToken() {
        ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        String accessToken = null;
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            accessToken = request.getHeader(AUTH_HEADER).replaceAll("Bearer ", "");
        }
        return accessToken;
    }
}
