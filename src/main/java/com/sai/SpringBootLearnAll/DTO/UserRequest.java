package com.sai.SpringBootLearnAll.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data
public class UserRequest {
    private String name;
    private Integer age;
    private String mobileNumber;
    private String gender;
    private String nationality;
    private String email;
}
