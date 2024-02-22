package com.ninjacart.agri.advisory.crop.api;

import com.ninjacart.agri.advisory.crop.controllers.CropDetailsApi;
import com.ninjacart.agri.advisory.crop.models.CropDetails;
import com.ninjacart.agri.advisory.crop.service.CropDetailsService;
import com.ninjacart.agri.advisory.refdata.models.EppoCode;
import com.ninjacart.agri.advisory.refdata.service.EppoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RestController
public class CropDetailsController implements CropDetailsApi {


    private final CropDetailsService cropDetailsService;

    @Autowired
    public CropDetailsController(CropDetailsService cropDetailsService) {
        this.cropDetailsService = cropDetailsService;
    }

    @Override
    public ResponseEntity<CropDetails> addCropDetails(String realmId, Integer userId, String toolID, CropDetails cropDetails) {
        CropDetails savedCropDetails = cropDetailsService.saveCropDetails(cropDetails, userId, toolID, realmId);
        return ResponseEntity.ok(savedCropDetails);
    }

    @Override
    public ResponseEntity<Void> deleteCropDetailsById(String realmId, Integer userId, String toolID, Integer id) {
        cropDetailsService.deleteCropDetails(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CropDetails> getCropDetailsById(String realmId, Integer userId, String toolID, Integer id) {
        return cropDetailsService.getCropDetailsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<CropDetails> updateCropDetailsById(String realmId, Integer userId, String toolID, Integer id, CropDetails cropDetails) {
        CropDetails updatedCropDetails =
                cropDetailsService.updateCropDetails(id, cropDetails, userId, toolID, realmId);
        return ResponseEntity.ok(updatedCropDetails);
    }
}
