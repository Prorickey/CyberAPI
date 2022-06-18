package net.cybercake.cyberapi.basic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    /**
     * Converts an array of {@link String[]} to a {@link List} of {@link String}s
     * @param strings the strings to convert
     * @return a list of strings
     * @since 3.0.0
     */
    public static List<String> arrayToList(String... strings) {
        return new ArrayList<>(Arrays.asList(strings));
    }

    /**
     * Converts a {@link List} of {@link String}s to a {@link String[]}
     * @param list the list to convert
     * @return the array of strings
     * @since 3.0.0
     */
    public static String[] listToArray(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for(String item : list) {
            builder.append(item).append("SP0493");
        }
        return builder.toString().split("SP0493");
    }

    /**
     * Gets some characters between two values
     * @param beginCharacter the index of the first character
     * @param endCharacter the index of the second character
     * @param string the string to manipulate
     * @return the modified string
     * @since 3.0.0
     */
    public static java.lang.String getCharacters(int beginCharacter, int endCharacter, java.lang.String string) {
        if(beginCharacter < 0) {
            return null;
        }

        if(endCharacter > string.length()) {
            return null;
        } else {
            return string.substring(beginCharacter, endCharacter);
        }
    }

    /**
     * The type used for {@link StringUtils#checkStrings(CheckType, String, String...)}
     * @since 3.0.0
     */
    public enum CheckType {
        equals, equalsIgnoreCase, contains, startsWith
    }

    /**
     * Checks one string against multiple strings with a certain method
     * @param checkType the type of checking to perform
     * @param checkAgainst the individual string to check
     * @param strings the strings to check with
     * @return if {@code checkAgainst} and {@code strings} match
     * @since 3.0.0
     */
    public static boolean checkStrings(CheckType checkType, String checkAgainst, String... strings) {
        for(String str : strings) {
            switch (checkType) {
                case equals:
                    if(str.equals(checkAgainst)) {
                        return true;
                    }
                    break;
                case contains:
                    if(str.contains(checkAgainst)) {
                        return true;
                    }
                    break;
                case startsWith:
                    if(str.startsWith(checkAgainst)) {
                        return true;
                    }
                    break;
                case equalsIgnoreCase:
                    if(str.equalsIgnoreCase(checkAgainst)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /**
     * Get strings from arguments, usually from {@link org.bukkit.command.CommandExecutor#onCommand(CommandSender, Command, String, String[])}
     * @param startFrom what index to start from, typically the {@code args.length()} value
     * @param args the arguments to check against
     * @return the arguments combined
     * @since 3.0.0
     */
    public static String getStringFromArguments(int startFrom, String... args) {
        StringBuilder sm = new StringBuilder();
        for(int i = startFrom; i < args.length; i++) {
            String arg = (args[i] + " ");
            sm.append(arg);
        }
        return sm.toString();
    }

    /**
     * Removes duplicates from an {@link ArrayList}
     * @param list the list to remove duplicates from
     * @return the list without duplicates
     * @since 3.0.0
     */
    public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> alreadyOver = new ArrayList<>();
        for(String str : list) {
            if(!alreadyOver.contains(str)) {
                alreadyOver.add(str);
            }
        }
        return alreadyOver;
    }

    /**
     * @since 3.0.0
     */
    public static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder builder = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                builder.append(chars, 0, read);

            return builder.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    /**
     * Makes the message applied in its plural form if {@code value} is not {@code 1}
     * @param message the message to pluralize
     * @param value the amount to check
     * @return the pluralized or not message
     * @since 3.0.0
     */
    public static String pluralize(String message, int value) {
        String ret = message.replaceAll("!#", String.valueOf(value));
        ret = ret.replaceAll("!s", ((value == 1)?"":"s"));        // sword | swords
        ret = ret.replaceAll("!es", ((value == 1)?"":"es"));      // bus | buses
        ret = ret.replaceAll("!ies", ((value == 1)?"y":"ies"));   // penny | pennies
        ret = ret.replaceAll("!oo", ((value == 1)?"oo":"ee"));    // tooth | teeth
        ret = ret.replaceAll("!an", ((value == 1)?"an":"en"));    // woman | women
        ret = ret.replaceAll("!us", ((value == 1)?"us":"i"));     // cactus | cacti
        ret = ret.replaceAll("!is", ((value == 1)?"is":"es"));    // analysis | analyses
        ret = ret.replaceAll("!o", ((value == 1)?"o":"oes"));     // potato | potatoes
        ret = ret.replaceAll("!on", ((value == 1)?"a":"on"));     // criteria | criterion
        ret = ret.replaceAll("!lf", ((value == 1)?"lf":"lves"));  // elf | elves
        ret = ret.replaceAll("!ia", ((value == 1)?"is":"are"));
        ret = ret.replaceAll("!ww", ((value == 1)?"was":"were"));
        return ret;
    }

}
