package com.example.SpringBootAcademy.Service.impl;

import com.example.SpringBootAcademy.Dto.request.ItemDto;
import com.example.SpringBootAcademy.Dto.response.ItemGetResponseDTO;
import com.example.SpringBootAcademy.Entity.Item;
import com.example.SpringBootAcademy.Repository.ItemRepo;
import com.example.SpringBootAcademy.Service.ItemService;
import com.example.SpringBootAcademy.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemDto itemDto) {
        Item item = modelMapper.map(itemDto,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+ " saved successfully ";
        }
        throw  new DuplicateKeyException("Already Added");
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

        boolean b = true;
        List<Item> item = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName,b);
        if (item.size()>0) {
            List<ItemGetResponseDTO> itemGetRespon  = modelMapper.map(item, new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetRespon;
        } else{
            throw new RuntimeException("Item is not Active");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        boolean b = true;
        List<Item> item = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName, b);
        if (item.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponse = itemMapper.entityListToDtoList(item);
            return itemGetResponse;
        } else {
            throw new RuntimeException("Item is not active");
        }
    }
}
