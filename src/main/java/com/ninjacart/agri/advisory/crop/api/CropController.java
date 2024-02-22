package com.ninjacart.agri.advisory.crop.api;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.ninjacart.agri.advisory.common.exception.EntityNotFoundException;
import com.ninjacart.agri.advisory.crop.context.TableContext;
import com.ninjacart.agri.advisory.crop.controllers.CropApi;
import com.ninjacart.agri.advisory.crop.models.Crop;
import com.ninjacart.agri.advisory.crop.service.CropService;
import com.ninjacart.agri.advisory.crop.service.RSQLService;
import cz.jirutka.rsql.parser.RSQLParserException;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RestController
public class CropController implements CropApi {

  private final CropService cropService;
  private final RSQLService rsqlService;
  private final TableContext cropTableContext;


  /**
   * Autowires the CropService to handle the business logic.
   *
   * @param cropService The service responsible for crop operations
   */
  @Autowired
  public CropController(
          CropService cropService, RSQLService rsqlService, TableContext cropTableContext) {
    this.cropService = cropService;
    this.rsqlService = rsqlService;
    this.cropTableContext = cropTableContext;
  }


  /**
   * POST /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops : Add a new crop
   *
   * @param realmId (required)
   * @param userId  (required)
   * @param toolID  (required)
   * @param crop    (required)
   * @return Crop Added (status code 200)
   */
  @Override
  public ResponseEntity<Crop> addCrop(String realmId, Integer userId, String toolID, Crop crop) {
    Crop savedCrop = cropService.saveCrop(crop, realmId, userId, toolID);
    return ResponseEntity.ok(savedCrop);
  }



  /**
   * DELETE /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id} : Delete a specific crop by ID
   *
   * @param realmId (required)
   * @param userId  (required)
   * @param toolID  (required)
   * @param id      (required)
   * @return Deleted Successfully (status code 204)
   */
  @Override
  public ResponseEntity<Void> deleteCropById(
      String realmId, Integer userId, String toolID, Integer id) {
    cropService.deleteCrop(id);
    return ResponseEntity.ok().build();
  }

  /**
   * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id} : Get a specific crop by ID
   *
   * @param realmId (required)
   * @param userId  (required)
   * @param toolID  (required)
   * @param id      (required)
   * @return Successful response (status code 200)
   */
  @Override
  public ResponseEntity<Crop> getCropById(
      String realmId, Integer userId, String toolID, Integer id) {
    Crop crop =
        cropService
            .getCropById(realmId , userId , toolID ,id)
            .orElseThrow(() -> new EntityNotFoundException("Crop not found for this id :: " + id));
    return ResponseEntity.ok(crop);
  }

  /**
   * PUT /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id} : Update a specific crop by ID
   *
   * @param realmId (required)
   * @param userId  (required)
   * @param toolID  (required)
   * @param id      (required)
   * @param crop    (required)
   * @return Successful update (status code 200)
   */
  @Override
  public ResponseEntity<Crop> updateCropById(
      String realmId, Integer userId, String toolID, Integer id, Crop crop) {
    Crop updatedCrop = cropService.updateCrop(id, crop, userId, toolID);
    return ResponseEntity.ok(updatedCrop);
  }

  /**
   * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops : Get filtered crops
   *
   * @param realmId  (required)
   * @param userId   (required)
   * @param toolID   (required)
   * @param filter   RSQL filter expression (required)
   * @param page     Page number (optional)
   * @param size     Number of items per page (optional)
   * @param sort     (optional)
   * @param pageable
   * @return Successful response (status code 200)
   * or Unprocessable Entity (status code 422)
   */

  @Override
  public ResponseEntity<List<Crop>> getFilterCrops(String realmId, Integer userId, String toolID, String filter, Integer page, Integer size, String sort, Pageable pageable) {
    try {
      String[] parts = sort.split(",");
      String field = parts[0];
      Sort.Direction direction = Sort.Direction.fromString(parts[1]);

      Sort sortObj = Sort.by(direction, field);
      Pageable pages = PageRequest.of(page, size, sortObj);

      List<Crop> crops;
      if (filter == null) {
        Page<Crop> cropPage = cropService.findAllCrops(realmId , userId , toolID , pages, sortObj);
        crops = cropPage.getContent();
      } else {
        Condition sqlCondition = rsqlService.getSqlCondition(filter, cropTableContext);
        Page<Crop> cropPage = cropService.getCropWithRSQLFilter(realmId , userId , toolID , sqlCondition, pages, sortObj);
        crops = cropPage.getContent();
      }
      return ResponseEntity.ok(crops);
    } catch (RSQLParserException e) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }
  }

  /**
   * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/udiSearch : Retrieve UDI Search Results
   *
   * @param realmId (required)
   * @param userId  (required)
   * @param toolID  (required)
   * @return Successful response (status code 200)
   * or Internal Server Error (status code 500)
   */
  @Override
  public ResponseEntity<List<Map<String, Crop>>> findCropUdi(String realmId, Integer userId, String toolID) {
    try {
      SearchResponse<Map> searchResponse = cropService.udiSearch();

      List<Hit<Map>> listOfHits = searchResponse.hits().hits();
      List<Map<String, Crop>> resultList = new ArrayList<>();

      for (Hit<Map> hit : listOfHits) {
        resultList.add(hit.source());
      }

      return ResponseEntity.ok(resultList);
    } catch (IOException e) {

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}

