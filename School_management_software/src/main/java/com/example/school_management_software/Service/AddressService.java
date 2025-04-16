package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.DTO.AddressDOT;
import com.example.school_management_software.Model.Address;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherService teacherService;


    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDOT addressDOT){
        Teacher teacher=teacherService.getTeacherById(addressDOT.getTeacher_id());
        if(teacher==null){
            throw new ApiException("address is not found");
        }
        Address address= new Address(null,addressDOT.getArea(),addressDOT.getStreet(),addressDOT.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDOT addressDOT){
        Address address=addressRepository.findAddressById(addressDOT.getTeacher_id());

        if(address==null){
            throw new ApiException("address not found");
        }
        address.setArea(addressDOT.getArea());
        address.setStreet(addressDOT.getStreet());
        address.setBuildingNumber(addressDOT.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address=addressRepository.findAddressById(id);

        if(address==null){
            throw new ApiException("address is not found");
        }
        addressRepository.delete(address);
    }

}
