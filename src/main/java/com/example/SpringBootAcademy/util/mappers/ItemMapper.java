package com.example.SpringBootAcademy.util.mappers;

import com.example.SpringBootAcademy.Dto.response.ItemGetResponseDTO;
import com.example.SpringBootAcademy.Entity.Item;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
}







