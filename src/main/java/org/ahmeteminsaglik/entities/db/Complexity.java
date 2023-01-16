package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "complexity")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Complexity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private Record record;
    @OneToOne
    @JoinColumn(name = "process_name_id")
    private ProcessName processName;
    @Column(name = "elapsed_time")
    private String elapsedTime;
    @Column(name = "memory_usage_kb")
    private String memoryUsage;
//    @Column(name = "elapsed_time")
//    private  Ti

}
