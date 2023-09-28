package com.ksero.wholesalerservice.wholesalers.api;

import com.ksero.wholesalerservice.wholesalers.domain.model.entity.Wholesaler;
import com.ksero.wholesalerservice.wholesalers.domain.service.WholesalerService;
import com.ksero.wholesalerservice.wholesalers.mapper.WholesalerMapper;
import com.ksero.wholesalerservice.wholesalers.resource.CreateWholesalerResource;
import com.ksero.wholesalerservice.wholesalers.resource.WholesalerResource;
import com.ksero.wholesalerservice.wholesalers.resource.UpdateWholesalerResource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/wholesalers")
public class WholesalerController {
    private final WholesalerService wholesalerService;
    private final WholesalerMapper mapper;

    public WholesalerController(WholesalerService wholesalerService, WholesalerMapper mapper) {
        this.wholesalerService = wholesalerService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<WholesalerResource> getAll() {
        return mapper.toListResource(wholesalerService.getAll());
    }


    @GetMapping("{wholesalerId}")
    public WholesalerResource getWholesalerById(@PathVariable Long wholesalerId) {
        return mapper.toResource(wholesalerService.getById(wholesalerId));
    }

    @PostMapping
    public WholesalerResource createWholesaler(@RequestBody CreateWholesalerResource resource) {
        return mapper.toResource(wholesalerService.create(mapper.createResourceToModel(resource)));
    }

    @PutMapping("{wholesalerId}")
    public WholesalerResource updateWholesaler(@PathVariable Long wholesalerId,
                                         @RequestBody @Valid UpdateWholesalerResource resource) {
        return mapper.toResource(wholesalerService.update(wholesalerId, mapper.updateResourceToModel(resource)));
    }

    @DeleteMapping("{wholesalerId}")
    public ResponseEntity<?> deleteWholesaler(@PathVariable Long wholesalerId) {
        return wholesalerService.delete(wholesalerId);
    }

}
