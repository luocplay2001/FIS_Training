package fis.training.criminalsystemmanagement.controller;

import fis.training.criminalsystemmanagement.config.ApplicationConfig;
import fis.training.criminalsystemmanagement.core.SetEntity;
import fis.training.criminalsystemmanagement.dto.EvidenceDTO;
import fis.training.criminalsystemmanagement.model.Evidence;
import fis.training.criminalsystemmanagement.service.EvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceController {

    private ModelMapper modelMapper = ApplicationConfig.modelMapper();

    @Autowired
    private EvidenceService evidenceService;

    @GetMapping
    public List<EvidenceDTO> getAllEvidence() {
        return evidenceService.getAllEvidences().stream()
                .map(evidence -> modelMapper.map(evidence, EvidenceDTO.class))
                .collect(Collectors.toList());

    }

    @GetMapping("/{evidenceId}")
    public EvidenceDTO getById(@PathVariable(name = "evidenceId") Long id) {
        return modelMapper.map(evidenceService.getEvidenceById(id),EvidenceDTO.class);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<EvidenceDTO> createEvidence(@RequestBody EvidenceDTO evidenceDTO) {

        // convert DTO to entity
        Evidence evidenceRequest = modelMapper.map(evidenceDTO, Evidence.class);

        Evidence evidence = evidenceService.saveEvidence(evidenceRequest);

        // convert entity to DTO
        EvidenceDTO evidenceResponse = modelMapper.map(evidence, EvidenceDTO.class);

        return new ResponseEntity<EvidenceDTO>(evidenceResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvidenceDTO> updateEvidence(@PathVariable Long id,
                                                              @RequestBody EvidenceDTO evidenceDTO) {

        // convert DTO to entity
        Evidence evidenceRequest = modelMapper.map(evidenceDTO, Evidence.class);
        Evidence e = evidenceService.getEvidenceById(id);
//        BeanUtils.copyProperties(EvidenceRequest,c);
        SetEntity.setEvidence(e,evidenceRequest);
        Evidence evidence = evidenceService.updateEvidence(e);

        // convert entity to DTO
        EvidenceDTO evidenceResponse = modelMapper.map(evidence, EvidenceDTO.class);

        return new ResponseEntity<EvidenceDTO>(evidenceResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable(name = "id") Long id) {
        evidenceService.deleteEvidenceById(id);
        return new ResponseEntity<>(
                "Delete successfully",
                HttpStatus.OK);
    }
}
