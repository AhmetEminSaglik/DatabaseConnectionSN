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
    @JoinColumn(name = "record_id",nullable = false)
    private Record record;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "process_name_id",nullable = false)
    @Column(name = "process_name_id",nullable = false)
    private int processNameId;
    @Column(name = "elapsed_time",nullable = false)
    private String elapsedTime;
    @Column(name = "memory_usage_kb",nullable = false)
    private String memoryUsage;
//    @Column(name = "elapsed_time")
//    private  Ti

}