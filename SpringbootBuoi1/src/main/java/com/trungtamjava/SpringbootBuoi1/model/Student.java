package com.trungtamjava.SpringbootBuoi1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student  {
    private int id;
 private String name;
 private String email;
    @NotEmpty(message ="Không được để trống")
//    @NotBlank(message = "mobileNumber is required")
//    @Size(min = 10, max = 10 ,message = "Vui lòng nhập lại số điện thoại")
 private String phone;
 private String city;
}
