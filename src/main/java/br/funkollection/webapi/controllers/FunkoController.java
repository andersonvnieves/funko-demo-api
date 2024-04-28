package br.funkollection.webapi.controllers;

import br.funkollection.webapi.domain.DTOs.FunkoDTO;
import br.funkollection.webapi.services.FunkoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/funko")
@CrossOrigin(maxAge = 3600, originPatterns = "*")
public class FunkoController {

    private final FunkoService funkoService;
    Logger logger = LoggerFactory.getLogger(FunkoController.class);

    public FunkoController(FunkoService funkoService) {
        this.funkoService = funkoService;
    }

    @PostMapping
    public FunkoDTO create(@Valid @RequestBody FunkoDTO funkoDTO) {
        return funkoService.createFunko(funkoDTO);
    }

    @GetMapping
    public List<FunkoDTO> getAll() {
        return funkoService.listAllFunkos();
    }

    @PutMapping
    public FunkoDTO update(@Valid @RequestBody FunkoDTO funkoDTO) {
        return funkoService.updateFunko(funkoDTO);
    }

    @DeleteMapping(path = "/{funkoId}")
    public void delete(@PathVariable("funkoId") String funkoId) {
        funkoService.deleteFunko(funkoId);
    }
}
