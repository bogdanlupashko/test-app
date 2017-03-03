package org.bl.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHelper {

    private static final String REGEXP_WORD = "([^\\u0000-\\u0040\\u005B-\\u0060\\u007B-\\u00BF\\u02B0-\\u036F\\u00D7\\u00F7\\u2000-\\u2BFF])+";

    public int parseText(String text, int length) {

        if (StringUtils.isBlank(text) || length < 1) {
            // custom exception could be throwed
            return 0;
        }

        List<String> wordList = getMatchingStrings(text);

        OptionalDouble optionalDouble = wordList.stream()
                .filter(word -> word.length() > length)
                .mapToInt(String::length)
                .average();

        if (!optionalDouble.isPresent()) {
            // custom exception could be throwed
            return 0;
        }
        return (int) optionalDouble.getAsDouble();
    }

    private List<String> getMatchingStrings(String text) {
        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile(REGEXP_WORD).matcher(text);
        while (m.find()) {
            allMatches.add(m.group());
        }

        return allMatches;
    }


}
