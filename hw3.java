import java.util.Scanner;

public class hw3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные пользователя: ");
        String userInput = scanner.nextLine();

        try {
            String[] userData = userInput.split(" ");

            if (userData.length != 5) {
                throw new IllegalArgumentException("Неверное количество данных!");
            }

            String surname = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String dateOfBirth = userData[3];
            String phoneNumber = userData[4];

            validateSurname(surname);
            validateFirstName(firstName);
            validateMiddleName(middleName);
            validateDateOfBirth(dateOfBirth);
            validatePhoneNumber(phoneNumber);

            System.out.println("Данные введены корректно!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void validateSurname(String surname) {
        if (surname.isEmpty()) {
            throw new IllegalArgumentException("Не указана фамилия!");
        }
    }

    private static void validateFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя!");
        }
    }

    private static void validateMiddleName(String middleName) {
        if (middleName.isEmpty()) {
            throw new IllegalArgumentException("Не указано отчество!");
        }
    }

    private static void validateDateOfBirth(String dateOfBirth) {
        if (!dateOfBirth.matches("\\d{2}.\\d{2}.\\d{4}")) {
            throw new IllegalArgumentException("Некорректный формат даты рождения!");
        }
    }

    private static void validatePhoneNumber(String phoneNumber) {
        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный формат номера телефона!");
        }
    }

}