package com.javachinna.controller;

import com.javachinna.model.Referentiel;
import com.javachinna.repo.IReferentielRepo;
import com.javachinna.service.IReferentielService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/Referentiel")
public class ReferentielController {
    @Autowired
    IReferentielService referentielService;
    @ApiOperation(value = "Add Referentiel And Assign To Others ")
    @PostMapping("/AddReferentielAndAssignToOthers/{idCat}/{idDom}/{idMes}/{idQes}/{idU}")
    @ResponseBody
    void ajouterReferentielEtAffectterToOthers(@RequestBody  Referentiel r,@PathVariable("idCat") Long idCat,@PathVariable("idDom") Long idDom,@PathVariable("idMes") Long idMes, @PathVariable("idQes") Long idQes,@PathVariable("idU") Long idU){
      referentielService.ajouterReferentielEtAffectterToOthers(r,idCat,idDom,idMes,idQes,idU);
    }
    @ApiOperation(value = "update Referentiel By Id ")
    @PutMapping("/updateReferentielById/{idCat}/{idDom}/{idMes}/{idQes}/{idU}")
    @ResponseBody
    void UpdateReferentiel(@RequestBody  Referentiel r,@PathVariable("idCat") Long idCat,@PathVariable("idDom") Long idDom,@PathVariable("idMes") Long idMes, @PathVariable("idQes") Long idQes,@PathVariable("idU") Long idU){
          referentielService.UpdateReferentiel(r,idCat,idDom,idMes,idQes,idU);
    }@ApiOperation(value = "retrieve All Referentiels ")
    @GetMapping("/retrieve-All-Referentiels")
    @ResponseBody
    List<Referentiel> retrieveAllReferentiels(){
      return referentielService.retrieveAllReferentiels();
    }
    @ApiOperation(value = "delete Referentiel By Id ")
    @GetMapping("/deleteCategoryById/{idRef}")
    @ResponseBody
    void deleteReferentiel (@PathVariable("idRef") Long idRef){
     referentielService.deleteReferentiel(idRef);
    }
}
