import java.util.Scanner;

public class Bac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập phương trình dưới dạng: ax+b=c");
        String toan = sc.nextLine();

        while (!toan.matches("^[1-9\\s-][0-9]?+x[-+\\s]+[0-9\\s]+[=\\s]+[0-9\\s-]+$")) {
            System.out.println("sai dạng!");
            System.out.println("Nhập phương trình dưới dạng: ax+b=c");
            toan = sc.nextLine();
        }

        int[] abc = getNumber(toan);
        if (abc[0] == 0) System.out.println("không có x (0*x)");
        else System.out.println("x= " + (double)(abc[2] - abc[1]) / (abc[0]));

    }

    static int[] getNumber(String a) {
        int outRayIndex = 0;
        int[] outRay = new int[3];
        String output = "";
        String[] word = a.split("");
        for (String x : word) {
            if ((x.equals("-")) || (x.matches("^[0-9]+$"))) {
                output += x;
            } else {
                if (!output.equals("")) {
                    outRay[outRayIndex] = Integer.parseInt(output);
                    outRayIndex++;
                    output = "";
                }
            }
        }
        outRay[outRayIndex] = Integer.parseInt(output);
        return outRay;
    }
}
