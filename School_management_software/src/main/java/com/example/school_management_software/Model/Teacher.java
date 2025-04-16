package com.example.school_management_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //id , name , age , email , salary

    @Column(columnDefinition = "varchar(10) not null")
    @NotEmpty(message = "name must be not empty")
    private String name;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "age must be not null")
    private Integer age;

    @Column(columnDefinition = "varchar(20) not null unique ")
    @NotEmpty(message = "email must be not empty")
    @Email
    private String email;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "salary must be not empty")
    @Positive
    private Double salary;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    //  @OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
    //    @PrimaryKeyJoinColumn
}
