package fis.training.criminalsystemmanagement.service;


import fis.training.criminalsystemmanagement.model.Detective;

import java.util.List;

public interface DetectiveService {


    List<Detective> getAllDetectives();

    Detective getDetectiveById(Long id);

    Detective saveDetective(Detective detective);

    Detective updateDetective(Detective detective);

    void deleteDetectiveById(Long id);
}
