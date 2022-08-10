package com.platzi.market.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Purchase {

    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private List<PurchaseItem> items;
    private String state;
}
