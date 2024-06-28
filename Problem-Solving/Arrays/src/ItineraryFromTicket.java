
import java.util.HashMap;
import java.util.Map;

public class ItineraryFromTicket{
    // Find the starting point
    private static void printResult(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        tickets.forEach((key, value) -> {
            // Put the value of tickets as key and the key of tickets as the value in the revMap
            revMap.put(value, key);
        });

        String start = null;

        // For every key of tickets, check if it is in revMap
        for(Map.Entry<String, String> entry: tickets.entrySet()){
            // If it is not present in revMap, we have our starting point
            if(!revMap.containsKey(entry.getKey())){
                start = entry.getKey();
                break;
            }
        }

        if(start == null){
            System.out.println("Invalid input");
            return;
        }

        String to = tickets.get(start);
        while(to != null){
            System.out.println(start + "->" + to);
            start = to;
            to = tickets.get(start);
        }
    }


    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        printResult(tickets);

    }
}