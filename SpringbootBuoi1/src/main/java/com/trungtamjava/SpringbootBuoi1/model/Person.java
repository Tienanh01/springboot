package com.trungtamjava.SpringbootBuoi1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
//@Getter
//@Setter
@Data // generate
public class Person {
    private int id;

    private int age;
    @NotEmpty(message ="Không được để trống")
    private String name;

    private String country;

}
