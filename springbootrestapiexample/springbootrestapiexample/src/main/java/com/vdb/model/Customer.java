package com.vdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int custId;
    private String custName;
    private double custAccBalance;
}
