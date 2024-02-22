package com.ninjacart.agri.advisory.crop.listener;


import com.ninjacart.agri.advisory.crop.dto.CropRecord;
import com.ninjacart.agri.advisory.crop.event.CropCreatedEvent;
import com.ninjacart.agri.advisory.crop.models.Crop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CropCreationListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(CropCreationListener.class);
    //private KafkaProducerConfigService kafkaProducerConfig;
    private final StreamBridge streamBridge;

//    public CropCreationListener(KafkaProducerConfigService kafkaProducerConfig){
//        this.kafkaProducerConfig=kafkaProducerConfig;
//    }


    public CropCreationListener(StreamBridge streamBridge){
        this.streamBridge=streamBridge;
    }
    @Transactional
    @EventListener
    public void handleUserRegistrationEvent(CropCreatedEvent event) {
        Crop newCrop=event.getCreatedCrop();
        CropRecord cropRecord=new CropRecord(newCrop.getId(),
                newCrop.getRealmId(),
                newCrop.getCreatedBy(),
                newCrop.getCreatedAt(),
                newCrop.getUpdatedBy(),
                newCrop.getUpdatedAt(),
                newCrop.getCreatedByToolId(),
                newCrop.getUpdatedByToolId(),
                newCrop.getName(),
                newCrop.getUrlStr(),
                newCrop.getHindiName(),
                newCrop.getAlternateName(),
                newCrop.getDescription(),
                newCrop.getCreatedBy(),
                newCrop.getSowingStartTime(),
                newCrop.getSowingEndTime(),
                newCrop.getReapingStartTime(),
                newCrop.getReapingEndTime(),
                newCrop.getDiseases(),
                newCrop.getFarmingRegions(),
                newCrop.getFertilizers(),
                newCrop.getIncome(),
                newCrop.getInputCost(),
                newCrop.getIrrigationMethods(),
                newCrop.getMachinesRequired(),
                newCrop.getMarketDemand(),
                newCrop.getRevenue(),
                newCrop.getSeedProcurement(),
                newCrop.getSeedQuantity(),
                newCrop.getSeedTypes(),
                newCrop.getSoilPreparation(),
                newCrop.getSowingMethod(),
                newCrop.getWeedManagement(),
                newCrop.getNutritionalDetails(),
                newCrop.getCropImage(),
                newCrop.getCropIconImage(),
                newCrop.getCropTypeId(),
                newCrop.getHashId(),
                newCrop.getSowingReapingTime(),
                newCrop.getSegmentId(),
                newCrop.getVersionId(),
                newCrop.getExternalHashId()
                );
        //kafkaProducerConfig.sendMessage(event.getCreatedCrop());
        streamBridge.send("producerBinding-out-0",MessageBuilder.withPayload(cropRecord).build());

        //LOGGER.info("Async processing completed. Thread: {}", Thread.currentThread().getName());
    }
}