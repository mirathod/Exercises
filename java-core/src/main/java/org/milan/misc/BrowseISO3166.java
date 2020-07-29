package org.milan.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Responsible for fetching country codes or country names based on passed country codes,country names, matched string
 *
 * @author Milan Rathod
 */
public class BrowseISO3166 {

    private String[][] countries;

    public static void main(String[] args) {
        BrowseISO3166 browseISO3166 = new BrowseISO3166();

        browseISO3166.init();

        System.out.println("Welcome to Browse ISO-3166. Enter “bye” anytime to end.");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Please enter a country code or a country name: ");

            String input = scanner.nextLine();


            while (input != null && input.length() < 2) {
                System.out.print("Matching string cannot be less than two letters, please enter another matching string: ");
                input = scanner.nextLine();
            }

            String countryResult = browseISO3166.getCountryResult(input);
            if (countryResult != null) {
                System.out.println(countryResult);
            } else {
                break;
            }

            System.out.print("Please enter a matching string for the country names: ");

            input = scanner.nextLine();

            while (input != null && input.length() < 2) {
                System.out.print("Matching string cannot be less than two letters, please enter another matching string: ");
                input = scanner.nextLine();
            }


            if (input != null && input.equals("bye")) {
                break;
            } else {
                browseISO3166.printMatchedCountries(input);
            }

        }

        System.out.println();

        System.out.println("Bye");
    }

    /**
     * Responsible for initialization of counties array with country code & country name
     */
    private void init() {

        String[] countryCodes = Locale.getISOCountries();

        countries = new String[countryCodes.length][];

        for (int i = 0; i < countryCodes.length; i++) {
            Locale locale = new Locale("", countryCodes[i]);
            countries[i] = new String[]{countryCodes[i], locale.getDisplayCountry()};
        }

    }

    /**
     * Get country name associated based on specified country code
     *
     * @param countryCode country code
     * @return country name associated with given country code if exists otherwise null
     */
    private String getCountryName(String countryCode) {
        for (int i = 0; i < countries.length; i++) {
            if (countryCode != null && countryCode.equalsIgnoreCase(countries[i][0])) {
                return countries[i][1];
            }
        }
        return null;
    }

    /**
     * Get country code associated based on specified country name
     *
     * @param countryName country name
     * @return country code associated with given country name if exists otherwise null
     */
    private String getCountryCode(String countryName) {
        for (int i = 0; i < countries.length; i++) {
            if (countryName != null && countryName.equalsIgnoreCase(countries[i][1])) {
                return countries[i][0];
            }
        }
        return null;
    }

    /**
     * Get list of countries that matches country code/ country name with match string
     *
     * @param matchString match string
     * @return list of matched countries
     */
    private List<String> getMatchedCountries(String matchString) {

        List<String> outputList = new ArrayList<>();

        for (int i = 0; i < countries.length; i++) {
            String countryCode = countries[i][0];
            String countryName = countries[i][1];
            if (countryCode.contains(matchString) || countryName.contains(matchString)) {
                outputList.add(countryName + " (" + countryCode + ")");
            }
        }

        return outputList;
    }

    /**
     * Based on given country code/ country name return appropriate string
     *
     * @param input country code/ country name
     */
    private String getCountryResult(String input) {

        if (input != null && input.length() == 2) {
            String countryName = getCountryName(input);

            if (countryName != null) {
                return "The country name for the country code entered " + input + " is " + countryName;
            } else {
                return "No match for country code entered";
            }
        } else if (input != null && !input.equals("bye")) {
            String countryCode = getCountryCode(input);

            if (countryCode != null) {
                return "The country code for the country name entered " + input + " is " + countryCode;
            } else {
                return "No match for country name entered";
            }
        }
        return null;
    }

    /**
     * Print all matched countries
     *
     * @param input matching string
     */
    private void printMatchedCountries(String input) {

        List<String> matchedCountries = getMatchedCountries(input);

        if (matchedCountries.size() == 0) {
            System.out.println("No match for matching string entered");
        } else {
            System.out.printf("The list of countries for the matching string “%s” is the following:\n", input);

            System.out.println("Results count: " + matchedCountries.size());

            matchedCountries.forEach(System.out::println);
        }
    }

}
