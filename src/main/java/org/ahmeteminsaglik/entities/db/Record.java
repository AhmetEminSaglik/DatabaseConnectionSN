package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "record")
@NoArgsConstructor
@Getter
@Setter
public class Record {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "record",
            cascade = CascadeType.ALL,
            targetEntity = DataStructorProcess.class)
    private DataStructorProcess dataStructorProcess;

    @OneToOne(mappedBy = "record",
            cascade = CascadeType.ALL,
            targetEntity = SortAlgorithmProcess.class)
    private SortAlgorithmProcess sortAlgorithmProcess;

    @OneToOne(mappedBy = "record",
            cascade = CascadeType.ALL,
            targetEntity = SearchAlgorithmProcess.class)
    private SearchAlgorithmProcess searchAlgorithmProcess;

    @OneToOne(mappedBy = "record",
            cascade = CascadeType.ALL,
            targetEntity = WordProcess.class)
    private WordProcess wordProcess;
    @OneToMany(mappedBy = "record",
            cascade = CascadeType.ALL,
            targetEntity = Complexity.class)
    private List<Complexity> complexityList = new ArrayList<>();

    public int getId() {
        return id;
    }

}
