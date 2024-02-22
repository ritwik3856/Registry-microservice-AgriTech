package com.ninjacart.agri.advisory.crop.config;


import com.ninjacart.agri.advisory.crop.models.Crop;
import org.springframework.kafka.support.serializer.JsonSerde;

public class EventSerDes extends JsonSerde<Crop> {}
