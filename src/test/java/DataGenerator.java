import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static final String DefaultLocale = "ru";

    public static String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    private static final String[] PredefinedCity = {"Москва", "Абакан", "Владикавказ",
            "Екатеринбург", "Казань", "Калининград", "Калуга", "Кострома", "Краснодар"};

    public static String getCity() {
        int randomIndex = new Random().nextInt(PredefinedCity.length);
        return PredefinedCity[randomIndex];
    }

    public static String getName(Locale locale) {
        return new Faker(locale).name().fullName();
    }

    public static String getPhone(Locale locale) {
        return new Faker(locale).phoneNumber().toString();
    }
}



