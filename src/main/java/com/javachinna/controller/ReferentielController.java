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
    @PostMapping("/AddReferentielAndAssignToOthers/{idDom}/{idQes}")
    @ResponseBody
    void ajouterReferentielEtAffectterToOthers(@RequestBody  Referentiel r,@PathVariable("idDom") Long idDom, @PathVariable("idQes") Long idQes){
      referentielService.ajouterReferentielEtAffectterToOthers(r,idDom,idQes);
    }
    @ApiOperation(value = "update Referentiel By Id ")
    @PutMapping("/updateReferentielById/{idDom}/{idQes}")
    @ResponseBody
    void UpdateReferentiel(@RequestBody  Referentiel r,@PathVariable("idDom") Long idDom, @PathVariable("idQes") Long idQes){
          referentielService.UpdateReferentiel(r,idDom,idQes);
    }@ApiOperation(value = "retrieve All Referentiels ")
    @GetMapping("/retrieve-All-Referentiels")
    @ResponseBody
    List<Referentiel> retrieveAllReferentiels(){
      return referentielService.retrieveAllReferentiels();
    }
    @ApiOperation(value = "delete Referentiel By Id ")
    @GetMapping("/deleteReferentielById/{idRef}")
    @ResponseBody
    void deleteReferentiel (@PathVariable("idRef") Long idRef){
     referentielService.deleteReferentiel(idRef);
    }
}
