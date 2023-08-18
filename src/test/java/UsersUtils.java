import java.util.Locale;

public class UsersUtils {
    private UsersUtils() {

    }
    public static UserInfo generateUser(Locale locale) {
        String name = DataGenerator.getName(locale);
        String city = DataGenerator.getCity();
        String phone = DataGenerator.getPhone(locale);

        return new UserInfo(name, city, phone);
    }
}

