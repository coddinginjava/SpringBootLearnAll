package com.sai.SpringBootLearnAll.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String name;
    private int age;
    private String gender;
}
