package com.poi.hr.util;

import com.poi.hr.auth.model.AuthDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static int getCurrentEmployeeId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        return authDetails.getLoginEmployeeDto().getEmployeeId();
    }

    public static String getCurrentEmployeeName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        return authDetails.getLoginEmployeeDto().getEmployeeName();
    }
}
