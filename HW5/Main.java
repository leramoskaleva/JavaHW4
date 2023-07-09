package HW5;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Паша", "344-7342");
        phoneBook.addContact("Маша", "344-7040");
        phoneBook.addContact("Паша", "344-7006");
        phoneBook.addContact("Маша", "344-5678");

        phoneBook.printContacts();
    }
}