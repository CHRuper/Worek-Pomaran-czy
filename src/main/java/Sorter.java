import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sorter {
    public static ArrayList<Integer> closes = new ArrayList<>();

    public static void closeToZeroFinder(List<Integer> list) {
        if (!list.contains(0)) {
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i);
                if (a < 0) {
                    a *= -1;
                }
                if (i == 0) {
                    closes.add(list.get(0));
                }
                if (a == closes.get(0) || a == -closes.get(0)) {
                    closes.add(list.get(i));
                }
                if (a < closes.get(0) || a < closes.get(0) * -1) {
                    closes.clear();
                    closes.add(list.get(i));
                }
            }
        } else {
            System.out.println("Here is 0");
        }
        if (closes.size() > 1) {
            System.out.print("closest to zero numbers are ");
        } else if (closes.size() == 1) {
            System.out.print("closest to zero number is ");
        }
        for (Integer integer : closes) {
            System.out.print(integer + " ");
        }
        System.out.println();
        closes.clear();
    }

    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

}
