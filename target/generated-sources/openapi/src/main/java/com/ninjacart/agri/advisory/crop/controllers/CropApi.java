/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ninjacart.agri.advisory.crop.controllers;

import com.ninjacart.agri.advisory.crop.models.Crop;
import java.util.Map;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-21T18:37:47.953428+05:30[Asia/Kolkata]")
@Validated
public interface CropApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops : Add a new crop
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param crop  (required)
     * @return Crop Added (status code 200)
     */
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/crops",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Crop> addCrop(
         @PathVariable("realmId") String realmId,
         @PathVariable("userId") Integer userId,
         @PathVariable("toolID") String toolID,
         @Valid @RequestBody Crop crop
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"income\" : \"income\", \"inputCost\" : \"inputCost\", \"machinesRequired\" : \"machinesRequired\", \"description\" : \"description\", \"cropImage\" : \"cropImage\", \"hashId\" : \"hashId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"sowingMethod\" : \"sowingMethod\", \"revenue\" : \"revenue\", \"is_deleted\" : false, \"cropTypeId\" : 3, \"segmentId\" : 2, \"cropIconImage\" : \"cropIconImage\", \"season\" : 5, \"hindiName\" : \"hindiName\", \"id\" : 0, \"sowingEndTime\" : 2, \"urlStr\" : \"urlStr\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedBy\" : 1, \"realmId\" : \"realmId\", \"seedQuantity\" : \"seedQuantity\", \"fertilizers\" : \"fertilizers\", \"farmingRegions\" : \"farmingRegions\", \"seedProcurement\" : \"seedProcurement\", \"marketDemand\" : \"marketDemand\", \"diseases\" : \"diseases\", \"externalHashId\" : \"externalHashId\", \"alternateName\" : \"alternateName\", \"irrigationMethods\" : \"irrigationMethods\", \"sowingReapingTime\" : \"sowingReapingTime\", \"unspsc\" : \"{}\", \"eppocode\" : \"{}\", \"createdByToolId\" : \"createdByToolId\", \"seedTypes\" : \"seedTypes\", \"weedManagement\" : \"weedManagement\", \"sowingStartTime\" : 5, \"versionId\" : 4, \"soilPreparation\" : \"soilPreparation\", \"createdBy\" : 6, \"nutritionalDetails\" : \"nutritionalDetails\", \"reapingEndTime\" : 9, \"name\" : \"name\", \"reapingStartTime\" : 7 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id} : Delete a specific crop by ID
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id  (required)
     * @return Deleted Successfully (status code 204)
     */
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id}"
    )
    
    default ResponseEntity<Void> deleteCropById(
         @PathVariable("realmId") String realmId,
         @PathVariable("userId") Integer userId,
         @PathVariable("toolID") String toolID,
         @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/udiSearch : Retrieve UDI Search Results
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @return Successful response (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/udiSearch",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Map<String, Crop>>> findCropUdi(
         @PathVariable("realmId") String realmId,
         @PathVariable("userId") Integer userId,
         @PathVariable("toolID") String toolID
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ null, null ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id} : Get a specific crop by ID
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id  (required)
     * @return Successful response (status code 200)
     */
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Crop> getCropById(
         @PathVariable("realmId") String realmId,
         @PathVariable("userId") Integer userId,
         @PathVariable("toolID") String toolID,
         @PathVariable("id") Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"income\" : \"income\", \"inputCost\" : \"inputCost\", \"machinesRequired\" : \"machinesRequired\", \"description\" : \"description\", \"cropImage\" : \"cropImage\", \"hashId\" : \"hashId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"sowingMethod\" : \"sowingMethod\", \"revenue\" : \"revenue\", \"is_deleted\" : false, \"cropTypeId\" : 3, \"segmentId\" : 2, \"cropIconImage\" : \"cropIconImage\", \"season\" : 5, \"hindiName\" : \"hindiName\", \"id\" : 0, \"sowingEndTime\" : 2, \"urlStr\" : \"urlStr\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedBy\" : 1, \"realmId\" : \"realmId\", \"seedQuantity\" : \"seedQuantity\", \"fertilizers\" : \"fertilizers\", \"farmingRegions\" : \"farmingRegions\", \"seedProcurement\" : \"seedProcurement\", \"marketDemand\" : \"marketDemand\", \"diseases\" : \"diseases\", \"externalHashId\" : \"externalHashId\", \"alternateName\" : \"alternateName\", \"irrigationMethods\" : \"irrigationMethods\", \"sowingReapingTime\" : \"sowingReapingTime\", \"unspsc\" : \"{}\", \"eppocode\" : \"{}\", \"createdByToolId\" : \"createdByToolId\", \"seedTypes\" : \"seedTypes\", \"weedManagement\" : \"weedManagement\", \"sowingStartTime\" : 5, \"versionId\" : 4, \"soilPreparation\" : \"soilPreparation\", \"createdBy\" : 6, \"nutritionalDetails\" : \"nutritionalDetails\", \"reapingEndTime\" : 9, \"name\" : \"name\", \"reapingStartTime\" : 7 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops : Get filtered crops
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param filter RSQL filter expression (optional)
     * @param page Page number (optional, default to 0)
     * @param size Number of items per page (optional, default to 5)
     * @param sort  (optional, default to name,asc)
     * @return Successful response (status code 200)
     */
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/crops",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Crop>> getFilterCrops(
         @PathVariable("realmId") String realmId,
         @PathVariable("userId") Integer userId,
         @PathVariable("toolID") String toolID,
         @Valid @RequestParam(value = "filter", required = false) String filter,
         @Valid @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
         @Valid @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
         @Valid @RequestParam(value = "sort", required = false, defaultValue = "name,asc") String sort,
        final Pageable pageable
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"income\" : \"income\", \"inputCost\" : \"inputCost\", \"machinesRequired\" : \"machinesRequired\", \"description\" : \"description\", \"cropImage\" : \"cropImage\", \"hashId\" : \"hashId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"sowingMethod\" : \"sowingMethod\", \"revenue\" : \"revenue\", \"is_deleted\" : false, \"cropTypeId\" : 3, \"segmentId\" : 2, \"cropIconImage\" : \"cropIconImage\", \"season\" : 5, \"hindiName\" : \"hindiName\", \"id\" : 0, \"sowingEndTime\" : 2, \"urlStr\" : \"urlStr\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedBy\" : 1, \"realmId\" : \"realmId\", \"seedQuantity\" : \"seedQuantity\", \"fertilizers\" : \"fertilizers\", \"farmingRegions\" : \"farmingRegions\", \"seedProcurement\" : \"seedProcurement\", \"marketDemand\" : \"marketDemand\", \"diseases\" : \"diseases\", \"externalHashId\" : \"externalHashId\", \"alternateName\" : \"alternateName\", \"irrigationMethods\" : \"irrigationMethods\", \"sowingReapingTime\" : \"sowingReapingTime\", \"unspsc\" : \"{}\", \"eppocode\" : \"{}\", \"createdByToolId\" : \"createdByToolId\", \"seedTypes\" : \"seedTypes\", \"weedManagement\" : \"weedManagement\", \"sowingStartTime\" : 5, \"versionId\" : 4, \"soilPreparation\" : \"soilPreparation\", \"createdBy\" : 6, \"nutritionalDetails\" : \"nutritionalDetails\", \"reapingEndTime\" : 9, \"name\" : \"name\", \"reapingStartTime\" : 7 }, { \"income\" : \"income\", \"inputCost\" : \"inputCost\", \"machinesRequired\" : \"machinesRequired\", \"description\" : \"description\", \"cropImage\" : \"cropImage\", \"hashId\" : \"hashId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"sowingMethod\" : \"sowingMethod\", \"revenue\" : \"revenue\", \"is_deleted\" : false, \"cropTypeId\" : 3, \"segmentId\" : 2, \"cropIconImage\" : \"cropIconImage\", \"season\" : 5, \"hindiName\" : \"hindiName\", \"id\" : 0, \"sowingEndTime\" : 2, \"urlStr\" : \"urlStr\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedBy\" : 1, \"realmId\" : \"realmId\", \"seedQuantity\" : \"seedQuantity\", \"fertilizers\" : \"fertilizers\", \"farmingRegions\" : \"farmingRegions\", \"seedProcurement\" : \"seedProcurement\", \"marketDemand\" : \"marketDemand\", \"diseases\" : \"diseases\", \"externalHashId\" : \"externalHashId\", \"alternateName\" : \"alternateName\", \"irrigationMethods\" : \"irrigationMethods\", \"sowingReapingTime\" : \"sowingReapingTime\", \"unspsc\" : \"{}\", \"eppocode\" : \"{}\", \"createdByToolId\" : \"createdByToolId\", \"seedTypes\" : \"seedTypes\", \"weedManagement\" : \"weedManagement\", \"sowingStartTime\" : 5, \"versionId\" : 4, \"soilPreparation\" : \"soilPreparation\", \"createdBy\" : 6, \"nutritionalDetails\" : \"nutritionalDetails\", \"reapingEndTime\" : 9, \"name\" : \"name\", \"reapingStartTime\" : 7 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id} : Update a specific crop by ID
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id  (required)
     * @param crop  (required)
     * @return Successful update (status code 200)
     */
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/crops/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Crop> updateCropById(
         @PathVariable("realmId") String realmId,
         @PathVariable("userId") Integer userId,
         @PathVariable("toolID") String toolID,
         @PathVariable("id") Integer id,
         @Valid @RequestBody Crop crop
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"income\" : \"income\", \"inputCost\" : \"inputCost\", \"machinesRequired\" : \"machinesRequired\", \"description\" : \"description\", \"cropImage\" : \"cropImage\", \"hashId\" : \"hashId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"sowingMethod\" : \"sowingMethod\", \"revenue\" : \"revenue\", \"is_deleted\" : false, \"cropTypeId\" : 3, \"segmentId\" : 2, \"cropIconImage\" : \"cropIconImage\", \"season\" : 5, \"hindiName\" : \"hindiName\", \"id\" : 0, \"sowingEndTime\" : 2, \"urlStr\" : \"urlStr\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedBy\" : 1, \"realmId\" : \"realmId\", \"seedQuantity\" : \"seedQuantity\", \"fertilizers\" : \"fertilizers\", \"farmingRegions\" : \"farmingRegions\", \"seedProcurement\" : \"seedProcurement\", \"marketDemand\" : \"marketDemand\", \"diseases\" : \"diseases\", \"externalHashId\" : \"externalHashId\", \"alternateName\" : \"alternateName\", \"irrigationMethods\" : \"irrigationMethods\", \"sowingReapingTime\" : \"sowingReapingTime\", \"unspsc\" : \"{}\", \"eppocode\" : \"{}\", \"createdByToolId\" : \"createdByToolId\", \"seedTypes\" : \"seedTypes\", \"weedManagement\" : \"weedManagement\", \"sowingStartTime\" : 5, \"versionId\" : 4, \"soilPreparation\" : \"soilPreparation\", \"createdBy\" : 6, \"nutritionalDetails\" : \"nutritionalDetails\", \"reapingEndTime\" : 9, \"name\" : \"name\", \"reapingStartTime\" : 7 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
