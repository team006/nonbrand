package com.nonbrand.nonbrand.entity.product;

import com.nonbrand.nonbrand.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Type extends BaseEntity {

    private String name;
    private String code;
    private Integer categoryCount;

    @OneToMany
    private List<Category> category;
    @OneToMany
    private List<Size> size;
    @OneToMany
    private List<Model> model;

}
