package br.funkollection.webapi.controllers;

import br.funkollection.webapi.domain.DTOs.SerieDTO;
import br.funkollection.webapi.services.SerieService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/serie")
@CrossOrigin(maxAge = 3600, originPatterns = "*")
public class SerieController {
    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public List<SerieDTO> getAll() {
        return serieService.listAllSeries();
    }
}
