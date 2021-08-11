import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotel_Reservation_system {

    private static Hotel lake, bridge, ridge;

    public static void main(String[] args) throws IOException {

        System.out.println("Enter date  ex. 16Mar2020(mon)");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String date = bf.readLine();

        //setting values for lakewood
        lake = new Hotel("Lakewood");
        lake.setRegularWeekDay(210);

        //setting values for bridgewood
        bridge = new Hotel("Bridgewood");
        bridge.setRegularWeekDay(360);

        //setting values for ridgewood
        ridge = new Hotel("Ridgewood");
        ridge.setRegularWeekDay(260);


        int cost_lake = 0, cost_bridge = 0, cost_ridge = 0;
        int day_index_start = 0, day_index_end = 0;

        while (day_index_start != -1) {
            day_index_start = date.indexOf("(", day_index_start + 1);
            day_index_end = date.indexOf(")", day_index_end + 1);

            if (day_index_start != -1) {
                cost_lake += lake.getRegularWeekDay();
                cost_bridge += bridge.getRegularWeekDay();
                cost_ridge += ridge.getRegularWeekDay();
            }
        }

        System.out.println("\nLakewood : "+cost_lake+"$");
        System.out.println("Bridgewood : "+cost_bridge+"$");
        System.out.println("Ridgewood : "+cost_ridge+"$");

        String result = min(cost_lake, cost_bridge, cost_ridge);
        System.out.println("Cheapest price is of "+result);
    }

    private static String min(int a, int b, int c) {
        if (a < b && a < c) {
            return lake.getHotelName();
        } else if (b < a && b < c) {
            return bridge.getHotelName();
        } else if (c < a && c < b) {
            return ridge.getHotelName();
        } else if (a == b || b == c) {
            return bridge.getHotelName();
        } else if (c == a) {
            return ridge.getHotelName();
        } else {
            return lake.getHotelName();
        }
    }
}
 



