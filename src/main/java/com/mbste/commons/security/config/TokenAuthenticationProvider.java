package com.mbste.commons.security.config;

import com.mbste.commons.security.ClientAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by gatete rugamba
 * on 10/30/2018
 * Make it work, make it right, make it fast.
 */
@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TokenAuthenticationProvider extends
        AbstractUserDetailsAuthenticationProvider {
    @NonNull
    ClientAuthenticationService auth;
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws
            AuthenticationException {
    }
    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken
            authentication) throws AuthenticationException {
        final Object token = authentication.getCredentials();
        return (UserDetails) Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(auth::findByToken)
        .orElseThrow(() -> new UsernameNotFoundException
                ("Cannot find user with authentication token=" + token));
    }
}