package com.ksero.wholesalerservice.wholesalers.mapper;

import com.ksero.wholesalerservice.wholesalers.domain.model.entity.Wholesaler;
import com.ksero.wholesalerservice.wholesalers.resource.CreateWholesalerResource;
import com.ksero.wholesalerservice.wholesalers.resource.WholesalerResource;
import com.ksero.wholesalerservice.wholesalers.resource.UpdateWholesalerResource;
import com.ksero.wholesalerservice.tools.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WholesalerMapper {

    @Autowired
    EnhancedModelMapper enhancedModelMapper;

    // To Resource
    public WholesalerResource toResource(Wholesaler wholesalerModel) {
        return enhancedModelMapper.map(wholesalerModel, WholesalerResource.class);
    }

    public List<WholesalerResource> toListResource(List<Wholesaler> wholesalers) {
        return enhancedModelMapper.mapList(wholesalers, WholesalerResource.class);
    }

    // To Model
    public Wholesaler createResourceToModel(CreateWholesalerResource createWholesalerResource) {
        return enhancedModelMapper.map(createWholesalerResource, Wholesaler.class);
    }

    public Wholesaler updateResourceToModel(UpdateWholesalerResource updateWholesalerResource) {
        return enhancedModelMapper.map(updateWholesalerResource, Wholesaler.class);
    }

    public Wholesaler toModel(WholesalerResource wholesalerResource) {
        return enhancedModelMapper.map(wholesalerResource, Wholesaler.class);
    }

}
