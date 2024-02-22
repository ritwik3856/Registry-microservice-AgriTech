package com.ninjacart.agri.advisory.crop.event;

import com.ninjacart.agri.advisory.crop.models.Crop;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CropCreatedEvent extends ApplicationEvent {
    private final Integer cropId;
    private final Crop savedCrop;

    /**
     * Constructs a new CropCreatedEvent.
     *
     * @param source The object on which the event initially occurred or with
     *               which the event is associated.
     * @param cropId The ID of the crop that was created.
     */
    public CropCreatedEvent(Object source, Integer cropId, Crop savedCrop) {
        super(source);
        this.cropId = cropId;
        this.savedCrop=savedCrop;
    }

    public Crop getCreatedCrop(){
        return savedCrop;
    }

}
