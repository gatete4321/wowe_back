package com.mbste.service;

import com.mbste.model.Appoitement;
import com.mbste.model.filters.AppoitementFilter;
import com.mbste.model.filters.AppoitementForm;

import java.util.List;
import java.util.Optional;

public interface ApoitementService
{
    public List<Appoitement> getClientsAppoitements(AppoitementFilter filter);

    public String getAppoitementByAppoitementId(AppoitementFilter filter);

    public Integer  createAppoitement(AppoitementForm form);

    public String deleteAppoitement(AppoitementFilter form);

    public String updateAppoitement(AppoitementForm form);

    public String findByPlaque(AppoitementForm form);

    String makeFeedBack(AppoitementForm form);

    String rate(AppoitementForm form);

    String getClientRates(AppoitementForm form);

    String count(AppoitementForm form);

    int createTable();
}
