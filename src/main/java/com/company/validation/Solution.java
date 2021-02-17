package com.company.validation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'countCounterfeit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY serialNumber as parameter.
     */

    public static int countCounterfeit(List<String> serialNumber) {


        List<String> validSerial = serialNumber.stream().parallel()
                .filter(s1 -> 8 <= s1.length() && s1.length() <= 12)
                .filter(s2 -> s2.equals(s2.toUpperCase()))
                .filter(s3 -> !Character.isDigit(s3.charAt(s3.length() - 1)))
                .collect(Collectors.toList());

        int sum = 0;
        for (String s : validSerial) {
            String firstThree = s.substring(0, 3);
            String year = s.substring(3, 7);
            char last = s.charAt(s.length() - 1);
            int currency = getCurrencyDenomination(s);

            if (isDistinctChars(firstThree) && isYearValid(year) && isLastChar(last)) {
                sum += getSum(currency);
            }

//            System.out.printf("%s%n1rst 3: %s Year: %s Rest: %s last: %s Length: %s%n", s, firstThree, year, rest, last, s.length());
//
//            System.out.printf("1rst 3: %s, Valid Year: %s Last Digit: %s%n%n", isDistinctChars(firstThree), isYearValid(year), isLastChar(last));

        }

        System.out.println(validSerial);

        return sum;
    }

    private static int getCurrencyDenomination(String s) {
        try {
            Integer.parseInt(s.substring(7, s.length() - 1));
        } catch (NumberFormatException nfe) {
            System.err.println(nfe);
        }
        int[] validDenominations = {10, 20, 50, 100, 200, 500, 1000};
        int currencyAmount = Integer.parseInt(s.substring(7, s.length() - 1));

        if (IntStream.of(validDenominations).anyMatch(value -> value == currencyAmount)) {
            return currencyAmount;
        }
        return 0;
    }

    private static int getSum(int currency) {
        return currency;
    }

    private static boolean isLastChar(char last) {
        return !Character.isLowerCase(last) && !Character.isDigit(last);
    }

    private static boolean isDistinctChars(String firstThree) {
        char[] areDistinct = firstThree.toCharArray();
        for (char c : areDistinct) {
            if (!Character.isUpperCase(c)) {
                return false;
            } else if (areDistinct[0] == areDistinct[1]) {
                return false;
            } else if (areDistinct[0] == areDistinct[2] || areDistinct[1] == areDistinct[2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isYearValid(String year) {
        try {
            int intYear = Integer.parseInt(year);
            return intYear >= 1900 && intYear <= 2019;
        } catch (NumberFormatException nfe) {
            System.err.println(nfe);
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        //"5", "A201550B", "ABB19991000Z", "A201550B", "XYZ200019Z", "ERF200220", "SCD203010T"
        //Result.countCounterfeit(Arrays.asList("QDB2012R20B", "RED190250E", "RFV201111T", "TYU20121000E", "AAA198710B", "AbC200010E"));
        //System.out.println("Sum: " + Result.countCounterfeit(Arrays.asList("QDB2012R20B", "RED190250E", "RFV201111T", "TYU20121000E", "AAA198710B", "AbC200010E")));
        System.out.println("Expected 1050: " + Result.countCounterfeit(Arrays.asList("6",
                "RED190250E", // 50
                "RFV201111T", // 11 fail
                "TYU20121000E", // 1000
                "AAA198710B", // fail
                "AbC200010E"))); //fail

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int serialNumberCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> serialNumber = IntStream.range(0, serialNumberCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }).collect(toList());
//
//        int result = Result.countCounterfeit(serialNumber);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}


//    char[] charArray = s.toCharArray();
//    StringBuilder temp = new StringBuilder();
//            for (int i = 0; i < charArray.length - 1; i++) {
//        if (i <= 2 && Character.isUpperCase(charArray[i])) {
//        temp.append(charArray[i]);
//        if (temp.length() == 3)
//        System.out.println(temp);
//        }
//
//        if(temp.length()==3 && charArray[i]==1){
//
//        }