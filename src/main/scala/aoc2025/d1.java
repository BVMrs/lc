package aoc2025;

import java.io.IOException;
import java.util.stream.Stream;

import static aoc2025.Utils.loadContents;

public class d1 {
  public static void main (String [] args) throws IOException {
    String inputs = loadContents("1", "1", "2025");
    System.out.println(inputs);
    
//    inputs = "L68\n" +
//        "L30\n" +
//        "R48\n" +
//        "L5\n" +
//        "R60\n" +
//        "L55\n" +
//        "L1\n" +
//        "L99\n" +
//        "R14\n" +
//        "L82";
//
    String [] elements = inputs.split("\n");
    Dial dial_1s = new Dial(50, 0);
    Dial dial_2s = new Dial(50, 0);
    

    Stream.of(elements)
        .map(Element::apply)
        .forEach(dial_1s::turn_1s);
    
    System.out.println("-----------------");
    
    Stream.of(elements)
        .map(Element::apply)
        .forEach(dial_2s::turn_2s);
    
    
    System.out.println("ans 1s: " + dial_1s.ans);
    System.out.println("ans 2s: " + dial_2s.ans);
  }
  
  record Element(Direction dir, int value) {
    
    static Element apply(String str) {
      return new Element(
          parseDirection(str.charAt(0)),
          Integer.parseInt(str.substring(1))
      );
    }
    
    static Direction parseDirection(char input) {
      return switch(input) {
        case 'R' -> Direction.RIGHT;
        case 'L' -> Direction.LEFT;
        default -> throw new RuntimeException();
      };
    }
  }
  
  static class Dial {
    int value;
    int ans;
    
    Dial(int value, int ans) {
      this.value = value;
      this.ans = ans;
    }
    
    void turn_1s(Element elem) {
      int newValue = switch (elem.dir) {
        case LEFT -> {
          int tmp = value - elem.value % 100;
          
          if (tmp < 0) tmp += 100;
          
          yield tmp;
        }
        case RIGHT -> (value + elem.value) % 100;
      };
      
      
      this.ans = newValue == 0 ? ans + 1 : ans;
      this.value = newValue;
      
      String warn = (this.value < 0) ? "!!!" : "";
      System.out.println(warn + "nv: " + this.value + "| ans: " + this.ans + "| elem: " + elem);
    }
    
    void turn_2s(Element elem) {
      int tmpVal = elem.value;
      
      while (tmpVal >= 100) {
        tmpVal = tmpVal - 100;
        this.ans++;
      }
      
      int newValue = switch (elem.dir) {
        case LEFT -> {
          int tmp = this.value - tmpVal;
          if (tmp < 0) {
            if (this.value != 0) this.ans++;
            tmp += 100;
          }

          yield tmp;
        }
        case RIGHT -> {
          int sum = this.value + tmpVal;
          if (sum > 100 && this.value != 0) this.ans++;
          yield sum % 100;
        }
      };
      
      
      if (newValue == 0  && elem.value > 0) {
        this.ans++;
      }
      
      this.value = newValue;
      
      String warn = (this.value < 0) ? "!!!" : "";
      System.out.println(warn + "nv:\t" + this.value + "\t| ans:\t" + this.ans + "| elem:\t" + elem);
    }
  }
  
  public enum Direction {
    LEFT,
    RIGHT;
  }
  
}
