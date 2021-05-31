package com.example.bct.EcommerceByArpit.services;

import com.example.bct.EcommerceByArpit.entity.ShippingInfo;
import com.example.bct.EcommerceByArpit.repository.CustomerRepository;
import com.example.bct.EcommerceByArpit.repository.ShippingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ShippingInfoService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShippingInfoRepository shippingInfoRepository;

//As  primary key should be unique thats why whenever we recive shipping info from the client with same customerId , it updates the previous address kept in db.
    public ShippingInfo addShipping(Long customerId,ShippingInfo shippingInfo) {
        System.out.println(shippingInfo);
            ShippingInfo shippingInfo1 = new ShippingInfo();
            shippingInfo1.setId(customerId);
            shippingInfo1.setCity(shippingInfo.getCity());
            shippingInfo1.setCustomer_address(shippingInfo.getCustomer_address());
            shippingInfo1.setState(shippingInfo.getState());
            shippingInfo1.setPhone_number(shippingInfo.getPhone_number());

            return shippingInfoRepository.save(shippingInfo1);
    }

    public ShippingInfo getShipping(Long customerId){
        if(!shippingInfoRepository.findById(customerId).isPresent()){
            return new ShippingInfo();
        }
//        System.out.println(shippingInfoRepository.findById(customerId).get()+"iugubibbi");
        return shippingInfoRepository.findById(customerId).get();
    }
}
