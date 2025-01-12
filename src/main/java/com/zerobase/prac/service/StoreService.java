package com.zerobase.prac.service;

import com.zerobase.prac.domain.Store;
import com.zerobase.prac.dto.RegisterForm;
import com.zerobase.prac.repository.PartnerRepository;
import com.zerobase.prac.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final PartnerRepository partnerRepository;

    public Store storeRegister(RegisterForm form) {

        partnerRepository.findByPartnerId(form.getPartnerId())
                .orElseThrow(() -> new RuntimeException("파트너 회원이 아닙니다."));

        return storeRepository.save(Store.from(form));
    }

    public void storeDelete(String name) {

        Optional<Store> store = storeRepository.findByName(name);

        storeRepository.delete(store.get());
    }

    public Store storeUpdate(RegisterForm store) {

        Optional<Store> storeOptional = storeRepository.findByName(store.getName());

        if (storeOptional.isPresent()) {
            Store s = storeOptional.get();

            s.setName(store.getName());
            s.setDescription(store.getDesc());
            s.setLocation(store.getLocation());

            return storeRepository.save(s);
        } else {
            throw new RuntimeException("Store not found " + store.getName());
        }
    }


    public Store getStore(String name) {
        return storeRepository.findByName(name).orElseThrow(() -> new RuntimeException("Store not found " + name));
    }
}
