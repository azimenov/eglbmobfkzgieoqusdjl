package com.example.eglbmobfkzgieoqusdjl.employee.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@Builder
public class Employee {
    @Id
    private ObjectId id;

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
