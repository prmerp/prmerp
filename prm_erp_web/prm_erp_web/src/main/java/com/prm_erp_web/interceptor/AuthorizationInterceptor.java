package com.prm_erp_web.interceptor;

import com.prm_erp_web.annotations.Secured;
import com.prm_erp_web.utilities.Permissions;
import com.prm_erp_web.utilities.UserSession;
import com.prm_erp_web.utilities.UserSessionCache;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import prm_erp.utility.CustomMap;

/**
 *
 * @author PDP_Shiva
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("com.prm_erp_web.interceptor.AuthorizationInterceptor.preHandle()-->Called"+request.getContentType());
        Secured secured = ((HandlerMethod) handler).getMethodAnnotation(
                Secured.class);

        if (null != secured) {
            Permissions permissions = secured.permissions();

            String token = request.getHeader("authToken");

            return isTokenValid(token);
        }

        return true;
    }

    private boolean isTokenValid(String token) {

        CustomMap<String, UserSession> customMap = UserSessionCache.get();
        Boolean containsKey = customMap.containsKey(token);
        if (containsKey) {
            UserSession session = customMap.get(token);
            SecurityContext context = SecurityContextHolder.getContext();
            AbstractAuthenticationToken authentication = (AbstractAuthenticationToken) context.getAuthentication();
            authentication.setDetails(session);
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);
            return Boolean.TRUE;

        }
        return Boolean.FALSE;
    }
}
