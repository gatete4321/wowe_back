package com.mbste.controller;

import com.mbste.dao.ClientDao;
import com.mbste.model.Client;
import com.mbste.model.ClientFilter;
import com.mbste.model.filters.ClientForm;
import com.mbste.service.ClientService;
import com.mbste.commons.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("public/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    ClientDao dao;

    @PostMapping(value = "/info", produces = "application/json;charset=UTF-8")
    public Client getClient(@RequestBody ClientFilter form) {
//        Map<String, Object> resultMap = new HashMap<>();
        Client client = clientService.findById(form.getClientId());
//        resultMap.put("data", client);
//        resultMap.put("completed",completed);
//        resultMap.put("pending",pending);
        return client;
    }

    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public String createClient(@RequestBody ClientForm clientForm) {
        return clientService.createNewClient(clientForm);
    }

    @PostMapping(value = "/updateinfo", produces = "application/json;charset=UTF-8")
    public Integer updateClient(@RequestBody ClientForm clientForm) {
        return clientService.updateClient(clientForm);
    }

    @PostMapping(value = "/password", produces = "application/json;charset=UTF-8")
    public Integer changePassword(@RequestBody ClientForm clientForm) {
        return clientService.changePassword(clientForm);
    }

    @PostMapping(value = "/profile", produces = "application/json;charset=UTF-8")
    public String changeProfileImage(@RequestBody ClientForm clientForm) {
        return clientService.changeProfileImage(clientForm);
    }

    /**
     * get technicians
     *
     * @return
     */
    @PostMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public List<Client> getAll(@RequestBody ClientFilter filter) {

        return clientService.getAll(filter);
    }

    @PostMapping(value = "/checkUsername", produces = "application/json;charset=UTF-8")
    public String checkUsername(@RequestBody String username) {
        if (dao.findByUsername(username) != null) {
            return "true";
        }
        return "false";
    }
}
