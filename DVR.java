import java.util.*;

class Router {
    int[] dist = new int[20];
    int[] nextHop = new int[20];
}
public class DVR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        Router[] rt = new Router[20];
        for (int i = 0; i < 20; i++) rt[i] = new Router();

        int[][] cost = new int[20][20];
        int n;

        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();

        System.out.println("\nEnter cost matrix (use 999 for infinity):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (i == j) cost[i][j] = 0;

                rt[i].dist[j] = cost[i][j];
                rt[i].nextHop[j] = j;
            }
        }

        boolean change;
        do {
            change = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (rt[i].dist[j] > cost[i][k] + rt[k].dist[j]) {
                            rt[i].dist[j] = cost[i][k] + rt[k].dist[j];
                            rt[i].nextHop[j] = k;
                            change = true;
                        }
                    }
                }
            }
        } while (change);

        // print results
        System.out.println("\n--- Distance Vector Tables ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nRouting table for node " + i + ":");
            System.out.println("Destination\tCost\tNextHop");
            for (int j = 0; j < n; j++) {
                System.out.println(j + "\t\t" + rt[i].dist[j] + "\t" + rt[i].nextHop[j]);
            }
        }

        sc.close();

	}

}
