package com.ksero.wholesalerservice.wholesalers.domain.service;

import com.ksero.wholesalerservice.wholesalers.domain.model.entity.Wholesaler;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WholesalerService {

    List<Wholesaler> getAll();
    Wholesaler getById(Long id);
    Wholesaler create(Wholesaler saveWholesaler);
    Wholesaler update(Long id, Wholesaler updateWholesaler);
    ResponseEntity<?> delete(Long id);

}
