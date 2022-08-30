package com.javachinna.service;

import com.javachinna.model.Categorie;
import com.javachinna.model.Domain;
import com.javachinna.model.Mesure;
import com.javachinna.repo.ICategoryRepo;
import com.javachinna.repo.IMesureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MesureServiceImpl implements IMesureService{
    @Autowired
    IMesureRepo mesureRepo;
    @Autowired
    ICategoryRepo categoryRepo;
    @Override
    public void ajouterMesureEtAffectterToCategory(Mesure m, Long idCat) {
        Categorie categorie=categoryRepo.findById(idCat).orElse(null);
        m.setCategorie(categorie);
        mesureRepo.save(m);
    }

    @Override
    public void UpdateMesure(Mesure m, Long idCat) {
        Categorie categorie=categoryRepo.findById(idCat).orElse(null);
        m.setCategorie(categorie);
        mesureRepo.save(m);
    }

    @Override
    public List<Mesure> retrieveAllMesures() {
        List<Mesure> mesures=(List<Mesure>) mesureRepo.findAll();
        return mesures;
    }

    @Override
    public void deleteMesure(Long idMes) {
        mesureRepo.deleteById(idMes);

    }
}
