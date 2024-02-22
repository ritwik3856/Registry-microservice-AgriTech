//package com.ninjacart.agri.advisory.crop.listener;
//
//
//import com.ninjacart.agri.advisory.crop.event.CropCreatedEvent;
//import com.ninjacart.agri.advisory.crop.model.Crop;
//import com.ninjacart.agri.advisory.crop.service.ElasticsearchService;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//
//@Component
//public class CropSavedEventListener {
//
//    private final ElasticsearchService elasticsearchService;
//
//    public CropSavedEventListener(ElasticsearchService elasticsearchService){
//        this.elasticsearchService=elasticsearchService;
//    }
//
//    @EventListener
//    @Transactional
//    public void handleProductSavedEvent(CropCreatedEvent event) throws IOException {
//        Crop savedProduct = event.getCreatedCrop();
//        elasticsearchService.updateIndex(savedProduct);
//
//    }
//}
