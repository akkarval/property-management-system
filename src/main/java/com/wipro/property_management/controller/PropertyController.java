package com.wipro.property_management.controller;

import com.wipro.property_management.dto.PropertyDTO;
import com.wipro.property_management.service.PropertyService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyservice;

    @PostMapping("/saveProperty")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyservice.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }


    @GetMapping("/getProperties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
       List<PropertyDTO> propertyList = propertyservice.getAllProperties();

       ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
       return responseEntity;
    }

    @PutMapping("/updateProperties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

        propertyDTO =  propertyservice.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("updateProperties/update-description/{propertyId}")
    public  ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyservice.updatePropertyDescription(propertyDTO, propertyId);

        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);

    }

    @PatchMapping("updateProperties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyservice.updatePropertyPrice(propertyDTO, propertyId);

        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProperties/{propertyId}")
    public ResponseEntity<PropertyDTO> deleteProperty(@PathVariable Long propertyId){

       PropertyDTO propertyDTO = propertyservice.deleteProperty(propertyId);
        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    }

}