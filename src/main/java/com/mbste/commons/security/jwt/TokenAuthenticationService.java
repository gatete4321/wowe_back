package com.mbste.commons.security.jwt;

import com.google.common.collect.ImmutableMap;
import com.mbste.commons.security.ClientAuthenticationService;
import com.mbste.commons.security.TokenService;
import com.mbste.dao.ClientDao;
import com.mbste.model.Client;
import com.mbste.service.ClientService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TokenAuthenticationService implements ClientAuthenticationService
{
    //@NonNull
    @Autowired
    TokenService tokens;
    @Autowired
    ClientDao clientDao;
    @Autowired
    ClientService clientService;

    @Override
    public Optional<String> login(String username, String password) {

        Optional<Client> client= Optional.of(clientDao.findByUsername(username));
        return client.filter(client1 -> Objects.equals(password,client1.getPassword()))
                .map(client1 -> tokens.expiring((ImmutableMap.of("username", username))));

    }

    @Override
    public Optional<Client> findByToken(String token) {

        return Optional.of(tokens.verify(token))
                .map(map -> map.get("username"))
                .flatMap(clientService::findByUsername);

    }

    @Override
    public void logout(Client client) {

    }

    public Optional<String> findByPhoneNumber(String username,String phoneNumber){
        Optional<Client> client=Optional.of(clientDao.findByUsername(username));
        return client.filter(x->Objects.equals(phoneNumber,x.getPhoneNumber())).
                map(x->tokens.expiring((ImmutableMap.of("username",username))));
    }
}
