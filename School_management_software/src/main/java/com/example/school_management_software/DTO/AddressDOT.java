package com.example.school_management_software.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDOT {

    private Integer teacher_id;

    @NotEmpty(message = "area must be not null")
    private String area;

    @NotEmpty(message = "street must be not null")
    private String street;

    @NotNull(message = "buildingNumber must be not null")
    private Integer buildingNumber;

}
