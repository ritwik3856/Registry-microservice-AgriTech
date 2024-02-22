package com.ninjacart.agri.advisory.pesticide.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PesticideCreatedEvent extends ApplicationEvent {
    private final Integer pesticideId;

    /**
     * Constructs a new PesticideCreatedEvent.
     *
     * @param source The object on which the event initially occurred or with
     *               which the event is associated.
     * @param pesticideId The ID of the pesticide that was created.
     */
    public PesticideCreatedEvent(Object source, Integer pesticideId) {
        super(source);
        this.pesticideId = pesticideId;
    }
}
