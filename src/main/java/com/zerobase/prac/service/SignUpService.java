package com.zerobase.prac.service;

import com.zerobase.prac.domain.Partner;
import com.zerobase.prac.domain.User;
import com.zerobase.prac.dto.SignUpForm;
import com.zerobase.prac.repository.PartnerRepository;
import com.zerobase.prac.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final PartnerRepository partnerRepository;
    private final UserRepository userRepository;

    public Partner partnerSignUp(SignUpForm form) {

        if(isIdExist(form.getId())) {
            throw new RuntimeException("Partner already exists");
        }

        return partnerRepository.save(Partner.from(form));
    }

    public User userSignUp(SignUpForm form) {

        if (userRepository.findByUserId(form.getId()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        return userRepository.save(User.from(form));
    }


    public boolean isIdExist(String id) {
        return partnerRepository.findByPartnerId(id).isPresent();
    }


}
