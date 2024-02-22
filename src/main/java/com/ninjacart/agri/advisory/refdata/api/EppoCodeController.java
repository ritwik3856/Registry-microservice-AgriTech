package com.ninjacart.agri.advisory.refdata.api;

import com.ninjacart.agri.advisory.refdata.controllers.EppoCodesApi;
import com.ninjacart.agri.advisory.refdata.models.EppoCode;
import com.ninjacart.agri.advisory.refdata.service.EppoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class EppoCodeController implements EppoCodesApi {


    private final EppoCodeService eppoCodeService;

    @Autowired
    public EppoCodeController(EppoCodeService eppoCodeService) {
        this.eppoCodeService = eppoCodeService;
    }


    @Override
    public ResponseEntity<EppoCode> addEppoCode(String realmId, Integer userId, String toolID, EppoCode eppoCode) {
        EppoCode savedEppoCode = eppoCodeService.saveEppoCode(eppoCode, userId, toolID, realmId);
        return ResponseEntity.ok(savedEppoCode);
    }

    @Override
    public ResponseEntity<Void> deleteEppoCodeById(String realmId, Integer userId, String toolID, Integer id) {
        eppoCodeService.deleteEppoCode(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<EppoCode> getEppoCodeById(String realmId, Integer userId, String toolID, Integer id) {
        return eppoCodeService.getEppoCodeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<EppoCode> updateEppoCode(String realmId, Integer userId, String toolID, Integer id, EppoCode eppoCode) {
        EppoCode updatedEppoCode =
                eppoCodeService.updateEppoCode(id, eppoCode, userId, toolID, realmId);
        return ResponseEntity.ok(updatedEppoCode);
    }
}
