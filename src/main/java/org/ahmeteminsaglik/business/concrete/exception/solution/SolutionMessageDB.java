package org.ahmeteminsaglik.business.concrete.exception.solution;

public class SolutionMessageDB {
    private static final String solutionAdvice = "SOLUTION ADVICE : ";

    public static String getSolutionNullColumnException() {
        final String solutionHint = "There are 2 reasons for this exception :" +
                "\n --> 1 : Column could be empty." +
                "\n --> 2 : Requested Value is not found in table's column." +
                "\n >>> " + solutionAdvice + "Please run createAllTablesAndColumns() function in DBTableAndColumCreation Class.";
        return solutionHint;
    }
}

