import java.util.Scanner;

public class solution {
    public static final char[] massiv = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        String number = scan.nextLine();
        System.out.print("Enter the first system of number: ");
        int system1 = scan.nextInt();
        System.out.print("Enter the second system of number: ");
        int system2 = scan.nextInt();
        String result = coverter(number, system1, system2);
        System.out.println("The number in " + system1 + " is equal to " + number +
                ", in " + system2 + " it is equal to " + result);

    }
    public static String coverter(String num, int system1, int system2) {
        int transfer1 = 0;
        String transfer2 = "";
        boolean flag = false;
        for (int i = 0; i < num.length(); i++) {
            flag = false;
            for (int j = 0; j < system1; j++) {
                if (num.charAt(i) == massiv[j]) {
                    flag = true;
                }
            }
            if (flag == false) return "error";
        }
        if (system1 == system2) return num;
        if (num.equals("")) return "error";
        for (int i = 0; i < num.length(); i++) {
            int index = 0;
            while (massiv[index] != num.charAt(i)) {
                index++;
            }
            transfer1 = transfer1 * system1 + index;
        }

        while (transfer1 != 0) {
            transfer2 = massiv[(transfer1 % system2)] + transfer2;
            transfer1 = transfer1 / system2;
        }
        return transfer2;
    }
}
