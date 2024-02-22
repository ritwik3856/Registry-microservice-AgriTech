package com.ninjacart.agri.advisory.pesticide.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Pesticide
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-21T18:37:48.291952+05:30[Asia/Kolkata]")
@jakarta.persistence.Entity
@jakarta.persistence.Table(
    name = "pesticide"
  )
public class Pesticide {

  @jakarta.persistence.Id
@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Integer id;

  private Integer createdBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime createdAt;

  private Integer updatedBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime updatedAt;

  private String createdByToolId;

  private String updatedByToolId;

  private String name;

  private String chemicalComposition;

  private String dosagePerAcre;

  private String applicationMethod;

  private String spectrum;

  private String effectDuration;

  private String applicationFrequency;

  private String specialRemarks;

  private String extraDescription;

  private Integer costOfSingleDosage;

  private String benefits;

  private String img1;

  private String hashId;

  private String brand;

  private String form;

  private String pesticideType;

  private Integer price;

  private String dosagePerLitre;

  private String quantity;

  private String compatibility;

  private Integer pesticideTypeId;

  private String urlStr;

  private Integer versionId;

  private Boolean isDeleted = false;

  public Pesticide() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Pesticide(String name) {
    this.name = name;
  }

  public Pesticide id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Autogenerated primary key
   * @return id
  */
  
