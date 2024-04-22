package com.example.agencybooking.guest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestDto {

    private String name;
    private String surname;
    private String email;
    private String mobileNumber;
    private String address;
    private String userOfEntry;
}
