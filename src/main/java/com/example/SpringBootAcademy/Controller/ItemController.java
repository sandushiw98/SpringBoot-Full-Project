package com.example.SpringBootAcademy.Controller;


import com.example.SpringBootAcademy.Dto.CustomerDto;
import com.example.SpringBootAcademy.Dto.ItemDto;
import com.example.SpringBootAcademy.Service.ItemService;
import com.example.SpringBootAcademy.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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







}
