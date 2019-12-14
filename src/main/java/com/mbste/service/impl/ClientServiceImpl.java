package com.mbste.service.impl;

import com.mbste.ExceptionH.NotFoundException;
import com.mbste.dao.ClientDao;
import com.mbste.model.Client;
import com.mbste.model.ClientFilter;
import com.mbste.model.filters.ClientForm;
import com.mbste.service.ClientService;
import com.mbste.commons.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientServiceImpl implements ClientService
{
    @Autowired
    ClientDao dao;

    @Override
    public List<Client> getClientsList(ClientFilter clientFilter) {
        clientFilter.setPaginationDates();
        clientFilter.setPaginationOffset();
        return dao.getAll(clientFilter);
    }

    @Override
    public Client findById(Integer clientId) {
        Client client=dao.findById(clientId);
        client.setPassword(null);
//        return Optional.of(client);
        return client;
    }

    @Override
    public Integer createNewClient(ClientForm clientForm) {
        //track insert results
        int result=0;

        if (checkUsername(clientForm.getUsername())==null) {
            result = dao.createClient(clientForm);
        }
        else{
            return 100;
//            throw new NotFoundException("the username has taken");//ndahindura aho guta exception ngarure string
        }
        if(result>0 ){
//            return ReturnUtil.resultSuccess();
            return 1;
        }else {
//            return ReturnUtil.resultFail("Database insertion failure");
            return 0;
            //throw new NotFoundException("the name was taken ");
        }
    }

    @Override
    public Integer updateClient(ClientForm clientForm) {
        int result= dao.updateClient(clientForm);
        if(result>0){
            return 1;
        }else {
            return 10;
        }
    }

    @Override
    public Client login(String username, String pwd) {
        return null;
    }

    @Override
    public int countAll(ClientFilter clientFilter) {
        return  dao.count(clientFilter);
    }

    @Override
    public Optional<Client> findByUsername(String username) {
        Optional<Client> client=Optional.of(dao.findByUsername(username));
//        Client client=dao.findByUsername(username);
        return client;
    }

    @Override
    public Integer changePassword(ClientForm clientForm) {
        if (!(checkPassword(clientForm.getClientId(),clientForm.getRecentPassword()))){
            return 20;
        }

        int result= dao.changePassword(clientForm);
        if(result>0){
            return 1;
        }else {
            return 10;
        }
    }

    @Override
    public String changeProfileImage(ClientForm clientForm) {
        int result= dao.changeProfileImage(clientForm);
        if(result>0){
            return ReturnUtil.resultSuccess();
        }else {
            return ReturnUtil.resultFail("Database updation  failure");
        }
    }

    @Override
    public List<Client> getAll(ClientFilter filter) {
        List<Client> clients=dao.getAll(filter);
        clients.forEach((client -> {
            client.setPassword(null);
        }));
        return clients;
    }

    /**
     * for checking if the username exist
     * @param username
     * @return
     */
    public Client checkUsername(String username){

        return dao.findByUsername(username);
    }

    /**
     * it checks if the recent password is real
     * @param clientId
     * @param recentPassword
     * @return
     */
    public boolean checkPassword(Integer clientId,String recentPassword){
        return dao.getPassword(clientId).equals(recentPassword)?true:false;
    }
}
