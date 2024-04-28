package br.funkollection.webapi.services;

import br.funkollection.webapi.domain.DTOs.CategoryDTO;
import br.funkollection.webapi.domain.DTOs.SerieDTO;
import br.funkollection.webapi.domain.entities.Serie;
import br.funkollection.webapi.repositories.SerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final ModelMapper modelMapper;

    public SerieService(SerieRepository serieRepository, ModelMapper modelMapper) {
        this.serieRepository = serieRepository;
        this.modelMapper = modelMapper;
    }

    public Serie createSerieIfDoesntExits(String label) {
        var serie = serieRepository.findSerieByLabel(label);
        if(serie == null) {
            serie = new Serie();
            serie.setLabel(label);
            serie = serieRepository.save(serie);
        }
        return serie;
    }

    public List<SerieDTO> listAllSeries() {
        var seriesDTO = new ArrayList<SerieDTO>();
        var series = serieRepository.findAll();
        if(!series.isEmpty()){
            series.forEach(serie -> seriesDTO.add(modelMapper.map(serie, SerieDTO.class)));
        }
        return seriesDTO;
    }
}
