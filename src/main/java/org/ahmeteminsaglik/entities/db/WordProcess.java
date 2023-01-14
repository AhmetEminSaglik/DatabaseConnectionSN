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

    @Column(name = "total_word_list_id")
    @OneToOne(mappedBy = "wordProcessId")
    private WordList totalWordListId;

    @Column(name = "search_word_list_id")
    @OneToOne(mappedBy = "wordProcessId")
    private WordList searchWordListId;
    @Column(name = "found_word")
    private int foundWord;
    @Column(name = "misssing_word")
    private int missingWord;


}
