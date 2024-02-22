package com.ninjacart.agri.advisory.crop.context;

import org.jooq.Field;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.ninjacart.agri.advisory.crop.generated.Tables.CROP;
import static java.util.Map.entry;

@Component
public class CropTableContext implements TableContext {

    private final Map<String, Field> filters = Map.ofEntries(
            entry("name", CROP.NAME),
            entry("income", CROP.INCOME),entry("id", CROP.ID),
            entry("createdBy", CROP.CREATED_BY),
            entry("createdAt", CROP.CREATED_AT),
            entry("updatedBy", CROP.UPDATED_BY),
            entry("updatedAt", CROP.UPDATED_AT),
            entry("createdByToolId", CROP.CREATED_BY_TOOL_ID),
            entry("updatedByToolId", CROP.UPDATED_BY_TOOL_ID),
            entry("urlStr", CROP.URL_STR),
            entry("hindiName", CROP.HINDI_NAME),
            entry("alternateName", CROP.ALTERNATE_NAME),
            entry("description", CROP.DESCRIPTION),
            entry("season", CROP.SEASON),
            entry("sowingStartTime", CROP.SOWING_START_TIME),
            entry("sowingEndTime", CROP.SOWING_END_TIME),
            entry("reapingStartTime", CROP.REAPING_START_TIME),
            entry("reapingEndTime", CROP.REAPING_END_TIME),
            entry("diseases", CROP.DISEASES),
            entry("farmingRegions", CROP.FARMING_REGIONS),
            entry("fertilizers", CROP.FERTILIZERS),
            entry("inputCost", CROP.INPUT_COST),
            entry("irrigationMethods", CROP.IRRIGATION_METHODS),
            entry("machinesRequired", CROP.MACHINES_REQUIRED),
            entry("marketDemand", CROP.MARKET_DEMAND),
            entry("revenue", CROP.REVENUE),
            entry("seedProcurement", CROP.SEED_PROCUREMENT),
            entry("seedQuantity", CROP.SEED_QUANTITY),
            entry("seedTypes", CROP.SEED_TYPES),
            entry("soilPreparation", CROP.SOIL_PREPARATION),
            entry("sowingMethod", CROP.SOWING_METHOD),
            entry("weedManagement", CROP.WEED_MANAGEMENT),
            entry("nutritionalDetails", CROP.NUTRITIONAL_DETAILS),
            entry("cropImage", CROP.CROP_IMAGE),
            entry("cropIconImage", CROP.CROP_ICON_IMAGE),
            entry("cropTypeId", CROP.CROP_TYPE_ID),
            entry("hashId", CROP.HASH_ID),
            entry("sowingReapingTime", CROP.SOWING_REAPING_TIME),
            entry("segmentId", CROP.SEGMENT_ID),
            entry("versionId", CROP.VERSION_ID),
            entry("externalHashId", CROP.EXTERNAL_HASH_ID)


    );

    private final List<Field> allFields = List.of(
            CROP.ID, CROP.CREATED_BY, CROP.CREATED_AT, CROP.UPDATED_BY, CROP.UPDATED_AT,
            CROP.CREATED_BY_TOOL_ID, CROP.UPDATED_BY_TOOL_ID, CROP.NAME, CROP.URL_STR, CROP.HINDI_NAME,
            CROP.ALTERNATE_NAME, CROP.DESCRIPTION, CROP.SEASON, CROP.SOWING_START_TIME,
            CROP.SOWING_END_TIME, CROP.REAPING_START_TIME, CROP.REAPING_END_TIME, CROP.DISEASES,
            CROP.FARMING_REGIONS, CROP.FERTILIZERS, CROP.INCOME, CROP.INPUT_COST,
            CROP.IRRIGATION_METHODS, CROP.MACHINES_REQUIRED, CROP.MARKET_DEMAND, CROP.REVENUE,
            CROP.SEED_PROCUREMENT, CROP.SEED_QUANTITY, CROP.SEED_TYPES, CROP.SOIL_PREPARATION,
            CROP.SOWING_METHOD, CROP.WEED_MANAGEMENT, CROP.NUTRITIONAL_DETAILS, CROP.CROP_IMAGE,
            CROP.CROP_ICON_IMAGE, CROP.CROP_TYPE_ID, CROP.HASH_ID, CROP.SOWING_REAPING_TIME,
            CROP.SEGMENT_ID, CROP.VERSION_ID, CROP.EXTERNAL_HASH_ID

    );

    @Override
    public Map<String, Field> getFilters() {
        return filters;
    }

    @Override
    public List<Field> getAllFields() {
        return allFields;
    }
}
