package com.artcruz.limitsservice.model.entity;

import lombok.*;

import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Limits {

    private Integer minimum;
    private Integer maximum;

}
