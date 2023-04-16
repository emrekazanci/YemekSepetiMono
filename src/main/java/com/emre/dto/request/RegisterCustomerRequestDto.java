package com.emre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCustomerRequestDto {
    @NotBlank(message = "Lütfen adınızı giriniz.")
    String customerName;
    String surname;
    @Email
    @Column(unique = true)
    String email;
    @NotBlank(message = "Lütfen adresinizi giriniz.")
    String address;
    String phoneNumber;
    String password;
    @NotBlank(message = "Lütfen kart bilgilerini giriniz.")
    String cardDetails;
}
