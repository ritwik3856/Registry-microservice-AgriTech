package com.ninjacart.agri.advisory.refdata.api;

import com.ninjacart.agri.advisory.refdata.controllers.UnspscCodesApi;
import com.ninjacart.agri.advisory.refdata.models.UnspscCode;
import com.ninjacart.agri.advisory.refdata.service.UnspscCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class UnspscCodeController implements UnspscCodesApi {

    private final UnspscCodeService UnspscCodeService;

    @Autowired
    public UnspscCodeController(UnspscCodeService UnspscCodeService) {
        this.UnspscCodeService = UnspscCodeService;
    }


    @Override
    public ResponseEntity<UnspscCode> addUnspscCode(String realmId, Integer userId, String toolID, UnspscCode UnspscCode) {
        UnspscCode savedUnspscCode = UnspscCodeService.saveUnspscCode(UnspscCode, userId, toolID, realmId);
        return ResponseEntity.ok(savedUnspscCode);
    }

    @Override
    public ResponseEntity<Void> deleteUnspscCodeById(String realmId, Integer userId, String toolID, Integer id) {
        UnspscCodeService.deleteUnspscCode(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UnspscCode> getUnspscCodeById(String realmId, Integer userId, String toolID, Integer id) {
        return UnspscCodeService.getUnspscCodeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<UnspscCode> updateUnspscCode(String realmId, Integer userId, String toolID, Integer id, UnspscCode UnspscCode) {
        UnspscCode updatedUnspscCode =
                UnspscCodeService.updateUnspscCode(id, UnspscCode, userId, toolID, realmId);
        return ResponseEntity.ok(updatedUnspscCode);
    }
}
