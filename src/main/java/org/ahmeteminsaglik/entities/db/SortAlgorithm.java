package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "sort_algorithm")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SortAlgorithm {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",unique = true,nullable = false)
    private String name;

    public SortAlgorithm(String name) {
        this.name = name;
    }

}
