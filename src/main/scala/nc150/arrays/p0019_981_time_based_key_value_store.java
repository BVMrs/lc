package nc150.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p0019_981_time_based_key_value_store {
  
  public static void main(String[] args) {
    Object[][] input = {{}, {"foo", "bar", 1}, {"foo", 1}, {"foo", 3}, {"foo", "bar2", 4}, {"foo", 4}, {"foo", 5}};
    int target = 4;
    
    TimeMap tm = new TimeMap();
    
    tm.set((String) input[1][0], (String) input[1][1], (int) input[1][2]);
    
    System.out.println(tm.get((String) input[2][0], (int) input[2][1]));
    System.out.println(tm.get((String) input[3][0], (int) input[3][1]));
    
    tm.set((String) input[4][0], (String) input[4][1], (int) input[4][2]);
    
    System.out.println(tm.get((String) input[5][0], (int) input[5][1]));
    System.out.println(tm.get((String) input[6][0], (int) input[6][1]));
  }
  
  private static class TimeMap {
    Map<String, ArrayList<Pair>> kv;
    
    public TimeMap() {
      kv = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
      if (kv.containsKey(key)) {
        ArrayList<Pair> pairs = kv.get(key);
        
        int pos = binarySearch(pairs, timestamp);
        
        pairs.add(pos + 1, new Pair(value, timestamp));
        
        kv.put(key, pairs);
      } else {
        ArrayList<Pair> arrayList = new ArrayList<>();
        arrayList.add(new Pair(value, timestamp));
        kv.put(key, arrayList);
      }
      
    }
    
    public String get(String key, int timestamp) {
      ArrayList<Pair> pairs = kv.get(key);
      
      int pos = binarySearch(pairs, timestamp);
      
      return pairs.get(pos).value;
      
    }
  }
  
  private static class Pair {
    String value;
    int ts;
    
    Pair(String value, int ts) {
      this.value = value;
      this.ts = ts;
    }
  }
  
  private static int binarySearch(List<Pair> arr, int targetTs) {
    int l = 0;
    int r = arr.size() - 1;
    
    while (l < r) {
      int mid = l + (r - l) / 2;
      
      if (arr.get(mid).ts < targetTs) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    
    return l;
  }
}
