package com.example.demo.registration;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}
