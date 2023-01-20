package com.example.jpareference.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime createdAt;

    private String firstName;
    private String lastName;

}
