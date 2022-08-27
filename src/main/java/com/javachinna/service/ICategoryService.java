package com.javachinna.service;

import com.javachinna.model.Categorie;
import com.javachinna.model.Domain;

import java.util.List;

public interface ICategoryService {
    void ajouterCategorieEtAffectterToDomaine(Categorie c,Long idDom);
    void UpdateCategorys(Categorie c, Long idDom);
    List<Categorie> retrieveAllCategory();
    void deleteCategory ( Long idCat);
}
