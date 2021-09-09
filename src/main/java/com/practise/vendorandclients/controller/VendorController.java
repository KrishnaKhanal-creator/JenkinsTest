package com.practise.vendorandclients.controller;

import com.practise.vendorandclients.model.Vendor;
import com.practise.vendorandclients.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/v1")
public class VendorController {

    public final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/msg")
    public String returnAMessage(){
        return "Hello People Welcome to the Message API";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vendor>> listAllVendor(){
        List<Vendor> allVendors = vendorService.getAllVendor();
        return new ResponseEntity(allVendors,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> listVendorById(@PathVariable("id") int id){
        Vendor vendor = vendorService.getVendorById(id);
        return new ResponseEntity<>(vendor,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vendor> addAVendor(@RequestBody Vendor vendor){
        Vendor addingVendor = vendorService.addAVendor(vendor);
        return new ResponseEntity<>(addingVendor,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor){
        Vendor updatedVendor = vendorService.updateVendor(vendor);
        return new ResponseEntity<>(updatedVendor,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVendor(@PathVariable int id){
        vendorService.deleteVendor(id);
        Map<String, Boolean> responseMap = new HashMap<>();
        responseMap.put("Successfully Deleted", Boolean.TRUE);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}
