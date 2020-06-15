package com.cap.Assignment1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.Assignment1.models.Address;

@Repository("AddresssDBDao")
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
