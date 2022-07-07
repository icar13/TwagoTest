import java.util.Scanner;

public class TwagoTest {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        // First is X and Second Value is Y
        String firstLine = sc.nextLine();
        String[] firstNumbers = firstLine.split(" ");
        int x = 0;
        int y = 0;
        boolean validXY = false;

        // While the X and Y is not correct, we ask to return write the numbers
        while (!validXY) {
            validXY = validXY(firstNumbers);
            if (!validXY) {
                firstLine = sc.nextLine();
                firstNumbers = firstLine.split(" ");
            }
        }

        
        x = Integer.parseInt(firstNumbers[0]);
        y = Integer.parseInt(firstNumbers[1]);
        
        int[] arrayOfResults = new int[x];

        // Method to calculate the max value of the summatory of the arrays.
        System.out.println(calculate(sc, x, y, arrayOfResults));
        sc.close();

    }

    private static int calculate(Scanner sc, int x, int y, int[] arrayOfResults) {
        int count = 0;
        int result = 0;
        boolean numbersValidated = false;

        while (count < y) {

            String secondLine = sc.nextLine();
            String[] numbers = secondLine.split(" ");
            
            // While the i, j and k is not correct, we ask to return write the numbers
            while (!numbersValidated) {

                numbersValidated = validIJK(numbers, x);
                if (!numbersValidated) {
                    secondLine = sc.nextLine();
                    numbers = secondLine.split(" ");
                }

            }
            //After we've validated numbers, parse de the String[] to set i,j && k
            int i = Integer.parseInt(numbers[0]);
            int j = Integer.parseInt(numbers[1]);
            int k = Integer.parseInt(numbers[2]);

            // Traverse i to j and plus the index of arrayOfResults
            for (int index = i; index <= j; index++) {
                arrayOfResults[index-1] += k;
            }

            count++;
        }

        // Return the max value of array with the function mat
        for (int number : arrayOfResults) {
            result = Math.max(number, result);
        }

        return result;
    }

    private static boolean validIJK(String[] numbers, int x) {

        boolean validOk = true;
        int i, j, k;

        // Check if is a number
        try {
            i = Integer.parseInt(numbers[0]);
            j = Integer.parseInt(numbers[1]);
            k = Integer.parseInt(numbers[2]);

            //Aplicate the constraints and return if is not valid a error message after we will ask to return insert numbers
            if (i < 1 || i > j || i > x) {
                System.out.println("Error: The program cannot accept i < 1  && i > j && i > x");
                validOk = false;
            } else if (j < 1 || j > x) {
                System.out.println("Error: The program cannot accept j < 1 && j > x");
                validOk = false;
            } else if (k < 0 || k > Math.pow(10, 9)) {
                System.out.println("Error: The program cannot accept k < 0 && k > 10^9");
                validOk = false;
            }
        } catch (NumberFormatException e) {
            System.out.print("Error: Please insert a correct number");
            validOk = false;
        }

        return validOk;
    }

    private static boolean validXY(String[] first) {
        int x;
        int y;

        boolean valid = true;
        try {
            x = Integer.parseInt(first[0]);
            y = Integer.parseInt(first[1]);
            if (x < 3 || x > Math.pow(10, 7)) {
                System.out.println("Error: The program cannot accept x <= to 3 and  x >= to 10^7");
                valid = false;
            } else if (y < 1 || y > (2 * Math.pow(10, 5))) {
                System.out.println("Error: The program cannot accept y <= to 1 and y >= to 2* 10^5");
                valid = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please insert a correct number");
            valid = false;
        }
        return valid;
    }

}
