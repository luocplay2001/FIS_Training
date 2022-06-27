package fis.training.criminalsystemmanagement.service.impl;

import fis.training.criminalsystemmanagement.model.Detective;
import fis.training.criminalsystemmanagement.repository.DetectiveRepository;
import fis.training.criminalsystemmanagement.service.DetectiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DetectiveServiceImpl implements DetectiveService {

    DetectiveRepository detectiveRepository;

    @Autowired
    public DetectiveServiceImpl(DetectiveRepository detectiveRepository) {
        this.detectiveRepository = detectiveRepository;
    }

    @Override
    public List<Detective> getAllDetectives() {
        return detectiveRepository.findAll();
    }

    @Override
    public Detective getDetectiveById(Long id) {
        return detectiveRepository.findById(id).get();
    }

    @Override
    public Detective saveDetective(Detective detective) {
        return detectiveRepository.save(detective);
    }

    @Override
    public Detective updateDetective(Detective detective) {
        return detectiveRepository.save(detective);
    }

    @Override
    public void deleteDetectiveById(Long id) {
        detectiveRepository.deleteById(id);
    }
}
