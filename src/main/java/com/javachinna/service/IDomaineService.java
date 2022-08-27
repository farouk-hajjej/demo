package com.javachinna.service;

import com.javachinna.model.Domain;
import com.javachinna.model.Question;

import java.util.List;

public interface IDomaineService {
    void addDomain(Domain d);
    void UpdateDomain(Domain d, Long idD);
    List<Domain> retrieveAllDomains();
    void deleteDomain ( Long id);
}
