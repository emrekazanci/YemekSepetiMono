package com.emre.mapper;

import com.emre.dto.request.SaveOrderRequestDto;
import com.emre.repository.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper {
    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);
    Order fromDtoToOrder(final SaveOrderRequestDto dto);
}
