package se.lexicon;

public class App {
    public static void main(String[] args) {

        System.out.println("=== NameRepository Demo ===\n");

        // ---- PART 1: Basic setup ----
        System.out.println("Initial size: " + NameRepository.getSize());

        NameRepository.setNames(new String[]{
                "Erik Svensson",
                "Anna Karlsson",
                "Sara Svensson"
        });
        System.out.println("After setNames: " + NameRepository.getSize());

        System.out.println("All names: ");
        for (String name : NameRepository.findAll()) {
            System.out.println(" - " + name);
        }

        // ---- PART 2: find & add ----
        System.out.println("\nFind 'Erik Svensson': " + NameRepository.find("Erik Svensson"));
        System.out.println("Find 'No Name': " + NameRepository.find("No Name"));

        System.out.println("\nAdd duplicate 'Erik Svensson': " + NameRepository.add("Erik Svensson"));
        System.out.println("Add new 'Mehrdad Javan': " + NameRepository.add("Mehrdad Javan"));
        System.out.println("Size after add: " + NameRepository.getSize());

        // ---- PART 3: findByFirstName, findByLastName, update ----
        System.out.println("\nFind by first name 'Erik':");
        for (String name : NameRepository.findByFirstName("Erik")) {
            System.out.println(" - " + name);
        }

        System.out.println("\nFind by last name 'Svensson':");
        for (String name : NameRepository.findByLastName("Svensson")) {
            System.out.println(" - " + name);
        }

        System.out.println("\nUpdate 'Anna Karlsson' → 'Anna Nilsson': " +
                NameRepository.update("Anna Karlsson", "Anna Nilsson"));
        System.out.println("Update to existing name (should fail): " +
                NameRepository.update("Sara Svensson", "Erik Svensson"));

        System.out.println("\nAll names after update:");
        for (String name : NameRepository.findAll()) {
            System.out.println(" - " + name);
        }

        // ---- PART 4: remove ----
        System.out.println("\nRemove 'Sara Svensson': " + NameRepository.remove("Sara Svensson"));
        System.out.println("Remove non-existing 'Ali Baba': " + NameRepository.remove("Ali Baba"));

        System.out.println("\nAll names after remove:");
        for (String name : NameRepository.findAll()) {
            System.out.println(" - " + name);
        }

        // ---- Clear ----
        NameRepository.clear();
        System.out.println("\nAfter clear, size: " + NameRepository.getSize());

        System.out.println("\n Test by Zackaria Azzoug");
    }
}
