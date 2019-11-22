package com.mbste.commons.security;

import com.mbste.model.Client;

import java.util.Optional;

/**
 * @gatete rugamba
 */
public interface ClientAuthenticationService
{
    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     *
     */
    Optional<String> login(String username, String password);
    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    Optional<Client> findByToken(String token);
    /**
     * Logs out the given input {@code user}.
     *
     * @param client the user to logout
     */
    void logout(Client client);

    Optional<String> findByPhoneNumber(String username, String phoneNumber);

}
