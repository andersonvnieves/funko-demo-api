package br.funkollection.webapi.services;

import br.funkollection.webapi.domain.DTOs.FunkoDTO;
import br.funkollection.webapi.domain.entities.Category;
import br.funkollection.webapi.domain.entities.Funko;
import br.funkollection.webapi.domain.entities.Serie;
import br.funkollection.webapi.domain.mappers.FunkoMapper;
import br.funkollection.webapi.repositories.FunkoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FunkoService {
    private final FunkoRepository funkoRepository;
    private final CategoryService categoryService;
    private final SerieService serieService;
    private final FunkoMapper funkoMapper;

    public FunkoService(FunkoRepository funkoRepository, CategoryService categoryService, SerieService serieService, FunkoMapper funkoMapper) {
        this.funkoRepository = funkoRepository;
        this.categoryService = categoryService;
        this.serieService = serieService;
        this.funkoMapper = funkoMapper;
    }

    public FunkoDTO createFunko(FunkoDTO funkoDTO){
        //Validate funko obj
        var funko = new Funko();
        funko.setName(funkoDTO.getName());
        funko.setCategory(categoryService.findCategoryByLabel(funkoDTO.getCategory()));
        funko.setSerie(serieService.createSerieIfDoesntExits(funkoDTO.getSerie()));
        funko.setImageUrl(funkoDTO.getImageUrl());
        funko.setCreatedAt(new Date());
        var savedFunko = funkoRepository.save(funko);
        funkoDTO.setId(savedFunko.getId());
        return funkoDTO;
    }

    public FunkoDTO updateFunko(FunkoDTO funkoDTO) {
        var funko = funkoRepository.findFunkoById(funkoDTO.getId());
        if(funko != null){
            funko.setName(funkoDTO.getName());
            funko.setCategory(categoryService.findCategoryByLabel(funkoDTO.getCategory()));
            funko.setSerie(serieService.createSerieIfDoesntExits(funkoDTO.getSerie()));
            funko.setImageUrl(funkoDTO.getImageUrl());
            funko.setLastModifiedAt(new Date());
            funkoRepository.save(funko);
        }
        return funkoDTO;
    }

    public void deleteFunko(String funkoId){
        funkoRepository.deleteById(funkoId);
    }

    public List<FunkoDTO> listAllFunkos(){
        var funkosDTO = new ArrayList<FunkoDTO>();
        var funkos = funkoRepository.findAll();
        if(!funkos.isEmpty())
            funkos.forEach(funko -> {
                funkosDTO.add(funkoMapper.FunkoToFunkoDTO(funko));
            });
        return funkosDTO;
    }
}
