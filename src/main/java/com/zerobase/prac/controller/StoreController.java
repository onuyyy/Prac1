package com.zerobase.prac.controller;

import com.zerobase.prac.domain.Store;
import com.zerobase.prac.dto.RegisterForm;
import com.zerobase.prac.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    @RequestMapping("/{name}")
    public ResponseEntity<Store> getStore(@PathVariable String name) {
        return ResponseEntity.ok(storeService.getStore(name));
    }

    @PostMapping("/register")
    public ResponseEntity<Store> register(@RequestBody RegisterForm form) {
        return ResponseEntity.ok(storeService.storeRegister(form));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> delete(@PathVariable("name") String name) {
        storeService.storeDelete(name);
        return ResponseEntity.ok(name + " deleted!");
    }

    @PostMapping("/update")
    public ResponseEntity<Store> update(@RequestBody RegisterForm form) {
        return ResponseEntity.ok(storeService.storeUpdate(form));
    }

}
