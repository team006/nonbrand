package com.nonbrand.nonbrand.entity.product;

import com.nonbrand.nonbrand.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Model extends BaseEntity {

    private String name;
    private String code;
}
