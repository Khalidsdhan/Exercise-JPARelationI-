package com.example.school_management_software.Controller;

import com.example.school_management_software.Api.ApiResponse;
import com.example.school_management_software.DTO.AddressDOT;
import com.example.school_management_software.Model.Address;
import com.example.school_management_software.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDOT addressDOT){
        addressService.addAddress(addressDOT);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address is add"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress( @Valid @RequestBody AddressDOT addressDOT){
        addressService.updateAddress(addressDOT);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address is updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address is deleted"));
    }
}
