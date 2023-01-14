package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "word_no_selected_table")
@NoArgsConstructor
public class Word {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="word")
    private  String word;

    public Word(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
