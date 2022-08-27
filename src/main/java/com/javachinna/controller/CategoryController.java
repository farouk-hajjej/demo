package com.javachinna.controller;

import com.javachinna.model.Categorie;
import com.javachinna.service.ICategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/Categorie")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @ApiOperation(value = "Add Category And Assign To Domain ")
    @PostMapping("/AddCategoryAndAssignToDomain/{idDom}")
    @ResponseBody
    public void ajouterCategorieEtAffectterToDomaine(@RequestBody Categorie c, @PathVariable("idDom")Long idDom) {
    categoryService.ajouterCategorieEtAffectterToDomaine(c,idDom);
    }
    @ApiOperation(value = "update Category By Id ")
    @PutMapping("/updateCategoryById/{idDom}")
    @ResponseBody
    public void UpdateCategorys(@RequestBody Categorie c,@PathVariable("idDom") Long idDom) {
      categoryService.UpdateCategorys(c,idDom);
    }
    @ApiOperation(value = "retrieve All Categorys ")
    @GetMapping("/retrieve-All-Categorys")
    @ResponseBody
    public List<Categorie> retrieveAllCategory() {
        return categoryService.retrieveAllCategory();
    }
    @ApiOperation(value = "delete Category By Id ")
    @GetMapping("/deleteCategoryById/{idCat}")
    @ResponseBody
    public void deleteCategory(@PathVariable("idCat")Long idCat) {
       categoryService.deleteCategory(idCat);
    }
}
