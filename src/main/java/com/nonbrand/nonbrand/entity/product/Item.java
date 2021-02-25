package com.nonbrand.nonbrand.entity.product;

import com.nonbrand.nonbrand.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Item extends BaseEntity {

    private String name;
    private String code;
    private Integer cost;
    private Integer balance;

    @ManyToOne
    private Type type;





}
