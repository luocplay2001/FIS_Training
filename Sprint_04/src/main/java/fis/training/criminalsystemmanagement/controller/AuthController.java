package fis.training.criminalsystemmanagement.controller;

import fis.training.criminalsystemmanagement.config.ApplicationConfig;
import fis.training.criminalsystemmanagement.dto.CriminalCaseDTO;
import fis.training.criminalsystemmanagement.dto.EvidenceDTO;
import fis.training.criminalsystemmanagement.model.enums.CaseStatus;
import fis.training.criminalsystemmanagement.service.CriminalCaseService;
import fis.training.criminalsystemmanagement.service.EvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth/criminalCase")
public class AuthController {

    private ModelMapper modelMapper = ApplicationConfig.modelMapper();

    @Autowired
    private CriminalCaseService criminalCaseService;

    @Autowired
    private EvidenceService evidenceService;

    @GetMapping("/status/{caseStatus}")
    public List<CriminalCaseDTO> getCaseByStatus(@PathVariable("caseStatus") String caseStatus) {
        return criminalCaseService.findAllByStatus(CaseStatus.valueOf(caseStatus))
                .stream().map(criminalCase -> modelMapper.map(criminalCase, CriminalCaseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/number/{caseNumber}")
    public List<EvidenceDTO> getEvidencesByCaseNumber(@PathVariable("caseNumber") String caseNumber) {
        return evidenceService.findByCriminalCase_Number(caseNumber)
                .stream().map(evidence -> modelMapper.map(evidence, EvidenceDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/username/{username}")
    public List<CriminalCaseDTO> getCaseByUsername(@PathVariable("username") String username) {
        return criminalCaseService.findByAssigned_Username(username)
                .stream().map(criminalCase -> modelMapper.map(criminalCase, CriminalCaseDTO.class))
                .collect(Collectors.toList());
    }
}
