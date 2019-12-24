package com.mbste.dao;

import com.mbste.model.Client;
import com.mbste.model.ClientFilter;
import com.mbste.model.Cnt;
import com.mbste.model.filters.ClientForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Gatete Rugamba
 * on 03/19/2019
 * Make it work, make it right, make it fast.
 */
@Mapper
public interface ClientDao {

    //query clients
    public List<Cnt> getAll(ClientFilter clientFilter);

    //get single client
    public Client findById(Integer clientId);

    //create new client and save info to database
    public int createClient(ClientForm clientForm);

    //update client information
    public int updateClient(ClientForm clientForm);
    //for changing password
    public int changePassword(ClientForm clientForm);
    //for changing profile image
    public int changeProfileImage(ClientForm clientForm);

    //count for pagination
    public int count(ClientFilter clientFilter);
//i decided to return Client not Optional<Client>
    public Client findByUsername(String username);

    public String findImageById(Integer clientId);

    String getPassword(Integer clientId);

    int createTable();

    int dropTable();

    String getTechImage(Integer clientId);
}
