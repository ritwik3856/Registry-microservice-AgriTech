/*
 * This file is generated by jOOQ.
 */
package com.ninjacart.agri.advisory.crop.generated;


import com.ninjacart.agri.advisory.crop.generated.tables.Crop;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index IX_CROP_ALTERNATE_NAME = Internal.createIndex(DSL.name("ix_crop_alternate_name"), Crop.CROP, new OrderField[] { Crop.CROP.ALTERNATE_NAME }, false);
    public static final Index IX_CROP_CROP_TYPE_ID = Internal.createIndex(DSL.name("ix_crop_crop_type_id"), Crop.CROP, new OrderField[] { Crop.CROP.CROP_TYPE_ID }, false);
    public static final Index IX_CROP_HASH_ID = Internal.createIndex(DSL.name("ix_crop_hash_id"), Crop.CROP, new OrderField[] { Crop.CROP.HASH_ID }, false);
    public static final Index IX_CROP_HINDI_NAME = Internal.createIndex(DSL.name("ix_crop_hindi_name"), Crop.CROP, new OrderField[] { Crop.CROP.HINDI_NAME }, false);
    public static final Index IX_CROP_IS_DELETED = Internal.createIndex(DSL.name("ix_crop_is_deleted"), Crop.CROP, new OrderField[] { Crop.CROP.IS_DELETED }, false);
    public static final Index IX_CROP_NAME = Internal.createIndex(DSL.name("ix_crop_name"), Crop.CROP, new OrderField[] { Crop.CROP.NAME }, false);
    public static final Index IX_CROP_REAPING_END_TIME = Internal.createIndex(DSL.name("ix_crop_reaping_end_time"), Crop.CROP, new OrderField[] { Crop.CROP.REAPING_END_TIME }, false);
    public static final Index IX_CROP_REAPING_START_TIME = Internal.createIndex(DSL.name("ix_crop_reaping_start_time"), Crop.CROP, new OrderField[] { Crop.CROP.REAPING_START_TIME }, false);
    public static final Index IX_CROP_SEASON = Internal.createIndex(DSL.name("ix_crop_season"), Crop.CROP, new OrderField[] { Crop.CROP.SEASON }, false);
    public static final Index IX_CROP_SOWING_END_TIME = Internal.createIndex(DSL.name("ix_crop_sowing_end_time"), Crop.CROP, new OrderField[] { Crop.CROP.SOWING_END_TIME }, false);
    public static final Index IX_CROP_SOWING_START_TIME = Internal.createIndex(DSL.name("ix_crop_sowing_start_time"), Crop.CROP, new OrderField[] { Crop.CROP.SOWING_START_TIME }, false);
    public static final Index IX_CROP_URL_STR = Internal.createIndex(DSL.name("ix_crop_url_str"), Crop.CROP, new OrderField[] { Crop.CROP.URL_STR }, false);
}
