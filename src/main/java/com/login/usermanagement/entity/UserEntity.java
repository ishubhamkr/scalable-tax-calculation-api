package com.login.usermanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Data
public class UserEntity {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;

}
