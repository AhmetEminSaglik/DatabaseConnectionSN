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
//@ToString
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
    /*@OneToMany(mappedBy = "recordId",
//    fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity = DataStructorProcess.class)
    private List<DataStructorProcess> dataStructorProcessList = new ArrayList<>();

    @OneToMany(mappedBy = "recordId",
            cascade = CascadeType.ALL,
            targetEntity = SortAlgorithmProcess.class)
    private List<SortAlgorithmProcess> sortAlgorithmProcessList = new ArrayList<>();

    @OneToMany(mappedBy = "recordId",
            cascade = CascadeType.ALL,
            targetEntity = SearchAlgorithmProcess.class)
    private List<SearchAlgorithmProcess> searchAlgorithmProcessList = new ArrayList<>();*/

    public int getId() {
        return id;
    }

}
