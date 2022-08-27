package com.javachinna.service;

import com.javachinna.model.Domain;
import com.javachinna.repo.IDomaineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DomaineServiceImpl implements IDomaineService {
    @Autowired
    private IDomaineRepo domaineRepo;
    @Override
    public void addDomain(Domain d) {
        domaineRepo.save(d);

    }

    @Override
    public void UpdateDomain(Domain d, Long idD) {
      Domain domain=domaineRepo.findById(idD).orElse(null);
      d.setCodeDomaine(d.getCodeDomaine());
      domaineRepo.save(d);
    }

    @Override
    public List<Domain> retrieveAllDomains() {
        List<Domain> domains= new ArrayList<Domain>();
        domaineRepo.findAll().forEach(domain -> {
            domains.add(domain);
        });
        return domains;
    }

    @Override
    public void deleteDomain(Long id) {
       domaineRepo.deleteById(id);
    }
}
