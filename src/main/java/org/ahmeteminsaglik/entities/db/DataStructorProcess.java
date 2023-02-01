package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data_structor_process")
@NoArgsConstructor
@Getter
@Setter
public class DataStructorProcess {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "data_structor_id", nullable = false)
    private int dataStructorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id", nullable = false)
    private Record record;

}
