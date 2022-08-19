package com.passenger.passenger.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Roles")
@Table(name="roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Roles extends Audit<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, unique = true)
    private Integer id;

    @Column(name = "roleName", nullable = false, insertable = true, length = 50)
    private String roleName;
}
