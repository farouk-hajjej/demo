package com.javachinna.service;

import com.javachinna.model.Mesure;
import com.javachinna.model.Referentiel;

import java.util.List;

public interface IReferentielService {
    void ajouterReferentielEtAffectterToOthers(Referentiel r,Long idDom,Long idQes);
    void UpdateReferentiel(Referentiel r,Long idDom,Long idQes);
    List<Referentiel> retrieveAllReferentiels();
    void deleteReferentiel ( Long idRef);
}

