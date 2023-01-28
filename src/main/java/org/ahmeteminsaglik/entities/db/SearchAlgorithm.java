package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
@Entity
@Table(name = "search_algorithm")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchAlgorithm {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true,nullable = false)
    private String name;

    public SearchAlgorithm(String name) {
        this.name = name;
    }

}
