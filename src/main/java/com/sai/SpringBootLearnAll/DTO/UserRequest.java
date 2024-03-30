package com.sai.SpringBootLearnAll.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data
public class UserRequest implements Serializable {
    private String name;
    private Integer age;
    private String mobileNumber;
    private String gender;
    private String nationality;
    private String email;
}
