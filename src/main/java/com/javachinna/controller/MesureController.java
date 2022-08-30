package com.javachinna.controller;

import com.javachinna.model.Mesure;
import com.javachinna.service.IMesureService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin()
@RequestMapping("/Mesure")
public class MesureController {
    @Autowired
    IMesureService mesureService;
    @ApiOperation(value = "Add Mesure And Assign To Category ")
    @PostMapping("/AddMesureAndAssignToCategory/{idCat}")
    @ResponseBody
    void ajouterMesureEtAffectterToCategory(@RequestBody Mesure m, @PathVariable("idCat") Long idCat){
    mesureService.ajouterMesureEtAffectterToCategory(m,idCat);
    }
    @ApiOperation(value = "update Mesure By Id ")
    @PutMapping("/updateMesureById/{idCat}")
    @ResponseBody
    void UpdateMesure(@RequestBody Mesure m,  @PathVariable("idCat")Long idCat){
       mesureService.UpdateMesure(m,idCat);
    }
    @ApiOperation(value = "retrieve All Mesures ")
    @GetMapping("/retrieve-All-Mesures")
    @ResponseBody
    List<Mesure> retrieveAllMesures(){
      return mesureService.retrieveAllMesures();
    }
    @ApiOperation(value = "delete Mesure By Id ")
    @GetMapping("/deleteMesureById/{idMes}")
    @ResponseBody
    void deleteMesure (@PathVariable("idMes") Long idMes){
       mesureService.deleteMesure(idMes);
    }
}
