package com.example.SpringBootAcademy.Service;

import com.example.SpringBootAcademy.Dto.CustomerDto;
import com.example.SpringBootAcademy.Dto.ItemDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public interface ItemService {


    public String saveItem(ItemDto itemDto);
}
