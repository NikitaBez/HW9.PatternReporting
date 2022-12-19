package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        String[] cities = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород",
                "Биробиджан", "Благовещенск", "Брянск", "Великий  Новгород", "Владивосток", "Владикавказ",
                "Владимир", "Волгоград", "Вологда", "Воронеж", "Гатчина", "Горно-Алтайск", "Грозный",
                "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга",
                "Кемерово", "Киров", "Кострома", "Красногорск", "Краснодар", "Красноярск", "Курган", "Курск",
                "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Мурманск", "Нальчик",
                "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург", "Пенза", "Пермь",
                "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард",
                "Самара", "Санкт-Петербург", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь",
                "Смоленск", "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ",
                "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары", "Челябинск", "Черкесск", "Чита",
                "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль"};
        Faker faker = new Faker(new Locale(locale));
        return cities[faker.number().numberBetween(0, cities.length -1)];
        //return cities[new Random().nextInt(cities.length)]; - //еще один варинант как из массива извлекать отдельный город
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName().replace("ё", "е") + " " + faker.name().firstName().replace("ё", "е");
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().cellPhone();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}