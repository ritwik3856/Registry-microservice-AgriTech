package com.ninjacart.agri.advisory.crop.dto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;


public record CropRecord(
        Integer id,
        String realmId,
        Integer createdBy,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)

        LocalDateTime createdAt,
        Integer updatedBy,

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)

        LocalDateTime updatedAt,
        String createdByToolId,
        String updatedByToolId,
        String name,
        String urlStr,
        String hindiName,
        String alternateName,
        String description,
        Integer season,
        Short sowingStartTime,
        Short sowingEndTime,
        Short reapingStartTime,
        Short reapingEndTime,
        String diseases,
        String farmingRegions,
        String fertilizers,
        String income,
        String inputCost,
        String irrigationMethods,
        String machinesRequired,
        String marketDemand,
        String revenue,
        String seedProcurement,
        String seedQuantity,
        String seedTypes,
        String soilPreparation,
        String sowingMethod,
        String weedManagement,
        String nutritionalDetails,
        String cropImage,
        String cropIconImage,
        Integer cropTypeId,
        String hashId,
        String sowingReapingTime,
        Integer segmentId,
        Integer versionId,
        String externalHashId
){

}