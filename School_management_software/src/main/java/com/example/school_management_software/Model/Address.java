package com.example.school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {
    //area , street , buildingNumber

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @Column(columnDefinition = "int not null ")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
