package com.pro.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long vehicleId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
}
