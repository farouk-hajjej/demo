package com.javachinna.service;

import com.javachinna.model.*;
import com.javachinna.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReferentielServiceImpl implements IReferentielService{
    @Autowired
    ICategoryRepo categoryRepo;
    @Autowired
    IDomaineRepo domaineRepo;
    @Autowired
    IMesureRepo mesureRepo;
    @Autowired
    IQuestionRepo questionRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IReferentielRepo referentielRepo;
    @Override
    public void ajouterReferentielEtAffectterToOthers(Referentiel r, Long idCat, Long idDom, Long idMes, Long idQes) {
        Categorie ca=categoryRepo.findById(idCat).orElse(null);
        Domain domain=domaineRepo.findById(idDom).orElse(null);
        Mesure mesure=mesureRepo.findById(idMes).orElse(null);
        Question question=questionRepo.findById(idQes).orElse(null);
        //User user=userRepository.findById(idU).orElse(null);
        r.setCategorie(ca);
        r.setDomain(domain);
        r.setMesure(mesure);
        r.setQuestion(question);
       // r.setUser(user);
        referentielRepo.save(r);


    }

    @Override
    public void UpdateReferentiel(Referentiel r, Long idCat, Long idDom, Long idMes, Long idQes) {
        Categorie c=categoryRepo.findById(idCat).orElse(null);
        Domain domain=domaineRepo.findById(idDom).orElse(null);
        Mesure mesure=mesureRepo.findById(idMes).orElse(null);
        Question question=questionRepo.findById(idQes).orElse(null);
       // User user=userRepository.findById(idU).orElse(null);
        r.setCategorie(c);
        r.setDomain(domain);
        r.setMesure(mesure);
        r.setQuestion(question);
        //r.setUser(user);
        referentielRepo.save(r);
    }

    @Override
    public List<Referentiel> retrieveAllReferentiels() {
        List<Referentiel> referentiels=(List<Referentiel>) referentielRepo.findAll();
        return referentiels;
    }

    @Override
    public void deleteReferentiel(Long idRef) {
        referentielRepo.deleteById(idRef);

    }
}
