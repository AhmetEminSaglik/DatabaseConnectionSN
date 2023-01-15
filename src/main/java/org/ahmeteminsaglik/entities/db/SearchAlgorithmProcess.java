package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "search_algorithm_process")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchAlgorithmProcess {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "search_algorithm_id")
    private int searchAlgorithmId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private Record recordId;

}
