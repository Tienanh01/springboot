package com.trungtamjava.SpringbootBuoi1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String role;

}
