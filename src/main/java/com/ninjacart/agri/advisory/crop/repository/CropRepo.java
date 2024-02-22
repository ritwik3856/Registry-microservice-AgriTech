package com.ninjacart.agri.advisory.crop.repository;

import com.ninjacart.agri.advisory.crop.context.TableContext;
import com.ninjacart.agri.advisory.crop.models.Crop;
import lombok.Builder;
import org.jooq.*;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import static com.ninjacart.agri.advisory.crop.generated.Tables.CROP;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.selectCount;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CropRepo {

    private final DSLContext dsl;
    private final TableContext cropTableContext;

    @Autowired
    public CropRepo(DSLContext dsl, TableContext cropTableContext) {
        this.dsl = dsl;
        this.cropTableContext = cropTableContext;
    }

    public Page<Crop> getAllCrops(Pageable pageable, Sort sort) {

        List<Crop> crops = dsl.selectFrom(CROP)
                .orderBy(buildOrderBy(sort))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch()
                .map(this::cropEntityToDto);

        int total = dsl.fetchCount(selectCount().from(CROP));

        return new PageImpl<>(crops, pageable, total);
    }

    public Page<Crop> getAllCropsWithSqlCondition(Condition condition, Pageable pageable, Sort sort) {
        List<Crop> crops =
                dsl.select(cropTableContext.getAllFields())
                        .from(CROP)
                        .where(condition)
                        .orderBy(buildOrderBy(sort))
                        .limit(pageable.getPageSize())
                        .offset(pageable.getOffset()).fetch()
                        .stream()
                        .map(this::cropEntityToDto)
                        .collect(Collectors.toList());

        int total = dsl.fetchCount(selectCount().from(CROP));

        return new PageImpl<>(crops, pageable, total);

    }

    public Page<Crop> udiSearch(Pageable pageable) {
        List<Crop> crops = dsl.selectFrom(CROP)
                .where((CROP.NAME).isNotNull()
                    .or((CROP.INCOME).isNotNull())
                    .or((CROP.INPUT_COST).isNotNull())
                    .or((CROP.DISEASES).isNotNull()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch()
                .map(this::cropEntityToDto);

        int total = dsl.fetchCount(selectCount().from(CROP));

        return new PageImpl<>(crops, pageable, total);
    }

    private SortField<?>[] buildOrderBy(Sort sort) {
        return sort.stream()
                .map(order -> {
                    Field<?> field = CROP.field(order.getProperty());
                    return order.getDirection().isAscending() ? field.asc() : field.desc();
                })
                .toArray(SortField<?>[]::new);
    }
    private Crop cropEntityToDto(Record record) {
        return Crop.builder()
                .id(record.get(CROP.ID))
                .createdBy(record.get(CROP.CREATED_BY))
                .createdAt(record.get(CROP.CREATED_AT))
                .updatedBy(record.get(CROP.UPDATED_BY))
                .updatedAt(record.get(CROP.UPDATED_AT))
                .createdByToolId(record.get(CROP.CREATED_BY_TOOL_ID))
                .updatedByToolId(record.get(CROP.UPDATED_BY_TOOL_ID))
                .name(record.get(CROP.NAME))
                .urlStr(record.get(CROP.URL_STR))
                .hindiName(record.get(CROP.HINDI_NAME))
                .alternateName(record.get(CROP.ALTERNATE_NAME))
                .description(record.get(CROP.DESCRIPTION))
                .season(record.get(CROP.SEASON))
                .sowingStartTime(record.get(CROP.SOWING_START_TIME))
                .sowingEndTime(record.get(CROP.SOWING_END_TIME))
                .reapingStartTime(record.get(CROP.REAPING_START_TIME))
                .reapingEndTime(record.get(CROP.REAPING_END_TIME))
                .diseases(record.get(CROP.DISEASES))
                .farmingRegions(record.get(CROP.FARMING_REGIONS))
                .fertilizers(record.get(CROP.FERTILIZERS))
                .income(record.get(CROP.INCOME))
                .inputCost(record.get(CROP.INPUT_COST))
                .irrigationMethods(record.get(CROP.IRRIGATION_METHODS))
                .machinesRequired(record.get(CROP.MACHINES_REQUIRED))
                .marketDemand(record.get(CROP.MARKET_DEMAND))
                .revenue(record.get(CROP.REVENUE))
                .seedProcurement(record.get(CROP.SEED_PROCUREMENT))
                .seedQuantity(record.get(CROP.SEED_QUANTITY))
                .seedTypes(record.get(CROP.SEED_TYPES))
                .soilPreparation(record.get(CROP.SOIL_PREPARATION))
                .sowingMethod(record.get(CROP.SOWING_METHOD))
                .weedManagement(record.get(CROP.WEED_MANAGEMENT))
                .nutritionalDetails(record.get(CROP.NUTRITIONAL_DETAILS))
                .cropImage(record.get(CROP.CROP_IMAGE))
                .cropIconImage(record.get(CROP.CROP_ICON_IMAGE))
                .cropTypeId(record.get(CROP.CROP_TYPE_ID))
                .hashId(record.get(CROP.HASH_ID))
                .sowingReapingTime(record.get(CROP.SOWING_REAPING_TIME))
                .segmentId(record.get(CROP.SEGMENT_ID))
                .versionId(record.get(CROP.VERSION_ID))
                .externalHashId(record.get(CROP.EXTERNAL_HASH_ID))
                .build();
        }
    }

