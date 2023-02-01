package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "word_process")
@NoArgsConstructor
@Getter
@Setter
public class WordProcess {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "found_word",nullable = false)
    private int foundWord;
    @Column(name = "missing_word",nullable = false)
    private int missingWord;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id",nullable = false)
    private Record record;

    @OneToOne()
    @JoinColumn(name = "total_word_list_id",nullable = false)/*"total_word_list_id"*/
    private WordList totalWordList;

    @OneToOne()
    @JoinColumn(name = "search_word_list_id",nullable = false)
    private WordList searchWordList;

}
