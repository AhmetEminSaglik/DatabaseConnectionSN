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
    @ManyToOne(cascade = CascadeType.ALL)
    private Record recordId;

    @Column(name = "data_structor_id")
    private int dataStructorId;

    public int getDataStructorId() {
        return dataStructorId;
    }


    public void setDataStructorId(int dataStructorId) {
        this.dataStructorId = dataStructorId;
    }

}
