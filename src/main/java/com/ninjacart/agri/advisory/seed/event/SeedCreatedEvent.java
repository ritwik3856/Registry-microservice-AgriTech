package com.ninjacart.agri.advisory.seed.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SeedCreatedEvent extends ApplicationEvent {
    private final Integer seedId;

    /**
     * Constructs a new SeedCreatedEvent.
     *
     * @param source The object on which the event initially occurred or with
     *               which the event is associated.
     * @param seedId The ID of the seed that was created.
     */
    public SeedCreatedEvent(Object source, Integer seedId) {
        super(source);
        this.seedId = seedId;
    }
}
