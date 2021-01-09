import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        
        int lefToRightSum=0, rightToLeftSum=0, n, result;
        
        n = arr.size();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(i == j){
                    lefToRightSum+=arr.get(i).get(i);
                }
                if(j==n-1-i){
                    rightToLeftSum+=arr.get(i).get(j);
                }
            }
        }
        
        if(rightToLeftSum > lefToRightSum) 
            result = rightToLeftSum - lefToRightSum;
        else 
            result = lefToRightSum - rightToLeftSum;
        
        return result;
    
        }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}