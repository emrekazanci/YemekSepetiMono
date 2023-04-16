package com.emre.mapper;

import com.emre.dto.request.RegisterCustomerRequestDto;
import com.emre.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer fromDtoToSaveCustomer(final RegisterCustomerRequestDto dto);

}
