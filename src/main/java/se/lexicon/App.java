package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());System.out.println("Find 'Erik Svensson': " + NameRepository.find("Erik Svensson"));
        System.out.println("Add duplicate 'Erik Svensson': " + NameRepository.add("Erik Svensson"));
        System.out.println("Add new 'Sara Svensson': " + NameRepository.add("Sara Svensson"));
        System.out.println("Size after add: " + NameRepository.getSize());
        System.out.println("Remove 'Mehrdad Javan': " + NameRepository.remove("Mehrdad Javan"));
        System.out.println("Final size: " + NameRepository.getSize());

    }
}
