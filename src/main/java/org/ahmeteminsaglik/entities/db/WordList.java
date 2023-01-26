package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "word_list")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WordList {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true,nullable = false)
    private String name;

    public WordList(String name) {
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

}
