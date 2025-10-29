package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]

    // -------------------
    // Part 1
    // -------------------
    /**
     * Retrieves the current size of the names array.
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }

    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     * @param names The array of names to set.
     */
    public static void setNames(final String[] names) {
        NameRepository.names = (names == null) ? new String[0] : Arrays.copyOf(names, names.length);
    }

    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        names = new String[0];
    }

    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }

    // -------------------
    // Part 2
    // -------------------
    /**
     * Finds a name that matches the given fullName case-insensitively.
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        if (fullName == null) return null;
        for (String n : names) {
            if (n.equalsIgnoreCase(fullName)) return n;
        }
        return null;
    }

    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        if (fullName == null || fullName.isEmpty()) return false;
        if (find(fullName) != null) return false;

        String[] expanded = Arrays.copyOf(names, names.length + 1);
        expanded[expanded.length - 1] = fullName;
        names = expanded;
        return true;
    }

    // -------------------
    // Part 3
    // -------------------

    // small helpers: split on first space
    private static String firstOf(String fullName) {
        if (fullName == null) return "";
        int sp = fullName.indexOf(' ');
        return sp > 0 ? fullName.substring(0, sp) : "";
    }

    private static String lastOf(String fullName) {
        if (fullName == null) return "";
        int sp = fullName.indexOf(' ');
        return (sp > 0 && sp + 1 < fullName.length()) ? fullName.substring(sp + 1) : "";
    }

    /**
     * Find all names that match the given firstName.
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        if (firstName == null) return new String[0];

        int count = 0;
        for (String n : names) if (firstName.equalsIgnoreCase(firstOf(n))) count++;

        String[] result = new String[count];
        int i = 0;
        for (String n : names) if (firstName.equalsIgnoreCase(firstOf(n))) result[i++] = n;

        return result;
    }

    /**
     * Find all names that match the given lastName.
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        if (lastName == null) return new String[0];

        int count = 0;
        for (String n : names) if (lastName.equalsIgnoreCase(lastOf(n))) count++;

        String[] result = new String[count];
        int i = 0;
        for (String n : names) if (lastName.equalsIgnoreCase(lastOf(n))) result[i++] = n;

        return result;
    }

    /**
     * Updates a name in the names array from the original name to the updated name.
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        if (original == null || updatedName == null || updatedName.isEmpty()) return false;

        int idx = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(original)) { idx = i; break; }
        }
        if (idx == -1) return false; // original not found

        if (!original.equalsIgnoreCase(updatedName) && find(updatedName) != null) return false;

        names[idx] = updatedName;
        return true;
    }

    // -------------------
    // Part 4
    // -------------------
    /**
     * Removes a name from the names array, case-insensitively.
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {
        if (fullName == null) return false;

        int idx = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) { idx = i; break; }
        }
        if (idx == -1) return false;

        String[] shrunk = new String[names.length - 1];
        for (int i = 0, j = 0; i < names.length; i++) {
            if (i != idx) shrunk[j++] = names[i];
        }
        names = shrunk;
        return true;
    }
}
