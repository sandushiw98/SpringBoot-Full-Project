package com.example.SpringBootAcademy.Dto;

import com.example.SpringBootAcademy.Entity.enums.MesuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {


    private String itemName;
    private MesuringUnitType mesuringUnitType;
    private double balanceQty;
    private  double supplierPrice;
    private  double sellingPrice;
}
