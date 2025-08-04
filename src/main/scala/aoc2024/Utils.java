package aoc2024;

import kotlin.jvm.functions.Function1;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
  public static final Function1<String, String> AOC_URL_FUN = (day) -> "https://adventofcode.com/2024/day/" + day + "/input";
  
  // Method to send a GET request and return the response as a string
  public static String getInput(String url) throws IOException {
    // Create an OkHttpClient instance
    OkHttpClient client = new OkHttpClient();
    
    // Build the request
    Request request = new Request.Builder()
        .url(url)
        .addHeader("cookie", "session=53616c7465645f5fee93dd1f280d59eb3c24564246e17824fe109f06118b591a8281ec95b113412586934ac70b8e8fe124e4b7f42f6cabe3881a32dd17012c24")
        .get()
        .build();
    
    // Execute the request and get the response
    try (Response response = client.newCall(request).execute()) {
      // Ensure the response is successful (HTTP status code 200)
      if (!response.isSuccessful()) {
        throw new IOException("Unexpected code: " + response);
      }
      
      // Return the response body as a string
      return response.body().string();
    }
  }
  
  public static boolean checkIfFileExists(String filePath) {
    File file = new File(filePath);
    
    return file.exists();
  }
  
  public static void writeToFileIfNotExists(String filePath, String content) {
    // Create a File object for the specified file path
    File file = new File(filePath);
    
    try {
      // Check if the file exists
      if (!file.exists()) {
        // Create a new file and write the content
        if (file.createNewFile()) {
          try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("File created and content written successfully.");
          }
        } else {
          System.err.println("Failed to create the file.");
        }
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      // Handle potential I/O exceptions
      System.err.println("An error occurred: " + e.getMessage());
    }
  }
  
  public static String readFileToString(String filePath) throws IOException {
      // Read all bytes from the file and convert them to a string
      return new String(Files.readAllBytes(Paths.get(filePath)));
  }
  
  public static String loadContents(String day, String stars) throws IOException {
    String path = "C:\\Users\\Marius\\IdeaProjects\\leetcode\\src\\main\\scala\\aoc2024\\resources\\d" + day + "_s" + stars + ".txt";
    
    if (!checkIfFileExists(path)) {
      String response = getInput(AOC_URL_FUN.invoke(day));
      writeToFileIfNotExists("C:\\Users\\Marius\\IdeaProjects\\leetcode\\src\\main\\scala\\aoc2024\\resources\\d" + day + "_s" + stars + ".txt", response);
      return response;
    } else {
      return readFileToString(path);
    }
  }
  
}
