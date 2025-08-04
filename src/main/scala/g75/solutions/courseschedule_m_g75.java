package g75.solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class courseschedule_m_g75 {
  public static void main(String [] args) {
    int num_courses = 2;
    int[][] prerequisites = { {1,0},{0,1} };
    
    boolean result = canFinish(num_courses, prerequisites);
    System.out.println(result);
  }
  
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    List<List<Integer>> adj = new ArrayList<>(numCourses);
    
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }
    
    for (int[] prerequisite : prerequisites) {
      adj.get(prerequisite[1]).add(prerequisite[0]);
      indegree[prerequisite[0]]++;
    }
    
    Queue<Integer> queue = new LinkedList<>();
    // Push all the nodes with indegree zero in the queue.
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    
    int nodesVisited = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      nodesVisited++;
      
      for (int neighbor : adj.get(node)) {
        // Delete the edge "node -> neighbor".
        indegree[neighbor]--;
        if (indegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }
    
    return nodesVisited == numCourses;
  }
}
