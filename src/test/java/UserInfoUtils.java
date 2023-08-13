import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class UserInfoUtils {
    private UserInfoUtils() {

    }
    public static UserInfo GenerateUser(Locale locale) {
        String name = DataGenerator.getName(locale);
        String city = DataGenerator.getCity();
        String phone = DataGenerator.getPhone(locale);

        return new UserInfo(name, city, phone);
    }
}

