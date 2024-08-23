package com.example.SpringBootAcademy.Dto.response;

import com.example.SpringBootAcademy.Entity.enums.MesuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;
    private  double supplierPrice;
    private  double sellingPrice;
    private boolean active;

}
