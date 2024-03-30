package com.sai.SpringBootLearnAll.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "user_in_my_db")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
@Builder
public class User implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "user name cannot be null")
    private String name;

    @Min(18)
    @Max(60)
    private Integer age;

    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "enter valid mobile number")
    private String mobileNumber;

    private String gender;

    @NotBlank
    private String nationality;

    @Email
    private String email;

}
