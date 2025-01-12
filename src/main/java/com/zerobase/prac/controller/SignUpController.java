package com.zerobase.prac.controller;

import com.zerobase.prac.domain.Partner;
import com.zerobase.prac.domain.User;
import com.zerobase.prac.dto.SignUpForm;
import com.zerobase.prac.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping("/partner")
    public ResponseEntity<Partner> partnerSignUp(@RequestBody SignUpForm form) {
        return ResponseEntity.ok(signUpService.partnerSignUp(form));
    }

    @PostMapping("/user")
    public ResponseEntity<User> userSignUp(@RequestBody SignUpForm form) {
        return ResponseEntity.ok(signUpService.userSignUp(form));
    }
}
