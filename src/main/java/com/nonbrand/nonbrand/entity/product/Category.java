package com.nonbrand.nonbrand.entity.product;

import com.nonbrand.nonbrand.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Category extends BaseEntity {

    private String name;
    private String code;

}
