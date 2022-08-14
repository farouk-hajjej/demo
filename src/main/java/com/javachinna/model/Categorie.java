package com.javachinna.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;
    @JsonIgnore
    @OneToOne (mappedBy = "categorie")
    private Domain domain;
    @JsonIgnore
    @OneToOne(mappedBy = "categorie")
    private Referentiel referentiel;

}
