package com.ninjacart.agri.advisory.refdata.api;

import com.ninjacart.agri.advisory.refdata.controllers.AgristackcropApi;
import com.ninjacart.agri.advisory.refdata.models.AgriStackCrop;
import com.ninjacart.agri.advisory.refdata.service.AgriStackCropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@Component
public class AgriStackCropController implements AgristackcropApi {
    private final AgriStackCropService agriStackCropService;

    @Autowired
    public AgriStackCropController(AgriStackCropService agriStackCropService){
        this.agriStackCropService = agriStackCropService;
    }


    /**
     * POST /api/v1/{toolID}/realm/{realmId}/user/{userId}/argristackcrop : Add new argristackcrop
     *
     * @param realmId       (required)
     * @param userId        (required)
     * @param toolID        (required)
     * @param agriStackCrop (required)
     * @return AgriStackCrop Added (status code 200)
     */
    @Override
    public ResponseEntity<AgriStackCrop> addAgriStackCrop(String realmId, Integer userId, String toolID, AgriStackCrop agriStackCrop) {
        AgriStackCrop savedAgriStackCrop = agriStackCropService.saveAgriStackCrop(agriStackCrop, userId, toolID, realmId);
        return ResponseEntity.ok(savedAgriStackCrop);
    }

    /**
     * DELETE /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id} : Delete a specific agristackcrop by cropcode
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Deleted Successfully (status code 204)
     */
    @Override
    public ResponseEntity<Void> deleteAgriStackCropById(String realmId, Integer userId, String toolID, Integer id) {
        agriStackCropService.deleteAgriStackCrop(id);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id} : Get a specific agristackcrop by ID
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id      (required)
     * @return Successful response (status code 200)
     */
    @Override
    public ResponseEntity<AgriStackCrop> getAgriStackCropById(String realmId, Integer userId, String toolID, Integer id) {
        return agriStackCropService.getAgriStackCropById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/argristackcrop : Get filtered agristackcrop
     *
     * @param realmId (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param filter  RSQL filter expression (optional)
     * @param page    Page number (optional, default to 0)
     * @param size    Number of items per page (optional, default to 5)
     * @param sort    (optional, default to name,asc)
     * @return Successful response (status code 200)
     */
    @Override
    public ResponseEntity<List<AgriStackCrop>> getFilterAgriStackCrop(String realmId, Integer userId, String toolID, String filter, Integer page, Integer size, String sort) {
        return AgristackcropApi.super.getFilterAgriStackCrop(realmId, userId, toolID, filter, page, size, sort);
    }

    /**
     * PUT /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id} : Update a specific AgriStackCrop by ID
     *
     * @param realmId       (required)
     * @param userId        (required)
     * @param toolID        (required)
     * @param id            (required)
     * @param agriStackCrop (required)
     * @return Successful update (status code 200)
     */
    @Override
    public ResponseEntity<AgriStackCrop> updateAgriStackCrop(String realmId, Integer userId, String toolID, Integer id, AgriStackCrop agriStackCrop) {
        AgriStackCrop updatedAgriStackCrop =
                agriStackCropService.updateAgriStackCrop(id, agriStackCrop, userId, toolID, realmId);
        return ResponseEntity.ok(updatedAgriStackCrop);
    }
}
