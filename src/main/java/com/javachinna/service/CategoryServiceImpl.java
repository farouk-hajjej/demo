package com.javachinna.service;

import com.javachinna.model.Categorie;
import com.javachinna.model.Domain;
import com.javachinna.repo.ICategoryRepo;
import com.javachinna.repo.IDomaineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private IDomaineRepo domaineRepo;
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public void ajouterCategorieEtAffectterToDomaine(Categorie c, Long idDom) {
       Domain domain=domaineRepo.findById(idDom).orElse(null);
       c.setDomain(domain);
       categoryRepo.save(c);
    }

    @Override
    public void UpdateCategorys(Categorie c, Long idDom) {
       // Categorie categorie=categoryRepo.findById(id).orElse(null);
      //  d.setCodeDomaine(d.getCodeDomaine());
        Domain domain=domaineRepo.findById(idDom).orElse(null);
        c.setDomain(domain);
        categoryRepo.save(c);
    }

    @Override
    public List<Categorie> retrieveAllCategory() {
        List<Categorie> categories=(List<Categorie>) categoryRepo.findAll();
        return categories;

    }

    @Override
    public void deleteCategory(Long idCat) {
      categoryRepo.deleteById(idCat);
    }
}
