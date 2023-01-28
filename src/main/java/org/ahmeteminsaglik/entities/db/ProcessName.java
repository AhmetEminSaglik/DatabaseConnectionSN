package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "process_name")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProcessName {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public ProcessName(String name) {
        this.name = name;
    }

}
