package com.javachinna.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long codeQues;
    private String Domain;
    private String Categorie;
    private String Mesure;
    private String Contenu;
    private String Recommandation;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToOne(mappedBy = "question")
    private Mesure mesures;

}
