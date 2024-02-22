package com.ninjacart.agri.advisory.pesticide.api;

import com.ninjacart.agri.advisory.common.exception.EntityNotFoundException;
import com.ninjacart.agri.advisory.pesticide.controllers.PesticideApi;
import com.ninjacart.agri.advisory.pesticide.models.Pesticide;
import com.ninjacart.agri.advisory.pesticide.service.PesticideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class PesticideController implements PesticideApi {

    private final PesticideService pesticideService;

    /**
     * Autowires the PesticideService to handle the business logic.
     *
     * @param pesticideService The service responsible for pesticide operations
     */
    @Autowired
    public PesticideController(PesticideService pesticideService) {
        this.pesticideService = pesticideService;
    }

    /**
     * POST /api/v1/{toolID}/realm/{realmId}/user/{userId}/pesticides : Add a new pesticide
     *
     * @param realmId   (required)
     * @param userId    (required)
     * @param toolID    (required)
     * @param pesticide (required)
     * @return Pesticide Added (status code 200)
     */
    @Override
    public ResponseEntity<Pesticide> addPesticide(String realmId, Integer userId, String toolID, Pesticide pesticide) {
        Pesticide savedPesticide = pesticideService.savePesticide(pesticide, userId, toolID);
        return ResponseEntity.ok(savedPesticide);
    }

    /**
     * DELETE /api/v1/{toolID}/realm/{realmId}/user/{userId}/pesticides/{id} : Delete a specific pesticide by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Deleted Successfully (status code 204)
     */
    @Override
    public ResponseEntity<Void> deletePesticideById(String realmId, Integer userId, String toolID, Integer id) {
        pesticideService.deletePesticide(id);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/pesticides/{id} : Get a specific pesticide by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Successful response (status code 200)
     */
    @Override
    public ResponseEntity<Pesticide> getPesticideById(String realmId, Integer userId, String toolID, Integer id) {
        Pesticide pesticide =
                pesticideService
                        .getPesticideById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Pesticide not found for this id :: " + id));
        return ResponseEntity.ok(pesticide);
    }

    /**
     * PUT /api/v1/{toolID}/realm/{realmId}/user/{userId}/pesticides/{id} : Update a specific pesticide by ID
     *
     * @param realmId    (required)
     * @param userId     (required)
     * @param toolID     (required)
     * @param id         (required)
     * @param pesticide (required)
     * @return Successful update (status code 200)
     */
    @Override
    public ResponseEntity<Pesticide> updatePesticideById(String realmId, Integer userId, String toolID, Integer id, Pesticide pesticide) {
        Pesticide updatedPesticide = pesticideService.updatePesticide(id, pesticide, userId, toolID);
        return ResponseEntity.ok(updatedPesticide);
    }
}
