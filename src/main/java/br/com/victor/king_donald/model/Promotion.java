package br.com.victor.king_donald.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Ingredient hasIngredient;
    private Integer forEachNumber;
    @ManyToOne
    private Ingredient dontHasIngredient;
    DiscountType discountType;

}
