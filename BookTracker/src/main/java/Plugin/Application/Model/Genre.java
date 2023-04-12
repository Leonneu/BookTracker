package Plugin.Application.Model;

import java.util.Arrays;
import java.util.EnumSet;

public enum Genre {
    CLASSIC,
    THRILLER,
    ROMANCE,
    FANTASY,
    SCIENCE_FICTION,
    FICTION,
    HORROR,
    DYSTOPIA,
    PSYCHOLOGY,
    PHILOSOPHY;

    //TODO implement
    public static EnumSet<Genre> parseGenreSet(String[] values) {
        var result = EnumSet.noneOf(Genre.class);
        for (String s : values
        ) {
            result.add(Genre.valueOf(s));
        }
        return result;
    }

    public static String[] getNames() {
        return Arrays.stream(Genre.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}
