package streams.streamsOfPrimitives;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class CalculateAverageSalary {

    private static double calcAverageSalary(Collection<Integer> salaries) {
        // write your code here
        return salaries.stream().mapToInt(x -> x).average().getAsDouble();
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String input = scanner.nextLine();
        String input = "4500 5200 3900";
        List<Integer> salaries = Arrays.stream(input.split("\\s+"))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

        System.out.println(calcAverageSalary(salaries));
    }
}

/*
Imagine that you need to calculate the average (monthly) salary in a company where you work at this moment.

To do this, you need to implement the calcAverageSalary method which takes a list of salaries and calculate the value.

It is guaranteed that the company has at least one employee.

Please, do not round the result.

Sample Input 1:
4500 5200 3900

Sample Output 1:
4533.333333333333
 */