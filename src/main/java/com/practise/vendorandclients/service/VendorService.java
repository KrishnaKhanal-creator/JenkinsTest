package com.practise.vendorandclients.service;

import com.practise.vendorandclients.exception.VendorNotFoundException;
import com.practise.vendorandclients.model.Vendor;
import com.practise.vendorandclients.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendorService {


    private final VendorRepo vendorRepo;

    @Autowired
    public VendorService(VendorRepo vendorRepo) {
        this.vendorRepo = vendorRepo;
    }
    //list all
    public List<Vendor> getAllVendor(){
        return vendorRepo.findAll();
    }
    //get one
    // method does not exist so created my own method that will return Optional of vendor, if not found we have to throw an custom exception to handle that error.
    public Vendor getVendorById(int id) {
        return vendorRepo.findVendorById(id)
                .orElseThrow(
                        ()-> new VendorNotFoundException("Vendor of" + id + "does not exist"));
    }
    //add
    public Vendor addAVendor(Vendor vendor){
        vendor.setVendorCode(UUID.randomUUID().toString());
        return vendorRepo.save(vendor);
    }
    //update
    public Vendor updateVendor(Vendor vendor){
        return vendorRepo.save(vendor);
    }
    //remove
    public void deleteVendor(int id){
        Vendor vendor = (Vendor) vendorRepo.findById(id).orElseThrow(() -> new VendorNotFoundException("Employee not exist with id: " + id));
        vendorRepo.delete(vendor);
    }
}
