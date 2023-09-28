package com.ksero.wholesalerservice.wholesalers.service;


import com.ksero.wholesalerservice.wholesalers.domain.model.entity.Wholesaler;
import com.ksero.wholesalerservice.wholesalers.domain.repository.WholesalerRepository;
import com.ksero.wholesalerservice.tools.exception.ResourceNotFoundException;
import com.ksero.wholesalerservice.tools.exception.ResourceValidationException;
import com.ksero.wholesalerservice.wholesalers.domain.service.WholesalerService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class WholesalerServiceImpl implements WholesalerService {

    private static final String entityName = "Wholesaler";
    private final WholesalerRepository wholesalerRepository;
    private final Validator validator;

    public WholesalerServiceImpl(WholesalerRepository wholesalerRepository, Validator validator) {
        this.wholesalerRepository = wholesalerRepository;
        this.validator = validator;
    }

    @Override
    public List<Wholesaler> getAll() {
        return wholesalerRepository.findAll();
    }

    @Override
    public Wholesaler getById(Long wholesalerId) {
        return wholesalerRepository.findByWholesalerId(wholesalerId).orElseThrow(() -> new ResourceNotFoundException(entityName, wholesalerId));
    }

    @Override
    public Wholesaler create(Wholesaler saveWholesaler) {
        Set<ConstraintViolation<Wholesaler>> violations = validator.validate(saveWholesaler);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entityName, violations);
        return wholesalerRepository.save(saveWholesaler);
    }

    @Override
    public Wholesaler update(Long wholesalerId, Wholesaler updatedWholesaler) {
        Set<ConstraintViolation<Wholesaler>> violations = validator.validate(updatedWholesaler);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entityName, violations);
        Optional<Wholesaler> wholesalerOptional = wholesalerRepository.findByWholesalerId(wholesalerId);
        if (wholesalerOptional.isPresent()) {
            Wholesaler wholesalerToUpdate = wholesalerOptional.get()
                    .withFirstName(updatedWholesaler.getFirstName())
                    .withLastName(updatedWholesaler.getLastName())
                    .withBirthday(updatedWholesaler.getBirthday())
                    .withPhone(updatedWholesaler.getPhone())
                    .withEmail(updatedWholesaler.getEmail())
                    .withAddress(updatedWholesaler.getAddress())
                    .withUsername(updatedWholesaler.getUsername())
                    .withPassword(updatedWholesaler.getPassword())
                    .withDescription(updatedWholesaler.getDescription())
                    .withCreditCardNumber(updatedWholesaler.getCreditCardNumber());
            return wholesalerRepository.save(wholesalerToUpdate);
        } else {
            throw new ResourceNotFoundException("Wholesaler not found.");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long wholesalerId) {
        return wholesalerRepository.findByWholesalerId(wholesalerId).map(wholesaler -> {
            wholesalerRepository.delete(wholesaler);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entityName, wholesalerId));
    }
}
