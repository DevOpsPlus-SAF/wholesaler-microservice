package com.ksero.wholesalerservice.wholesalers.mapper;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("wholesaleMapperConfiguration")
public class WholesaleMapperConfiguration {

    @Bean
    public WholesalerMapper productMapper() {
        return new WholesalerMapper();
    }

}
