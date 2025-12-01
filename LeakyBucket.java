import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bucketSize, leakRate, n;
        System.out.print("Enter bucket size: ");
        bucketSize = sc.nextInt();

        System.out.print("Enter leak rate (packets per second): ");
        leakRate = sc.nextInt();

        System.out.print("Enter number of incoming packet groups: ");
        n = sc.nextInt();

        int[] incoming = new int[n];
        System.out.println("Enter incoming packets for each second:");
        for (int i = 0; i < n; i++) {
            incoming[i] = sc.nextInt();
        }

        int stored = 0;
        System.out.println("\nSecond\tIncoming\tStored\tSent\tDropped");

        for (int i = 0; i < n; i++) {
            int drop = 0;

            // Add incoming packets
            stored += incoming[i];

            // Check overflow
            if (stored > bucketSize) {
                drop = stored - bucketSize;
                stored = bucketSize;
            }

            // Leak packets
            int sent = Math.min(leakRate, stored);
            stored -= sent;

            System.out.println((i + 1) + "\t\t" + incoming[i] + "\t\t" + 
                               (stored + sent) + "\t" + sent + "\t" + drop);
        }

        sc.close();
    }
}
