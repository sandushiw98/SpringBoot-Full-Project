package com.example.SpringBootAcademy.Service.impl;

import com.example.SpringBootAcademy.Dto.ItemDto;
import com.example.SpringBootAcademy.Entity.Item;
import com.example.SpringBootAcademy.Repository.ItemRepo;
import com.example.SpringBootAcademy.Service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String saveItem(ItemDto itemDto) {
        Item item = modelMapper.map(itemDto,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+ " saved successfully ";
        }
        throw  new DuplicateKeyException("Already Added");
    }
}
