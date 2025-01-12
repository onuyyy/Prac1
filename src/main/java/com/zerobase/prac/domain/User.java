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
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;
    private String password;

    public static User from(SignUpForm form) {
        return User.builder()
                .userId(form.getId())
                .password(form.getPassword())
                .build();
    }
}
