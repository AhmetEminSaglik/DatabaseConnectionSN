package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "data_structor")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DataStructor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public DataStructor(String name) {
        this.name = name;
    }

}
