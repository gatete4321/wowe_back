package com.mbste.service.impl;

import com.mbste.ExceptionH.NotFoundException;
import com.mbste.commons.utils.ReturnUtil;
import com.mbste.dao.AppoitementDao;
import com.mbste.model.Appoitement;
import com.mbste.model.filters.AppoitementFilter;
import com.mbste.model.filters.AppoitementForm;
import com.mbste.service.ApoitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.applet.resources.MsgAppletViewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AppoitementServiceImpl implements ApoitementService
{
    @Autowired
    AppoitementDao dao;

    @Override
    public List<Appoitement> getClientsAppoitements(AppoitementFilter filter) {
        filter.setPaginationDates();
        filter.setPaginationOffset();
        List<Appoitement> appoitements= dao.findByClientId(filter);
        return appoitements;
    }

    @Override
    public String getAppoitementByAppoitementId(AppoitementFilter filter) {
        Map<String,Object> map=new HashMap<>();
        Optional<Appoitement> appoitement= Optional.ofNullable(dao.findById(filter.getId()));
        Appoitement appoitement1=appoitement.filter(x-> x!=null).get();
        if (appoitement==null)
            throw new NotFoundException("the appoitement doesnt exist");

        map.put("data",appoitement);
        return ReturnUtil.resultSuccess(map);
    }

    @Override
    public Integer createAppoitement(AppoitementForm form) {
        int result;
        form.convertDate();
        result=dao.createAppoitement(form);
        if (result>0){
        return 1;
        }
        else
            return 0;
    }

    @Override
    public String deleteAppoitement(AppoitementFilter filter) {
        int result;
        result=dao.delete(filter);
        if (result>0){
            return ReturnUtil.resultSuccess();
        }
        else
        return ReturnUtil.resultFail();
    }

    @Override
    public String updateAppoitement(AppoitementForm form) {
        int result;
        result=dao.updateAppoitement(form);
        if (result>0){
            return ReturnUtil.resultSuccess();
        }
        else
        return ReturnUtil.resultFail("fail to update");
    }

    @Override
    public String findByPlaque(AppoitementForm form) {
        Map<String,Object> map=new HashMap<>();
        List<Appoitement> appoitements=dao.findByPlaque(form.getPlaque());
        map.put("data",appoitements);
        return ReturnUtil.resultSuccess(map);
    }

    @Override
    public String makeFeedBack(AppoitementForm form) {
        int result;
        result=dao.makeFeedback(form.getFeedBack());
        if (result>0)
            return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }

    @Override
    public String rate(AppoitementForm form) {
        int result;
        result=dao.rate(form.getRate()%5);//must not be over 5

        if (result>0)
            return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }

    @Override
    public String getClientRates(AppoitementForm form) {
       List<Integer> rates=dao.getRates(form.getTechId());
       int size= (int) rates.stream().count();
       int sum = rates.stream().mapToInt(x -> x).sum();
       Map<String,Object> map=new HashMap<>();
       map.put("rate",sum/size);
        return ReturnUtil.resultSuccess(map);
    }

    @Override
    public String count(AppoitementForm form) {
        Map<String,Object> map=new HashMap<>();
        map.put("count",dao.countAll(form));
        return ReturnUtil.resultSuccess(map);
    }
}
