package com.practise.vendorandclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vendor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @Column(name = "vendor_name")
    private String vendorName;
    @Column(name = "vendor_company_name")
    private String vendorCompanyName;
    @Column(name = "client_name")
    private String clientName;

    private String email;

    @Column(name = "phone_number")
    private long phoneNumber;

    private String notes;

    @Column(name="level_of_priority")
    private int levelOfPriority;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "vendor_code")
    private String vendorCode;

    public Vendor(String vendorName, String vendorCompanyName, String clientName, String email, long phoneNumber, String notes, int levelOfPriority, String imageURL,String vendorCode) {
        this.vendorName = vendorName;
        this.vendorCompanyName = vendorCompanyName;
        this.clientName = clientName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.levelOfPriority = levelOfPriority;
        this.imageURL = imageURL;
        this.vendorCode=vendorCode;
    }
}
