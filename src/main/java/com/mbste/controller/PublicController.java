package com.mbste.controller;

import com.mbste.ExceptionH.NotFoundException;
import com.mbste.commons.security.ClientAuthenticationService;
import com.mbste.commons.utils.ReturnUtil;
import com.mbste.model.Client;
import com.mbste.model.filters.ClientForm;
import com.mbste.model.filters.LoginForm;
import com.mbste.service.ClientService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/public/client")
public class PublicController {
    @NonNull
    @Autowired
    ClientAuthenticationService authentication;
    @NonNull
    @Autowired
    ClientService clientService;
    @PostMapping(value = "/register",produces = "application/json;charset=UTF-8")
    Integer register(@RequestBody ClientForm clientForm){
        return clientService.createNewClient(clientForm);
    }
//
//    String register(@RequestParam("username") final String username,
//                    @RequestParam("password") final String password) {
//        users.save(new User(username,username,password));
//        return login(username, password);
//    }
    @PostMapping(value = "/login",produces = "application/json;charset=UTF-8")
    Client login(@RequestBody LoginForm loginForm) {
        Map<String, Object> resultMap = new HashMap<>();

        Optional<String> token = authentication.login(loginForm.getUsername(), loginForm.getPassword());
        // System.err.println("@@@@@@@@$#$#@"+token.toString());
        Optional<Client> client = null;
        Client client2=null;
        if (token.isPresent()) {
            client = clientService.findByUsername(loginForm.getUsername());
            client2=client.get();

            client2.setToken(token.get());
//            resultMap.put("token", token);
//            resultMap.put("user", client);
//        return authentication.login(username, password)
//                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));

//            return ReturnUtil.resultSuccess(resultMap);
            return client2;
        }
        throw new NotFoundException("invalid username or password");
    }


    @PostMapping(value = "/forget",produces = "application/json;charset=UTF-8")
    String forget(@RequestBody LoginForm loginForm) {
        Map<String, Object> resultMap = new HashMap<>();

        Optional<String> token = authentication.findByPhoneNumber(loginForm.getUsername(), loginForm.getPhoneNumber());
        // System.err.println("@@@@@@@@$#$#@"+token.toString());
        Optional<Client> client1 = null;
        if (!token.isPresent()) {
            throw new NotFoundException("invalid username or phoneNumber");
        }
          client1 = clientService.findByUsername(loginForm.getUsername());
            resultMap.put("token", token);
            resultMap.put("user", client1);


            return ReturnUtil.resultSuccess(resultMap);

    }

}
