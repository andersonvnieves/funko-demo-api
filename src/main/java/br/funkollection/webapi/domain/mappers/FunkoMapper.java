package br.funkollection.webapi.domain.mappers;

import br.funkollection.webapi.domain.DTOs.FunkoDTO;
import br.funkollection.webapi.domain.entities.Funko;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class FunkoMapper {

    private final ModelMapper modelMapper;

    public FunkoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.addMappings(new PropertyMap<Funko, FunkoDTO>() {
            @Override
            protected void configure() {
                map().setCategory(source.getCategory().getLabel());
                map().setSerie(source.getSerie().getLabel());
            }
        });
    }

    public FunkoDTO FunkoToFunkoDTO(Funko funko) {
        return modelMapper.map(funko, FunkoDTO.class);
    }
}
