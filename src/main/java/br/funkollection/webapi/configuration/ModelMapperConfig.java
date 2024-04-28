package br.funkollection.webapi.configuration;

import br.funkollection.webapi.domain.mappers.FunkoMapper;
import org.hibernate.annotations.Bag;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public FunkoMapper funkoMapper() {

        return new FunkoMapper(modelMapper());
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
