package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "record")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Record {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "recordId",
//    fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity = DataStructorProcess.class)
    private List<DataStructorProcess> dataStructorProcessList = new ArrayList<>();

    @OneToMany(mappedBy = "recordId",
            cascade = CascadeType.ALL,
            targetEntity = SortAlgorithmProcess.class)
    private List<SortAlgorithmProcess> sortAlgorithmProcessList = new ArrayList<>();

    public int getId() {
        return id;
    }

}
