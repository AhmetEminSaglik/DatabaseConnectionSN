package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "data_structor")
@NoArgsConstructor
public class DataStructor {

    @Id
    @Column
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    public DataStructor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataStructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
