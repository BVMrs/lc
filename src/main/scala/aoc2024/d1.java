package aoc2024;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static aoc2024.Utils.*;

public class d1 {
  public static void main (String [] args) throws IOException {
    String inputs = loadContents("1", "1");
    System.out.println(inputs);
    
    List<Integer> l1 = new LinkedList<>();
    List<Integer> l2 = new LinkedList<>();
    
    String [] elements = inputs.split("\n");
    
    for (String element : elements) {
      String[] numbers = element.split("\s+");
      
      l1.add(Integer.parseInt(numbers[0]));
      l2.add(Integer.parseInt(numbers[1]));
    }
    
    l1.sort((e1, e2) -> {
      if (e1 > e2) return 1;
      if (e1 == e2) return 0;
      else return -1;
    });
    
    l2.sort((e1, e2) -> {
      if (e1 > e2) return 1;
      if (e1 == e2) return 0;
      else return -1;
    });
    
    List<Integer> l3 = new LinkedList<>();
    for (int i = 0; i < l1.size(); i++) {
      l3.add(Math.abs(l1.get(i) - l2.get(i)));
    }
    
    Optional<Integer> ans1 = l3.stream().reduce(Integer::sum);
    
    System.out.println(ans1.get());
    
    Map<Integer, Integer> secondListFrequencies = new HashMap<>();
    for (int i = 0; i < l2.size(); i++) {
      if (secondListFrequencies.containsKey(l2.get(i))) {
        secondListFrequencies.put(l2.get(i), secondListFrequencies.get(l2.get(i)) + 1);
      } else {
        secondListFrequencies.put(l2.get(i), 1);
      }
    }
    
    List<Integer> l4 = new LinkedList<>();
    for (int i = 0; i < l1.size(); i++) {
      if (secondListFrequencies.containsKey(l1.get(i))) {
        l4.add(l1.get(i) * secondListFrequencies.get(l1.get(i)));
      }
    }
    
    Optional<Integer> ans2 = l4.stream().reduce(Integer::sum);
    
    System.out.println(ans2.get());
  }
  

}
