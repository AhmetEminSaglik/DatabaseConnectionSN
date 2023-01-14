package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;

@Entity
@Table(name = "search_algorithm")
@NoArgsConstructor
public class SearchAlgorithm {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    public SearchAlgorithm(String name) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchAlgorithm that = (SearchAlgorithm) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "SearchAlgorithm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
