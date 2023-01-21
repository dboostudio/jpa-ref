package com.example.jpareference.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<Rental> rentalList;

    public void addRental(Rental rental) {
        if (this.rentalList == null)
            this.rentalList = new ArrayList<>();
        if (!this.rentalList.contains(rental))
            rentalList.add(rental);
    }

}
