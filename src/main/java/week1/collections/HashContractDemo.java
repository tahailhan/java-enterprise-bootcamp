package week1.collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Demonstrates the critical contract between equals() and hashCode() in Java Collections.
 * Interview Topic: How HashMap and HashSet handle object uniqueness and bucket collisions.
 */
public class HashContractDemo {

    public static class BankAccount {
        private final String iban;
        private final String ownerFullName;

        public BankAccount(String iban, String ownerFullName) {
            this.iban = iban;
            this.ownerFullName = ownerFullName;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            BankAccount that = (BankAccount) obj;
            return Objects.equals(iban, that.iban);
        }

        @Override
        public int hashCode() {
            // Generates hash based on unique business key (IBAN)
            return Objects.hash(iban);
        }

        @Override
        public String toString() {
            return String.format("BankAccount{iban='%s', owner='%s'}", iban, ownerFullName);
        }
    }

    public static void main(String[] args) {
        Set<BankAccount> uniqueAccounts = new HashSet<>();

        BankAccount firstRecord = new BankAccount("TR330006100519786457841326", "Arthur Morgan");
        BankAccount duplicateRecord = new BankAccount("TR330006100519786457841326", "Arthur Morgan");

        uniqueAccounts.add(firstRecord);
        uniqueAccounts.add(duplicateRecord);

        System.out.println("Logical equality check: " + firstRecord.equals(duplicateRecord));
        System.out.println("Total unique accounts in Set (Expected: 1): " + uniqueAccounts.size());
        System.out.println("Stored Account: " + uniqueAccounts);
    }
}
