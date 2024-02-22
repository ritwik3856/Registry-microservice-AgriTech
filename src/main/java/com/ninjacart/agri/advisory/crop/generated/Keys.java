/*
 * This file is generated by jOOQ.
 */
package com.ninjacart.agri.advisory.crop.generated;


import com.ninjacart.agri.advisory.crop.generated.tables.Crop;
import com.ninjacart.agri.advisory.crop.generated.tables.records.CropRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CropRecord> CROP_PKEY = Internal.createUniqueKey(Crop.CROP, DSL.name("crop_pkey"), new TableField[] { Crop.CROP.ID }, true);
}