  @Schema(name = "id", description = "Autogenerated primary key", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Pesticide createdBy(Integer createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Get createdBy
   * @return createdBy
  */
  
  @Schema(name = "createdBy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdBy")
  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public Pesticide createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Pesticide updatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  /**
   * Get updatedBy
   * @return updatedBy
  */
  
  @Schema(name = "updatedBy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedBy")
  public Integer getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Pesticide updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
  */
  @Valid 
  @Schema(name = "updatedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Pesticide createdByToolId(String createdByToolId) {
    this.createdByToolId = createdByToolId;
    return this;
  }

  /**
   * Get createdByToolId
   * @return createdByToolId
  */
  
  @Schema(name = "createdByToolId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdByToolId")
  public String getCreatedByToolId() {
    return createdByToolId;
  }

  public void setCreatedByToolId(String createdByToolId) {
    this.createdByToolId = createdByToolId;
  }

  public Pesticide updatedByToolId(String updatedByToolId) {
    this.updatedByToolId = updatedByToolId;
    return this;
  }

  /**
   * Get updatedByToolId
   * @return updatedByToolId
  */
  
  @Schema(name = "updatedByToolId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedByToolId")
  public String getUpdatedByToolId() {
    return updatedByToolId;
  }

  public void setUpdatedByToolId(String updatedByToolId) {
    this.updatedByToolId = updatedByToolId;
  }

  public Pesticide name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Pesticide chemicalComposition(String chemicalComposition) {
    this.chemicalComposition = chemicalComposition;
    return this;
  }

  /**
   * Get chemicalComposition
   * @return chemicalComposition
  */
  
  @Schema(name = "chemicalComposition", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("chemicalComposition")
  public String getChemicalComposition() {
    return chemicalComposition;
  }

  public void setChemicalComposition(String chemicalComposition) {
    this.chemicalComposition = chemicalComposition;
  }

  public Pesticide dosagePerAcre(String dosagePerAcre) {
    this.dosagePerAcre = dosagePerAcre;
    return this;
  }

  /**
   * Get dosagePerAcre
   * @return dosagePerAcre
  */
  
  @Schema(name = "dosagePerAcre", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dosagePerAcre")
  public String getDosagePerAcre() {
    return dosagePerAcre;
  }

  public void setDosagePerAcre(String dosagePerAcre) {
    this.dosagePerAcre = dosagePerAcre;
  }

  public Pesticide applicationMethod(String applicationMethod) {
    this.applicationMethod = applicationMethod;
    return this;
  }

  /**
   * Get applicationMethod
   * @return applicationMethod
  */
  
  @Schema(name = "applicationMethod", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("applicationMethod")
  public String getApplicationMethod() {
    return applicationMethod;
  }

  public void setApplicationMethod(String applicationMethod) {
    this.applicationMethod = applicationMethod;
  }

  public Pesticide spectrum(String spectrum) {
    this.spectrum = spectrum;
    return this;
  }

  /**
   * Get spectrum
   * @return spectrum
  */
  
  @Schema(name = "spectrum", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("spectrum")
  public String getSpectrum() {
    return spectrum;
  }

  public void setSpectrum(String spectrum) {
    this.spectrum = spectrum;
  }

  public Pesticide effectDuration(String effectDuration) {
    this.effectDuration = effectDuration;
    return this;
  }

  /**
   * Get effectDuration
   * @return effectDuration
  */
  
  @Schema(name = "effectDuration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("effectDuration")
  public String getEffectDuration() {
    return effectDuration;
  }

  public void setEffectDuration(String effectDuration) {
    this.effectDuration = effectDuration;
  }

  public Pesticide applicationFrequency(String applicationFrequency) {
    this.applicationFrequency = applicationFrequency;
    return this;
  }

  /**
   * Get applicationFrequency
   * @return applicationFrequency
  */
  
  @Schema(name = "applicationFrequency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("applicationFrequency")
  public String getApplicationFrequency() {
    return applicationFrequency;
  }

  public void setApplicationFrequency(String applicationFrequency) {
    this.applicationFrequency = applicationFrequency;
  }

  public Pesticide specialRemarks(String specialRemarks) {
    this.specialRemarks = specialRemarks;
    return this;
  }

  /**
   * Get specialRemarks
   * @return specialRemarks
  */
  
  @Schema(name = "specialRemarks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("specialRemarks")
  public String getSpecialRemarks() {
    return specialRemarks;
  }

  public void setSpecialRemarks(String specialRemarks) {
    this.specialRemarks = specialRemarks;
  }

  public Pesticide extraDescription(String extraDescription) {
    this.extraDescription = extraDescription;
    return this;
  }

  /**
   * Get extraDescription
   * @return extraDescription
  */
  
  @Schema(name = "extraDescription", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("extraDescription")
  public String getExtraDescription() {
    return extraDescription;
  }

  public void setExtraDescription(String extraDescription) {
    this.extraDescription = extraDescription;
  }

  public Pesticide costOfSingleDosage(Integer costOfSingleDosage) {
    this.costOfSingleDosage = costOfSingleDosage;
    return this;
  }

  /**
   * Get costOfSingleDosage
   * @return costOfSingleDosage
  */
  
  @Schema(name = "costOfSingleDosage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("costOfSingleDosage")
  public Integer getCostOfSingleDosage() {
    return costOfSingleDosage;
  }

  public void setCostOfSingleDosage(Integer costOfSingleDosage) {
    this.costOfSingleDosage = costOfSingleDosage;
  }

  public Pesticide benefits(String benefits) {
    this.benefits = benefits;
    return this;
  }

  /**
   * Get benefits
   * @return benefits
  */
  
  @Schema(name = "benefits", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("benefits")
  public String getBenefits() {
    return benefits;
  }

  public void setBenefits(String benefits) {
    this.benefits = benefits;
  }

  public Pesticide img1(String img1) {
    this.img1 = img1;
    return this;
  }

  /**
   * Get img1
   * @return img1
  */
  
  @Schema(name = "img1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("img1")
  public String getImg1() {
    return img1;
  }

  public void setImg1(String img1) {
    this.img1 = img1;
  }

  public Pesticide hashId(String hashId) {
    this.hashId = hashId;
    return this;
  }

  /**
   * Get hashId
   * @return hashId
  */
  
  @Schema(name = "hashId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hashId")
  public String getHashId() {
    return hashId;
  }

  public void setHashId(String hashId) {
    this.hashId = hashId;
  }

  public Pesticide brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
  */
  
  @Schema(name = "brand", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("brand")
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Pesticide form(String form) {
    this.form = form;
    return this;
  }

  /**
   * Get form
   * @return form
  */
  
  @Schema(name = "form", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("form")
  public String getForm() {
    return form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  public Pesticide pesticideType(String pesticideType) {
    this.pesticideType = pesticideType;
    return this;
  }

  /**
   * Get pesticideType
   * @return pesticideType
  */
  
  @Schema(name = "pesticideType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pesticideType")
  public String getPesticideType() {
    return pesticideType;
  }

  public void setPesticideType(String pesticideType) {
    this.pesticideType = pesticideType;
  }

  public Pesticide price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Pesticide dosagePerLitre(String dosagePerLitre) {
    this.dosagePerLitre = dosagePerLitre;
    return this;
  }

  /**
   * Get dosagePerLitre
   * @return dosagePerLitre
  */
  
  @Schema(name = "dosagePerLitre", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dosagePerLitre")
  public String getDosagePerLitre() {
    return dosagePerLitre;
  }

  public void setDosagePerLitre(String dosagePerLitre) {
    this.dosagePerLitre = dosagePerLitre;
  }

  public Pesticide quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public Pesticide compatibility(String compatibility) {
    this.compatibility = compatibility;
    return this;
  }

  /**
   * Get compatibility
   * @return compatibility
  */
  
  @Schema(name = "compatibility", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("compatibility")
  public String getCompatibility() {
    return compatibility;
  }

  public void setCompatibility(String compatibility) {
    this.compatibility = compatibility;
  }

  public Pesticide pesticideTypeId(Integer pesticideTypeId) {
    this.pesticideTypeId = pesticideTypeId;
    return this;
  }

  /**
   * Get pesticideTypeId
   * @return pesticideTypeId
  */
  
  @Schema(name = "pesticideTypeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pesticideTypeId")
  public Integer getPesticideTypeId() {
    return pesticideTypeId;
  }

  public void setPesticideTypeId(Integer pesticideTypeId) {
    this.pesticideTypeId = pesticideTypeId;
  }

  public Pesticide urlStr(String urlStr) {
    this.urlStr = urlStr;
    return this;
  }

  /**
   * Get urlStr
   * @return urlStr
  */
  
  @Schema(name = "urlStr", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("urlStr")
  public String getUrlStr() {
    return urlStr;
  }

  public void setUrlStr(String urlStr) {
    this.urlStr = urlStr;
  }

  public Pesticide versionId(Integer versionId) {
    this.versionId = versionId;
    return this;
  }

  /**
   * Get versionId
   * @return versionId
  */
  
  @Schema(name = "versionId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("versionId")
  public Integer getVersionId() {
    return versionId;
  }

  public void setVersionId(Integer versionId) {
    this.versionId = versionId;
  }

  public Pesticide isDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

  /**
   * Get isDeleted
   * @return isDeleted
  */
  
  @Schema(name = "is_deleted", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("is_deleted")
  public Boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pesticide pesticide = (Pesticide) o;
    return Objects.equals(this.id, pesticide.id) &&
        Objects.equals(this.createdBy, pesticide.createdBy) &&
        Objects.equals(this.createdAt, pesticide.createdAt) &&
        Objects.equals(this.updatedBy, pesticide.updatedBy) &&
        Objects.equals(this.updatedAt, pesticide.updatedAt) &&
        Objects.equals(this.createdByToolId, pesticide.createdByToolId) &&
        Objects.equals(this.updatedByToolId, pesticide.updatedByToolId) &&
        Objects.equals(this.name, pesticide.name) &&
        Objects.equals(this.chemicalComposition, pesticide.chemicalComposition) &&
        Objects.equals(this.dosagePerAcre, pesticide.dosagePerAcre) &&
        Objects.equals(this.applicationMethod, pesticide.applicationMethod) &&
        Objects.equals(this.spectrum, pesticide.spectrum) &&
        Objects.equals(this.effectDuration, pesticide.effectDuration) &&
        Objects.equals(this.applicationFrequency, pesticide.applicationFrequency) &&
        Objects.equals(this.specialRemarks, pesticide.specialRemarks) &&
        Objects.equals(this.extraDescription, pesticide.extraDescription) &&
        Objects.equals(this.costOfSingleDosage, pesticide.costOfSingleDosage) &&
        Objects.equals(this.benefits, pesticide.benefits) &&
        Objects.equals(this.img1, pesticide.img1) &&
        Objects.equals(this.hashId, pesticide.hashId) &&
        Objects.equals(this.brand, pesticide.brand) &&
        Objects.equals(this.form, pesticide.form) &&
        Objects.equals(this.pesticideType, pesticide.pesticideType) &&
        Objects.equals(this.price, pesticide.price) &&
        Objects.equals(this.dosagePerLitre, pesticide.dosagePerLitre) &&
        Objects.equals(this.quantity, pesticide.quantity) &&
        Objects.equals(this.compatibility, pesticide.compatibility) &&
        Objects.equals(this.pesticideTypeId, pesticide.pesticideTypeId) &&
        Objects.equals(this.urlStr, pesticide.urlStr) &&
        Objects.equals(this.versionId, pesticide.versionId) &&
        Objects.equals(this.isDeleted, pesticide.isDeleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdBy, createdAt, updatedBy, updatedAt, createdByToolId, updatedByToolId, name, chemicalComposition, dosagePerAcre, applicationMethod, spectrum, effectDuration, applicationFrequency, specialRemarks, extraDescription, costOfSingleDosage, benefits, img1, hashId, brand, form, pesticideType, price, dosagePerLitre, quantity, compatibility, pesticideTypeId, urlStr, versionId, isDeleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pesticide {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    createdByToolId: ").append(toIndentedString(createdByToolId)).append("\n");
    sb.append("    updatedByToolId: ").append(toIndentedString(updatedByToolId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    chemicalComposition: ").append(toIndentedString(chemicalComposition)).append("\n");
    sb.append("    dosagePerAcre: ").append(toIndentedString(dosagePerAcre)).append("\n");
    sb.append("    applicationMethod: ").append(toIndentedString(applicationMethod)).append("\n");
    sb.append("    spectrum: ").append(toIndentedString(spectrum)).append("\n");
    sb.append("    effectDuration: ").append(toIndentedString(effectDuration)).append("\n");
    sb.append("    applicationFrequency: ").append(toIndentedString(applicationFrequency)).append("\n");
    sb.append("    specialRemarks: ").append(toIndentedString(specialRemarks)).append("\n");
    sb.append("    extraDescription: ").append(toIndentedString(extraDescription)).append("\n");
    sb.append("    costOfSingleDosage: ").append(toIndentedString(costOfSingleDosage)).append("\n");
    sb.append("    benefits: ").append(toIndentedString(benefits)).append("\n");
    sb.append("    img1: ").append(toIndentedString(img1)).append("\n");
    sb.append("    hashId: ").append(toIndentedString(hashId)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    form: ").append(toIndentedString(form)).append("\n");
    sb.append("    pesticideType: ").append(toIndentedString(pesticideType)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    dosagePerLitre: ").append(toIndentedString(dosagePerLitre)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    compatibility: ").append(toIndentedString(compatibility)).append("\n");
    sb.append("    pesticideTypeId: ").append(toIndentedString(pesticideTypeId)).append("\n");
    sb.append("    urlStr: ").append(toIndentedString(urlStr)).append("\n");
    sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
