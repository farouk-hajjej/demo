package com.javachinna.controller;

import com.javachinna.model.Domain;
import com.javachinna.model.Question;
import com.javachinna.service.DomaineServiceImpl;
import com.javachinna.service.IDomaineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/Domaine")
public class DomainController {
    @Autowired
    IDomaineService domaineService;
    @PostMapping("/addDomain")
    @ResponseBody
    @ApiOperation(value = "Add Domain")
    public void addDomain(@RequestBody Domain d){
        domaineService.addDomain(d);

    }
    @ApiOperation(value = "update Domain By Id ")
    @PutMapping("/updateDomainById/{idD}")
    @ResponseBody
    public void UpdateDomain(@RequestBody Domain d, @PathVariable(name="idD") Long idD){
        domaineService.UpdateDomain(d,idD);
    }
    @ApiOperation(value = "retrieve All Domains ")
    @GetMapping("/retrieve-All-Domains")
    @ResponseBody
    public List<Domain> retrieveAllDomains(){
        return domaineService.retrieveAllDomains();
    }
    @ApiOperation(value = "delete Domain By Id ")
    @GetMapping("/deleteDomainById/{idD}")
    @ResponseBody
    public void deleteDomain(@PathVariable("idD")Long id)
    {
        domaineService.deleteDomain(id);
    }
}
