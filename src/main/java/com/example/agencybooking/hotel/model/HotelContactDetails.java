package com.example.agencybooking.hotel.model;

import com.example.agencybooking.utils.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HotelContactDetails extends BaseEntity {

    @Id
    private Long id;
    private String email;
    private String telNumber;
    private String mobileNumber;
    private String faxNumber;
    @OneToOne
    @MapsId
    private Hotel hotel;
}
