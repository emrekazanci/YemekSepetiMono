package com.emre.mapper;

import com.emre.dto.request.SaveProductRequestDto;
import com.emre.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);
    Product fromSaveDtoToProduct(SaveProductRequestDto dto);
}
