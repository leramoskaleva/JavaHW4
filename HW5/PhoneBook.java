package HW5;

import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> contactMap;

    public PhoneBook() {
        contactMap = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumberList = contactMap.getOrDefault(name, new ArrayList<>());
        phoneNumberList.add(phoneNumber);
        contactMap.put(name, phoneNumberList);
    }

    public void printContacts() {
        // Создаем список записей, чтобы отсортировать их по убыванию количества
        // телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(contactMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " phone number(s)");
            for (String phoneNumber : entry.getValue()) {
                System.out.println(phoneNumber);
            }
            System.out.println();
        }
    }
}
