package com.example.SpringBootAcademy.Controller;


import com.example.SpringBootAcademy.Dto.request.ItemDto;
import com.example.SpringBootAcademy.Dto.response.ItemGetResponseDTO;
import com.example.SpringBootAcademy.Entity.Item;
import com.example.SpringBootAcademy.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/item")
@CrossOrigin


public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemDto itemDto) {
        String message = itemService.saveItem(itemDto);
        return message;
    }

    @GetMapping (path ="/get-by-name",
                  params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam (value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }


    @GetMapping(path = "/get-by-name-with-mapstruct",
                 params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam (value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemDTOS;

    }




}
