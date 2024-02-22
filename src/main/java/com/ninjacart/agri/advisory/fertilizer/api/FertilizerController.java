package com.ninjacart.agri.advisory.fertilizer.api;

import com.ninjacart.agri.advisory.common.exception.EntityNotFoundException;
import com.ninjacart.agri.advisory.fertilizer.controllers.FertilizerApi;
import com.ninjacart.agri.advisory.fertilizer.models.Fertilizer;
import com.ninjacart.agri.advisory.fertilizer.service.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class FertilizerController implements FertilizerApi {

    private final FertilizerService fertilizerService;


    /**
     * Autowires the FertilizerService to handle the business logic.
     *
     * @param fertilizerService The service responsible for fertilizer operations
     */
    @Autowired
    public FertilizerController(FertilizerService fertilizerService) {
        this.fertilizerService = fertilizerService;
    }
    /**
     * POST /api/v1/{toolID}/realm/{realmId}/user/{userId}/fertilizers : Add a new fertilizer
     *
     * @param realmId    (required)
     * @param userId     (required)
     * @param toolID     (required)
     * @param fertilizer (required)
     * @return Fertilizer Added (status code 200)
     */
    @Override
    public ResponseEntity<Fertilizer> addFertilizer(String realmId, Integer userId, String toolID, Fertilizer fertilizer) {
        Fertilizer savedFertilizer = fertilizerService.saveFertilizer(fertilizer, userId, toolID);
        return ResponseEntity.ok(savedFertilizer);
    }

    /**
     * DELETE /api/v1/{toolID}/realm/{realmId}/user/{userId}/fertilizers/{id} : Delete a specific fertilizer by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Deleted Successfully (status code 204)
     */
    @Override
    public ResponseEntity<Void> deleteFertilizerById(String realmId, Integer userId, String toolID, Integer id) {
        fertilizerService.deleteFertilizer(id);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/fertilizers/{id} : Get a specific fertilizer by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Successful response (status code 200)
     */
    @Override
    public ResponseEntity<Fertilizer> getFertilizerById(String realmId, Integer userId, String toolID, Integer id) {
        Fertilizer fertilizer =
                fertilizerService
                        .getFertilizerById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Fertilizer not found for this id :: " + id));
        return ResponseEntity.ok(fertilizer);
    }

    /**
     * PUT /api/v1/{toolID}/realm/{realmId}/user/{userId}/fertilizers/{id} : Update a specific fertilizer by ID
     *
     * @param realmId    (required)
     * @param userId     (required)
     * @param toolID     (required)
     * @param id         (required)
     * @param fertilizer (required)
     * @return Successful update (status code 200)
     */
    @Override
    public ResponseEntity<Fertilizer> updateFertilizerById(String realmId, Integer userId, String toolID, Integer id, Fertilizer fertilizer) {
        Fertilizer updatedFertilizer = fertilizerService.updateFertilizer(id, fertilizer, userId, toolID);
        return ResponseEntity.ok(updatedFertilizer);
    }
}
