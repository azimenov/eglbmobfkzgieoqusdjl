package com.example.eglbmobfkzgieoqusdjl.customer.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @NotBlank
    private String username;
    private int year;
    @NotBlank
    @Pattern(regexp = "\\+7\\d{10}", message = "invalid phone number")
    private String firstPhoneNumber;
    @NotBlank
    @Pattern(regexp = "\\+7\\d{10}", message = "invalid phone number")
    private String secondPhoneNumber;
    private LocalDateTime createdAt;
}
