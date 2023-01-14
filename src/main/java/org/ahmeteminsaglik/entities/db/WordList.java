package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "word_list")
@NoArgsConstructor
public class WordList {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true)
    private String name;

    public WordList(String name) {
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
        WordList wordList = (WordList) o;
        return Objects.equals(name, wordList.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "WordList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
