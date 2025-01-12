package com.zerobase.prac.dto;

import com.zerobase.prac.domain.Store;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {

    private String name;
    private String location;
    private String desc;
    private String partnerId;

}
