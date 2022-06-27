package fis.training.criminalsystemmanagement.controller;

import fis.training.criminalsystemmanagement.config.ApplicationConfig;
import fis.training.criminalsystemmanagement.core.SetEntity;
import fis.training.criminalsystemmanagement.dto.CriminalCaseDTO;
import fis.training.criminalsystemmanagement.dto.EvidenceDTO;
import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.enums.CaseStatus;
import fis.training.criminalsystemmanagement.service.CriminalCaseService;
import fis.training.criminalsystemmanagement.service.EvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/criminalCase")
public class CriminalCaseController {

    private ModelMapper modelMapper = ApplicationConfig.modelMapper();

    @Autowired
    private CriminalCaseService criminalCaseService;


    @GetMapping
    public List<CriminalCaseDTO> getAllCriminalCase() {
        return criminalCaseService.getAllCriminalCases().stream()
                .map(criminalCase -> modelMapper.map(criminalCase, CriminalCaseDTO.class))
                .collect(Collectors.toList());

    }

    @GetMapping("/{criminalCaseId}")
    public CriminalCaseDTO getById(@PathVariable(name = "criminalCaseId") Long id) {
        return modelMapper.map(criminalCaseService.getCriminalCaseById(id),CriminalCaseDTO.class);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<CriminalCaseDTO> createCriminalCase(@RequestBody CriminalCaseDTO criminalCaseDTO) {

        // convert DTO to entity
        CriminalCase criminalCaseRequest = modelMapper.map(criminalCaseDTO, CriminalCase.class);

        CriminalCase criminalCase = criminalCaseService.saveCriminalCase(criminalCaseRequest);

        // convert entity to DTO
        CriminalCaseDTO criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDTO.class);

        return new ResponseEntity<CriminalCaseDTO>(criminalCaseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriminalCaseDTO> updateCriminalCase(@PathVariable Long id,
                                                              @RequestBody CriminalCaseDTO criminalCaseDTO) {

        // convert DTO to entity
        CriminalCase criminalCaseRequest = modelMapper.map(criminalCaseDTO, CriminalCase.class);
        CriminalCase c = criminalCaseService.getCriminalCaseById(id);
//        BeanUtils.copyProperties(criminalCaseRequest,c);
        SetEntity.setCriminalCase(c,criminalCaseRequest);
        CriminalCase criminalCase = criminalCaseService.updateCriminalCase(c);

        // convert entity to DTO
        CriminalCaseDTO criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDTO.class);

        return new ResponseEntity<CriminalCaseDTO>(criminalCaseResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable(name = "id") Long id) {
        criminalCaseService.deleteCriminalCaseById(id);
        return new ResponseEntity<>(
                "Delete successfully",
                HttpStatus.OK);
    }


}
