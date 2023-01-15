package org.ahmeteminsaglik.entities.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratedColumn;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private Record record;

    @OneToOne()
    @JoinColumn(name = "total_word_list_id")
    private WordList totalWordListId;

    @OneToOne()
    @JoinColumn(name = "search_word_list_id")
    private WordList searchWordListId;

}
