package com.zerobase.prac.repository;

import com.zerobase.prac.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> deleteByName(String name);

    Optional<Store> findByName(String name);
}
