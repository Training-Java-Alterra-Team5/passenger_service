package com.passenger.passenger.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Passengers")
@Table(name="passengers")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Passengers extends Audit<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, unique = true)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false, insertable = true, referencedColumnName = "id")
    private Roles roles;

    @Column(name = "username", nullable = false, insertable = true, length = 50)
    private String username;

    @Column(name = "password", nullable = false, insertable = true)
    private String password;

    @Column(name = "name", nullable = false, insertable = true, length = 1)
    private String name;

    @Column(name = "address", nullable = false, insertable = true, length = 1)
    private String address;

    @Lob
    @Column(name = "mobileNumber", nullable = true, insertable = true, length=512)
    private String mobileNumber;
}
