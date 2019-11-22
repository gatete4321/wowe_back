package com.mbste.service;

import com.mbste.model.Client;
import com.mbste.model.ClientFilter;
import com.mbste.model.filters.ClientForm;

import java.util.List;
import java.util.Optional;

public interface  ClientService
{

    //get the list of all client(support pagination)
    public List<Client> getClientsList(ClientFilter clientFilter);

    //get single client(by id, phone, username, password, email)
    public Optional<Client> findById(Integer clientId);

    //create a new client
    public String createNewClient(ClientForm clientForm);

    //update client information
    public Integer updateClient(ClientForm clientForm);

    //login into client's account
    public Client login(String username, String pwd);

    public int countAll(ClientFilter clientFilter);

    public Optional<Client>  findByUsername(String username);
    //for changing password
    public Integer changePassword(ClientForm clientForm);
    //for changing profile image
    public String changeProfileImage(ClientForm clientForm);

    public List<Client> getAll(ClientFilter filter);

//    Integer getPassword(ClientFilter filter);
}
