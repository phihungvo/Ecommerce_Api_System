package com.luv2code.Ecommerce_Api_System.mapper;

import com.luv2code.Ecommerce_Api_System.dto.request.AddressCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.AddressCreationResponse;
import com.luv2code.Ecommerce_Api_System.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAddress(AddressCreationRequest request);

    AddressCreationResponse toAddressResponse(Address address);
}
