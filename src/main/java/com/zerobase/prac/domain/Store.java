package com.zerobase.prac.domain;

import com.zerobase.prac.dto.RegisterForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String location;
    private String description;
    private String partnerId;

    public static Store from(RegisterForm form) {
        return Store.builder()
                .name(form.getName())
                .location(form.getLocation())
                .description(form.getDesc())
                .partnerId(form.getPartnerId())
                .build();
    }
}
