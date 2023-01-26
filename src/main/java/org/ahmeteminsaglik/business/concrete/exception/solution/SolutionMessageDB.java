package org.ahmeteminsaglik.business.concrete.exception.solution;

public class SolutionMessageDB {
    private static final String solutionAdvice = "SOLUTION ADVICE : ";

    public static String getSolutionNullColumnException() {
        final String solutionHint = solutionAdvice + "Please run createAllTablesAndColumns() function in DBTableAndColumCreation Class";
        return solutionHint;
    }
}

