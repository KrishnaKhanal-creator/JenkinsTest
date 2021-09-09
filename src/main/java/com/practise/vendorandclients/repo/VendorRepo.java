package com.practise.vendorandclients.repo;

import com.practise.vendorandclients.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VendorRepo extends JpaRepository<Vendor,Integer> {

    Optional<Vendor> findVendorById(int id);
}
