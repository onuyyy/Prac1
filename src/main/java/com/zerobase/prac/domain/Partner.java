package com.zerobase.prac.domain;

import com.zerobase.prac.dto.SignUpForm;
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
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String partnerId;
    private String password;

    public static Partner from(SignUpForm form) {
        return Partner.builder()
                .partnerId(form.getId())
                .password(form.getPassword())
                .build();
    }

}
