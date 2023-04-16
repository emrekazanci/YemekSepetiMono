package com.emre.mapper;

import com.emre.dto.request.SaveRestaurantRequestDto;
import com.emre.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);
    Restaurant fromDtoToSaveRestaurant(final SaveRestaurantRequestDto dto);
}
