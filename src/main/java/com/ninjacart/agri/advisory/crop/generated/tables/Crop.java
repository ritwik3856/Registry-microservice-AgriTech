/*
 * This file is generated by jOOQ.
 */
package com.ninjacart.agri.advisory.crop.generated.tables;


import com.ninjacart.agri.advisory.crop.generated.Indexes;
import com.ninjacart.agri.advisory.crop.generated.Keys;
import com.ninjacart.agri.advisory.crop.generated.Public;
import com.ninjacart.agri.advisory.crop.generated.tables.records.CropRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Crop extends TableImpl<CropRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.crop</code>
     */
    public static final Crop CROP = new Crop();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CropRecord> getRecordType() {
        return CropRecord.class;
    }

    /**
     * The column <code>public.crop.id</code>.
     */
    public final TableField<CropRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.crop.alternate_name</code>.
     */
    public final TableField<CropRecord, String> ALTERNATE_NAME = createField(DSL.name("alternate_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.realm_id</code>.
     */
    public final TableField<CropRecord, String> REALM_ID = createField(DSL.name("realm_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.eppocode</code>.
     */
    public final TableField<CropRecord, Integer> EPPOCODE = createField(DSL.name("eppocode"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.crop.unspsc</code>.
     */
    public final TableField<CropRecord, Integer> UNSPSC = createField(DSL.name("unspsc"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.crop.created_at</code>.
     */
    public final TableField<CropRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.crop.created_by</code>.
     */
    public final TableField<CropRecord, Integer> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.crop.created_by_tool_id</code>.
     */
    public final TableField<CropRecord, String> CREATED_BY_TOOL_ID = createField(DSL.name("created_by_tool_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.crop_icon_image</code>.
     */
    public final TableField<CropRecord, String> CROP_ICON_IMAGE = createField(DSL.name("crop_icon_image"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.crop_image</code>.
     */
    public final TableField<CropRecord, String> CROP_IMAGE = createField(DSL.name("crop_image"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.crop_type_id</code>.
     */
    public final TableField<CropRecord, Integer> CROP_TYPE_ID = createField(DSL.name("crop_type_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.crop.description</code>.
     */
    public final TableField<CropRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.diseases</code>.
     */
    public final TableField<CropRecord, String> DISEASES = createField(DSL.name("diseases"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.external_hash_id</code>.
     */
    public final TableField<CropRecord, String> EXTERNAL_HASH_ID = createField(DSL.name("external_hash_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.farming_regions</code>.
     */
    public final TableField<CropRecord, String> FARMING_REGIONS = createField(DSL.name("farming_regions"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.fertilizers</code>.
     */
    public final TableField<CropRecord, String> FERTILIZERS = createField(DSL.name("fertilizers"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.hash_id</code>.
     */
    public final TableField<CropRecord, String> HASH_ID = createField(DSL.name("hash_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.hindi_name</code>.
     */
    public final TableField<CropRecord, String> HINDI_NAME = createField(DSL.name("hindi_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.income</code>.
     */
    public final TableField<CropRecord, String> INCOME = createField(DSL.name("income"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.input_cost</code>.
     */
    public final TableField<CropRecord, String> INPUT_COST = createField(DSL.name("input_cost"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.irrigation_methods</code>.
     */
    public final TableField<CropRecord, String> IRRIGATION_METHODS = createField(DSL.name("irrigation_methods"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.machines_required</code>.
     */
    public final TableField<CropRecord, String> MACHINES_REQUIRED = createField(DSL.name("machines_required"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.market_demand</code>.
     */
    public final TableField<CropRecord, String> MARKET_DEMAND = createField(DSL.name("market_demand"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.name</code>.
     */
    public final TableField<CropRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.nutritional_details</code>.
     */
    public final TableField<CropRecord, String> NUTRITIONAL_DETAILS = createField(DSL.name("nutritional_details"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.reaping_end_time</code>.
     */
    public final TableField<CropRecord, Short> REAPING_END_TIME = createField(DSL.name("reaping_end_time"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.crop.reaping_start_time</code>.
     */
    public final TableField<CropRecord, Short> REAPING_START_TIME = createField(DSL.name("reaping_start_time"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.crop.revenue</code>.
     */
    public final TableField<CropRecord, String> REVENUE = createField(DSL.name("revenue"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.season</code>.
     */
    public final TableField<CropRecord, Short> SEASON = createField(DSL.name("season"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.crop.seed_procurement</code>.
     */
    public final TableField<CropRecord, String> SEED_PROCUREMENT = createField(DSL.name("seed_procurement"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.seed_quantity</code>.
     */
    public final TableField<CropRecord, String> SEED_QUANTITY = createField(DSL.name("seed_quantity"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.seed_types</code>.
     */
    public final TableField<CropRecord, String> SEED_TYPES = createField(DSL.name("seed_types"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.segment_id</code>.
     */
    public final TableField<CropRecord, Integer> SEGMENT_ID = createField(DSL.name("segment_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.crop.soil_preparation</code>.
     */
    public final TableField<CropRecord, String> SOIL_PREPARATION = createField(DSL.name("soil_preparation"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.sowing_end_time</code>.
     */
    public final TableField<CropRecord, Short> SOWING_END_TIME = createField(DSL.name("sowing_end_time"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.crop.sowing_method</code>.
     */
    public final TableField<CropRecord, String> SOWING_METHOD = createField(DSL.name("sowing_method"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.sowing_reaping_time</code>.
     */
    public final TableField<CropRecord, String> SOWING_REAPING_TIME = createField(DSL.name("sowing_reaping_time"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.sowing_start_time</code>.
     */
    public final TableField<CropRecord, Short> SOWING_START_TIME = createField(DSL.name("sowing_start_time"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.crop.updated_at</code>.
     */
    public final TableField<CropRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.crop.updated_by</code>.
     */
    public final TableField<CropRecord, Integer> UPDATED_BY = createField(DSL.name("updated_by"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.crop.updated_by_tool_id</code>.
     */
    public final TableField<CropRecord, String> UPDATED_BY_TOOL_ID = createField(DSL.name("updated_by_tool_id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.url_str</code>.
     */
    public final TableField<CropRecord, String> URL_STR = createField(DSL.name("url_str"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.version_id</code>.
     */
    public final TableField<CropRecord, Integer> VERSION_ID = createField(DSL.name("version_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.crop.weed_management</code>.
     */
    public final TableField<CropRecord, String> WEED_MANAGEMENT = createField(DSL.name("weed_management"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.crop.is_deleted</code>.
     */
    public final TableField<CropRecord, Boolean> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.BOOLEAN.defaultValue(DSL.field(DSL.raw("false"), SQLDataType.BOOLEAN)), this, "");

    private Crop(Name alias, Table<CropRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Crop(Name alias, Table<CropRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.crop</code> table reference
     */
    public Crop(String alias) {
        this(DSL.name(alias), CROP);
    }

    /**
     * Create an aliased <code>public.crop</code> table reference
     */
    public Crop(Name alias) {
        this(alias, CROP);
    }

    /**
     * Create a <code>public.crop</code> table reference
     */
    public Crop() {
        this(DSL.name("crop"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IX_CROP_ALTERNATE_NAME, Indexes.IX_CROP_CROP_TYPE_ID, Indexes.IX_CROP_HASH_ID, Indexes.IX_CROP_HINDI_NAME, Indexes.IX_CROP_IS_DELETED, Indexes.IX_CROP_NAME, Indexes.IX_CROP_REAPING_END_TIME, Indexes.IX_CROP_REAPING_START_TIME, Indexes.IX_CROP_SEASON, Indexes.IX_CROP_SOWING_END_TIME, Indexes.IX_CROP_SOWING_START_TIME, Indexes.IX_CROP_URL_STR);
    }

    @Override
    public Identity<CropRecord, Integer> getIdentity() {
        return (Identity<CropRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<CropRecord> getPrimaryKey() {
        return Keys.CROP_PKEY;
    }

    @Override
    public Crop as(String alias) {
        return new Crop(DSL.name(alias), this);
    }

    @Override
    public Crop as(Name alias) {
        return new Crop(alias, this);
    }

    @Override
    public Crop as(Table<?> alias) {
        return new Crop(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crop rename(String name) {
        return new Crop(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crop rename(Name name) {
        return new Crop(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crop rename(Table<?> name) {
        return new Crop(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Crop where(Condition condition) {
        return new Crop(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Crop where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Crop where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Crop where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Crop where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Crop where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Crop where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Crop where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Crop whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Crop whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
