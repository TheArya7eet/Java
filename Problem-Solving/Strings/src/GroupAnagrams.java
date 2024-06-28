import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            
            // Sort the ith string element of the array
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String sortedStr = new String(s);

            // Check if the map does not contain the sorted string element
            if(!map.containsKey(sortedStr)){
                // Put the sorted string element in the map and an empty list as its corresponding value
                map.put(sortedStr, new ArrayList<>());
            }

            // Add the ith string element to the list
            map.get(sortedStr).add(strs[i]);
        }

        map.forEach((key, value) -> {
            ans.add(value);
        });

        return ans;
    }
}
