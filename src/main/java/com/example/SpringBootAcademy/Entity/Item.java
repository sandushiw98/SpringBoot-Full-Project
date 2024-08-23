package com.example.SpringBootAcademy.Entity;


import com.example.SpringBootAcademy.Entity.enums.MesuringUnitType;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@Table(name = "Item")

public class Item {
    @Id
    @Column(name = "Item_Id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name="Item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name= "mesure_type", length = 100, nullable = false)
    private MesuringUnitType mesuringUnitType;

    @Column(name ="balance_qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name ="supplier_price", length = 100, nullable = false)
    private  double supplierPrice;

    @Column(name ="selling_price", length = 100, nullable = false)
    private  double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean active;











}
