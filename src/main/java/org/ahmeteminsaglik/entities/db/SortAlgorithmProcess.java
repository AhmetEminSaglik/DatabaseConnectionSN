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

    @Column(name = "sort_algorithm_id", nullable = false)
    private int sortAlgorithmId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id", nullable = false)
    private Record record;
}
