package fis.training.criminalsystemmanagement.controller;

import fis.training.criminalsystemmanagement.config.ApplicationConfig;
import fis.training.criminalsystemmanagement.core.SetEntity;
import fis.training.criminalsystemmanagement.dto.DetectiveDTO;
import fis.training.criminalsystemmanagement.model.Detective;
import fis.training.criminalsystemmanagement.service.DetectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/detective")
public class DetectiveController {

    private ModelMapper modelMapper = ApplicationConfig.modelMapper();

    @Autowired
    private DetectiveService detectiveService;

    @GetMapping
    public List<DetectiveDTO> getAllDetective() {
        return detectiveService.getAllDetectives().stream()
                .map(detective -> modelMapper.map(detective, DetectiveDTO.class))
                .collect(Collectors.toList());

    }

    @GetMapping("/{detectiveId}")
    public DetectiveDTO getById(@PathVariable(name = "detectiveId") Long id) {
        return modelMapper.map(detectiveService.getDetectiveById(id),DetectiveDTO.class);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<DetectiveDTO> createDetective(@RequestBody DetectiveDTO detectiveDTO) {

        // convert DTO to entity
        Detective detectiveRequest = modelMapper.map(detectiveDTO, Detective.class);

        Detective detective = detectiveService.saveDetective(detectiveRequest);

        // convert entity to DTO
        DetectiveDTO detectiveResponse = modelMapper.map(detective, DetectiveDTO.class);

        return new ResponseEntity<DetectiveDTO>(detectiveResponse, HttpStatus.CREATED);
    }

    @PutMapping( "/{id}")
    public ResponseEntity<DetectiveDTO> updateDetective(@PathVariable Long id,
                                                              @RequestBody DetectiveDTO detectiveDTO) {

        // convert DTO to entity
        Detective detectiveRequest = modelMapper.map(detectiveDTO, Detective.class);
        Detective d = detectiveService.getDetectiveById(id);
//        BeanUtils.copyProperties(DetectiveRequest,c);
        SetEntity.setDetective(d,detectiveRequest);
        Detective detective = detectiveService.updateDetective(d);

        // convert entity to DTO
        DetectiveDTO detectiveResponse = modelMapper.map(detective, DetectiveDTO.class);

        return new ResponseEntity<DetectiveDTO>(detectiveResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable(name = "id") Long id) {
        detectiveService.deleteDetectiveById(id);
        return new ResponseEntity<>(
                "Delete successfully",
                HttpStatus.OK);
    }
}
