package org.ahmeteminsaglik.core.exception.solution;

public class SolutionMessageDB {
    private static final String solutionAdvice = "SOLUTION ADVICE : ";

    public static String getSolutionNullColumnException() {
        final String solutionHint = "There are 2 reasons for this exception :" +
                "\n --> 1 : Column could be empty. (Not added any value)" +
                "\n --> 2 : The requested value is not yet added to the database." +
                "\n >>> " + solutionAdvice + "Please run createAllTablesAndColumns() function in DBTableAndColumCreation Class.";
        return solutionHint;
    }
}

