package com.fooddelivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {

    private Long id;

    @NotBlank(message = "Name is mandatory !")
    @Size(min = 2, message = "Name must be at least 2 characters !")
    private String name;

    @NotBlank(message = "Email is mandatory !")
    @Email(message = "Enter a valid email !")
    private String email;

    @NotBlank(message = "Phone is mandatory !")
    private String phone;

    @NotBlank(message = "Address is mandatory !")
    private String address;
}