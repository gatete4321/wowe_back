package com.mbste.controller;

import com.mbste.commons.utils.ReturnUtil;
import com.mbste.dao.AppoitementDao;
import com.mbste.model.Appoitement;
import com.mbste.model.filters.AppoitementFilter;
import com.mbste.model.filters.AppoitementForm;
import com.mbste.service.ApoitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/app")
public class AppoitementController {
    @Autowired
    AppoitementDao dao;
    @Autowired
    ApoitementService service;

    @PostMapping(value = "/appoitement", produces = "application/json;charset=UTF-8")
    public String getAppoitementId(@RequestBody AppoitementFilter filter) {
        return service.getAppoitementByAppoitementId(filter);
    }

    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public Integer createAppoitement(@RequestBody AppoitementForm form) {
        return service.createAppoitement(form);
    }

    @PostMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public List<Appoitement> getAllAppoitementsOfClient(@RequestBody AppoitementFilter filter) {
        List<Appoitement> appoitements = service.getClientsAppoitements(filter);
        return appoitements;
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public String deleteAppoitement(@RequestBody AppoitementFilter filter) {


        if (filter.getAppoitementId()!=null){
            return service.deleteAppoitement(filter);
        }
        return "appoitement does not exist";
    }

    @RequestMapping("/heroku")
    public String hello() {
        return "vip man gahambec";
    }


}
