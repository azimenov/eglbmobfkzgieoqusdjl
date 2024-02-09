package com.example.eglbmobfkzgieoqusdjl.employee.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeRequest {

    protected String username;
    protected int year;
    protected String firstPhoneNumber;
    protected String secondPhoneNumber;

    public EmployeeRequest(String username, int year, String firstPhoneNumber, String secondPhoneNumber) {
        this.username = username;
        this.year = year;
        this.firstPhoneNumber = firstPhoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
    }
}
