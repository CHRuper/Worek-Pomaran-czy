import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean work = true;

        System.out.println("write a numbers ");
        while (work) {
            LinkedList<Integer> basket = new LinkedList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();
            command = command.replace(",", "");
            String[] commands = command.split(" ");

            if(command.equals("stop")){
                System.out.println("Program stop");
                work = false;
            }else if (!Sorter.isNumeric(command)) {
                for (String s : commands) {
                    try {
                        basket.add(Integer.parseInt(s));
                    } catch (NumberFormatException e) {
                        System.out.println("there is not numeric value! " + command);
                        throw new NumberFormatException();
                    }
                }
                Sorter.closeToZeroFinder(basket);
            } else {
                System.out.println("there is not numeric value! " + command);
            }
        }
    }

    //  100, 20, 10, -10, -32, 9, 13, 23, -69, 34, 90, 75, 32, 12, -2, 1, 10, 2, -2, 80};
}

