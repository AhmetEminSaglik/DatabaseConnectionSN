package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table (name = "word_50")
@NoArgsConstructor
@Getter
@Setter
public class Word {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="word",nullable = false)
    private  String word;

    public Word(String word) {
        this.word = word;
    }

}
