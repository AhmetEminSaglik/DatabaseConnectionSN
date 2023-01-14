package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data_structor_process")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DataStructorProcess {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "data_structor_id")
    private int dataStructorId;
    @OneToOne(/*mappedBy = "dataStructorProcess",*/
            cascade = CascadeType.ALL)
    private Record recordId;


}
