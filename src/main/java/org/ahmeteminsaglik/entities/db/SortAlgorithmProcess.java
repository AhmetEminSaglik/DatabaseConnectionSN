package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sort_algorithm_process")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SortAlgorithmProcess {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sort_algorithm_id")
    private int sortAlgorithmId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Record recordId;
}
