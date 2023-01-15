package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "word_process")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WordProcess {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "found_word")
    private int foundWord;
    @Column(name = "misssing_word")
    private int missingWord;

    @OneToOne()
    private WordList totalWordListId;

    @OneToOne()
    private WordList searchWordListId;

    @OneToOne(cascade = CascadeType.ALL)
    private Record recordId;
}
