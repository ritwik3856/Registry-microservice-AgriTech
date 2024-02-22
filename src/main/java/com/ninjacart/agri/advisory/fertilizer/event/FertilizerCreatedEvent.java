package com.ninjacart.agri.advisory.fertilizer.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class FertilizerCreatedEvent extends ApplicationEvent {
    private final Integer fertilizerId;

    /**
     * Constructs a new FertilizerCreatedEvent.
     *
     * @param source The object on which the event initially occurred or with
     *               which the event is associated.
     * @param fertilizerId The ID of the fertilizer that was created.
     */
    public FertilizerCreatedEvent(Object source, Integer fertilizerId) {
        super(source);
        this.fertilizerId = fertilizerId;
    }
}

