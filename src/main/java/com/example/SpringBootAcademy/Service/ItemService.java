package com.example.SpringBootAcademy.Service;

import com.example.SpringBootAcademy.Dto.request.ItemDto;
import com.example.SpringBootAcademy.Dto.response.ItemGetResponseDTO;

import java.util.List;


public interface ItemService {


    public String saveItem(ItemDto itemDto);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);
}
