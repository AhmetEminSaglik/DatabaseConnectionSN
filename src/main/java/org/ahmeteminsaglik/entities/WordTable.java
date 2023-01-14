package org.ahmeteminsaglik.entities;

import java.util.Locale;

public enum WordTable {
    WORD_ALL,
    WORD_50, WORD_100, WORD_250, WORD_500, WORD_1_000, WORD_1_500, WORD_3_000, WORD_5_000, WORD_7_500, WORD_10_000,
    WORD_15_000, WORD_20_000, WORD_25_000, WORD_35_000, WORD_40_000, WORD_50_000, WORD_100_000, WORD_150_000,
    WORD_200_000, WORD_250_000, WORD_300_000, WORD_450_000, WORD_500_000, WORD_750_000, WORD_1_000_000,
    WORD_1_500_000, WORD_2_000_000, WORD_3_000_000;

    public static String selectTableName(WordTable wordTable) {
        return  wordTable.name().toLowerCase(Locale.ROOT);
    }



}
