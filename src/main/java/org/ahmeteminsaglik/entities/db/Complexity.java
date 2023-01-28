package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "complexity")
@NoArgsConstructor
@Getter
@Setter
public class Complexity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id",nullable = false)
    private Record record;
    @OneToOne
    @JoinColumn(name="process_name_id",nullable = false)
    private  ProcessName processName;
    @Column(name = "elapsed_time",nullable = false)
    private String elapsedTime;
    @Column(name = "memory_usage_kb",nullable = false)
    private String memoryUsage;

    @Override
    public String toString() {
        return "Complexity{" +
                "id=" + id +
                ", record=" + record +
                ", processName=" + processName +
                ", elapsedTime='" + elapsedTime + '\'' +
                ", memoryUsage='" + memoryUsage + '\'' +
                '}';
    }
}
