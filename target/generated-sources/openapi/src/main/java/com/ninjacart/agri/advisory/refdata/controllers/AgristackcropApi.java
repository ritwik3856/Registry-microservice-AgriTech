/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ninjacart.agri.advisory.refdata.controllers;

import com.ninjacart.agri.advisory.refdata.models.AgriStackCrop;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-21T18:37:48.349441+05:30[Asia/Kolkata]")
@Validated
@Tag(name = "agristackcrop", description = "the agristackcrop API")
public interface AgristackcropApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop : Add new agristackcrop
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param agriStackCrop  (required)
     * @return AgriStackCrop Added (status code 200)
     */
    @Operation(
        operationId = "addAgriStackCrop",
        summary = "Add new agristackcrop",
        tags = { "agristackcrop" },
        responses = {
            @ApiResponse(responseCode = "200", description = "AgriStackCrop Added", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AgriStackCrop.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<AgriStackCrop> addAgriStackCrop(
        @Parameter(name = "realmId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("realmId") String realmId,
        @Parameter(name = "userId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("userId") Integer userId,
        @Parameter(name = "toolID", description = "", required = true, in = ParameterIn.PATH) @PathVariable("toolID") String toolID,
        @Parameter(name = "AgriStackCrop", description = "", required = true) @Valid @RequestBody AgriStackCrop agriStackCrop
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"realmId\" : \"realmId\", \"updatedBy\" : 1, \"Crop Type\" : \"Crop Type\", \"Scientific name of crop\" : \"Scientific name of crop\", \"Crop name\" : \"Crop name\", \"createdByToolId\" : \"createdByToolId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"Crop Category\" : \"Crop Category\", \"is_deleted\" : false, \"Hindi Name of Crop\" : \"Hindi Name of Crop\", \"Vernacular name of crop in English by Assam\" : \"Vernacular name of crop in English by Assam\", \"createdBy\" : 6, \"id\" : 0, \"Crop Registry Entity Identifier (Crop code)\" : 5, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id} : Delete a specific agristackcrop by cropcode
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id  (required)
     * @return Deleted Successfully (status code 204)
     */
    @Operation(
        operationId = "deleteAgriStackCropById",
        summary = "Delete a specific agristackcrop by cropcode",
        tags = { "agristackcrop" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Deleted Successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id}"
    )
    
    default ResponseEntity<Void> deleteAgriStackCropById(
        @Parameter(name = "realmId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("realmId") String realmId,
        @Parameter(name = "userId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("userId") Integer userId,
        @Parameter(name = "toolID", description = "", required = true, in = ParameterIn.PATH) @PathVariable("toolID") String toolID,
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id} : Get a specific agristackcrop by ID
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id  (required)
     * @return Successful response (status code 200)
     */
    @Operation(
        operationId = "getAgriStackCropById",
        summary = "Get a specific agristackcrop by ID",
        tags = { "agristackcrop" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AgriStackCrop.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<AgriStackCrop> getAgriStackCropById(
        @Parameter(name = "realmId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("realmId") String realmId,
        @Parameter(name = "userId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("userId") Integer userId,
        @Parameter(name = "toolID", description = "", required = true, in = ParameterIn.PATH) @PathVariable("toolID") String toolID,
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"realmId\" : \"realmId\", \"updatedBy\" : 1, \"Crop Type\" : \"Crop Type\", \"Scientific name of crop\" : \"Scientific name of crop\", \"Crop name\" : \"Crop name\", \"createdByToolId\" : \"createdByToolId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"Crop Category\" : \"Crop Category\", \"is_deleted\" : false, \"Hindi Name of Crop\" : \"Hindi Name of Crop\", \"Vernacular name of crop in English by Assam\" : \"Vernacular name of crop in English by Assam\", \"createdBy\" : 6, \"id\" : 0, \"Crop Registry Entity Identifier (Crop code)\" : 5, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop : Get filtered agristackcrop
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
    @Operation(
        operationId = "getFilterAgriStackCrop",
        summary = "Get filtered agristackcrop",
        tags = { "agristackcrop" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful response", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AgriStackCrop.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<AgriStackCrop>> getFilterAgriStackCrop(
        @Parameter(name = "realmId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("realmId") String realmId,
        @Parameter(name = "userId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("userId") Integer userId,
        @Parameter(name = "toolID", description = "", required = true, in = ParameterIn.PATH) @PathVariable("toolID") String toolID,
        @Parameter(name = "filter", description = "RSQL filter expression", in = ParameterIn.QUERY) @Valid @RequestParam(value = "filter", required = false) String filter,
        @Parameter(name = "page", description = "Page number", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
        @Parameter(name = "size", description = "Number of items per page", in = ParameterIn.QUERY) @Valid @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
        @Parameter(name = "sort", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "sort", required = false, defaultValue = "name,asc") String sort
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"realmId\" : \"realmId\", \"updatedBy\" : 1, \"Crop Type\" : \"Crop Type\", \"Scientific name of crop\" : \"Scientific name of crop\", \"Crop name\" : \"Crop name\", \"createdByToolId\" : \"createdByToolId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"Crop Category\" : \"Crop Category\", \"is_deleted\" : false, \"Hindi Name of Crop\" : \"Hindi Name of Crop\", \"Vernacular name of crop in English by Assam\" : \"Vernacular name of crop in English by Assam\", \"createdBy\" : 6, \"id\" : 0, \"Crop Registry Entity Identifier (Crop code)\" : 5, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"realmId\" : \"realmId\", \"updatedBy\" : 1, \"Crop Type\" : \"Crop Type\", \"Scientific name of crop\" : \"Scientific name of crop\", \"Crop name\" : \"Crop name\", \"createdByToolId\" : \"createdByToolId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"Crop Category\" : \"Crop Category\", \"is_deleted\" : false, \"Hindi Name of Crop\" : \"Hindi Name of Crop\", \"Vernacular name of crop in English by Assam\" : \"Vernacular name of crop in English by Assam\", \"createdBy\" : 6, \"id\" : 0, \"Crop Registry Entity Identifier (Crop code)\" : 5, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id} : Update a specific AgriStackCrop by ID
     *
     * @param realmId  (required)
     * @param userId  (required)
     * @param toolID  (required)
     * @param id  (required)
     * @param agriStackCrop  (required)
     * @return Successful update (status code 200)
     */
    @Operation(
        operationId = "updateAgriStackCrop",
        summary = "Update a specific AgriStackCrop by ID",
        tags = { "agristackcrop" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful update", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AgriStackCrop.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/api/v1/{toolID}/realm/{realmId}/user/{userId}/agristackcrop/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<AgriStackCrop> updateAgriStackCrop(
        @Parameter(name = "realmId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("realmId") String realmId,
        @Parameter(name = "userId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("userId") Integer userId,
        @Parameter(name = "toolID", description = "", required = true, in = ParameterIn.PATH) @PathVariable("toolID") String toolID,
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "AgriStackCrop", description = "", required = true) @Valid @RequestBody AgriStackCrop agriStackCrop
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"realmId\" : \"realmId\", \"updatedBy\" : 1, \"Crop Type\" : \"Crop Type\", \"Scientific name of crop\" : \"Scientific name of crop\", \"Crop name\" : \"Crop name\", \"createdByToolId\" : \"createdByToolId\", \"updatedByToolId\" : \"updatedByToolId\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"Crop Category\" : \"Crop Category\", \"is_deleted\" : false, \"Hindi Name of Crop\" : \"Hindi Name of Crop\", \"Vernacular name of crop in English by Assam\" : \"Vernacular name of crop in English by Assam\", \"createdBy\" : 6, \"id\" : 0, \"Crop Registry Entity Identifier (Crop code)\" : 5, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
