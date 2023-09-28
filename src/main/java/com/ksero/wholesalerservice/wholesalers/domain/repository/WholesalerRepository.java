package com.ksero.wholesalerservice.wholesalers.domain.repository;

import com.ksero.wholesalerservice.wholesalers.domain.model.entity.Wholesaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface WholesalerRepository extends JpaRepository<Wholesaler, Long> {

    List<Wholesaler> findAll();
    Optional<Wholesaler> findByWholesalerId(Long wholesalerId);
    //Boolean verifyByWholesalerId(Long wholesalerId);
    //Optional<Wholesaler> findByWholesalerUsername(String wholesalerUsername);
    //Boolean verifyByWholesalerUsername(String wholesalerUsername);

}
