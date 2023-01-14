package org.ahmeteminsaglik.entities.enums;

public enum EnumWordTable {
    WORD_ALL("word_all"),
    WORD_50("word_50"), WORD_100("word_100"), WORD_250("word_250"), WORD_500("word_500"),
    WORD_1_000("word_1_000"), WORD_1_500("word_1_500"), WORD_3_000("word_3_000"),
    WORD_5_000("word_5_000"), WORD_7_500("word_7_500"), WORD_10_000("word_10_000"),
    WORD_15_000("word_15_000"), WORD_20_000("word_20_000"), WORD_25_000("word_25_000"),
    WORD_35_000("word_35_000"), WORD_40_000("word_40_000"), WORD_50_000("word_50_000"),
    WORD_100_000("word_100_000"), WORD_150_000("word_150_000"), WORD_200_000("word_200_000"),
    WORD_250_000("word_250_000"), WORD_300_000("word_300_000"), WORD_450_000("word_450_000"),
    WORD_500_000("word_500_000"), WORD_750_000("word_750_000"), WORD_1_000_000("word_1_000_000"),
    WORD_1_500_000("word_1_500_000"), WORD_2_000_000("word_2_000_000"),
    WORD_3_000_000("word_3_000_000");

    private final String name;

    EnumWordTable(String name) {
        this.name = name;
    }

    public static String selectTableName(EnumWordTable wordTable) {
        return wordTable.name;
    }


}
