import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator()
    {
    }

    private static final String  DefaultLocale = "ru";
    private static final String[] PredefinedCity = {"Москва", "Абакан", "Владикавказ",
            "Екатеринбург", "Казань", "Калининград", "Калуга", "Кострома", "Краснодар"};

    public static String getCity()
    {
        int randomIndex = new Random().nextInt(PredefinedCity.length);
        return PredefinedCity[randomIndex];
    }

    public static String getName(Locale locale)
    {
        return new Faker(locale).name().fullName();
    }

    public static String getPhone(Locale locale)
    {
        return new Faker(locale).phoneNumber().toString();
    }
}



