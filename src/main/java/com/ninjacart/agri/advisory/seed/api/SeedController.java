package com.ninjacart.agri.advisory.seed.api;

import com.ninjacart.agri.advisory.common.exception.EntityNotFoundException;
import com.ninjacart.agri.advisory.seed.controllers.SeedApi;
import com.ninjacart.agri.advisory.seed.models.Seed;
import com.ninjacart.agri.advisory.seed.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class SeedController implements SeedApi {

    private final SeedService seedService;

    /**
     * Autowires the SeedService to handle the business logic.
     *
     * @param seedService The service responsible for seed operations
     */
    @Autowired
    public SeedController(SeedService seedService) {
        this.seedService = seedService;
    }

    /**
     * POST /api/v1/{toolID}/realm/{realmId}/user/{userId}/seeds : Add a new seed
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param seed    (required)
     * @return Seed Added (status code 200)
     */
    @Override
    public ResponseEntity<Seed> addSeed(String realmId, Integer userId, String toolID, Seed seed) {
        Seed savedSeed = seedService.saveSeed(seed, userId, toolID);
        return ResponseEntity.ok(savedSeed);
    }

    /**
     * DELETE /api/v1/{toolID}/realm/{realmId}/user/{userId}/seeds/{id} : Delete a specific seed by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Deleted Successfully (status code 204)
     */
    @Override
    public ResponseEntity<Void> deleteSeedById(String realmId, Integer userId, String toolID, Integer id) {
        seedService.deleteSeed(id);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/seeds/{id} : Get a specific seed by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Successful response (status code 200)
     */
    @Override
    public ResponseEntity<Seed> getSeedById(String realmId, Integer userId, String toolID, Integer id) {
        Seed seed =
                seedService
                        .getSeedById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Seed not found for this id :: " + id));
        return ResponseEntity.ok(seed);
    }

    /**
     * PUT /api/v1/{toolID}/realm/{realmId}/user/{userId}/seeds/{id} : Update a specific seed by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @param seed    (required)
     * @return Successful update (status code 200)
     */
    @Override
    public ResponseEntity<Seed> updateSeedById(String realmId, Integer userId, String toolID, Integer id, Seed seed) {
        Seed updatedSeed = seedService.updateSeed(id, seed, userId, toolID);
        return ResponseEntity.ok(updatedSeed);
    }
}
