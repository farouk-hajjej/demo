package com.javachinna.service;


import com.javachinna.model.Mesure;

import java.util.List;

public interface IMesureService {
    void ajouterMesureEtAffectterToCategory(Mesure m, Long idCat);
    void UpdateMesure(Mesure m, Long idCat);
    List<Mesure> retrieveAllMesures();
    void deleteMesure ( Long idMes);
}
