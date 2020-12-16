/* Dhruv Sharma, Jim Fahey, Jack Greco
10/01/2020
12/15/2020
This is the driver file for PostfixCalculator.java.
*/

import java.io.*;


public class CalcTest {
    public static void main(String[] args) throws IOException {
        PostfixCalculator p = new PostfixCalculator();

        InputStreamReader reader = new InputStreamReader(new FileInputStream("src/tests.txt"));
        BufferedReader readTests = new BufferedReader(reader); //allows the tests.txt file to be read

        FileWriter writer = new FileWriter("src/log.txt", true);
        BufferedWriter writeLog = new BufferedWriter(writer);


        String st = readTests.readLine();
        System.out.println(st);


        p.setEquation(st.length(), st);
        writeLog.write(st + " = " + p.Calculate() + "\n");
        writeLog.close();

    }
}
