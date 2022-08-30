package com.javachinna.service;

import com.javachinna.model.Mesure;
import com.javachinna.model.Referentiel;

import java.util.List;

public interface IReferentielService {
    void ajouterReferentielEtAffectterToOthers(Referentiel r, Long idCat,Long idDom,Long idMes,Long idQes,Long idU);
    void UpdateReferentiel(Referentiel r, Long idCat,Long idDom,Long idMes,Long idQes,Long idU);
    List<Referentiel> retrieveAllReferentiels();
    void deleteReferentiel ( Long idRef);
}

