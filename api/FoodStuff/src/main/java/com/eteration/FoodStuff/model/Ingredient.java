package com.eteration.FoodStuff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("recipe")
public class Ingredient  extends BaseEntity{
    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,targetEntity = Recipe.class)
    private Recipe recipe;
}