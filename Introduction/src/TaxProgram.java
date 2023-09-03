import java.util.Scanner;
public class TaxProgram {
    public static void main(String[] args) {
        double income, fedTax, provTax, base, deductions, totalTax;
        int dependents;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your taxable income: ");
        income = input.nextDouble();

        System.out.print("Please enter your number of dependents: ");
        dependents = input.nextInt();
        System.out.println();

        fedTax = 0.0;
        provTax = 0.0;

        if (income <= 29590){
            fedTax = Math.round(0.17 * income *100);
            fedTax = fedTax / 100;
        }
        else if (income >= 29590.01 && income <= 59179.99){
            fedTax = Math.round((0.17 * 29590 + 0.26 * (income-29590)) * 100);
            fedTax = fedTax / 100;
        }
        else if (income >= 59180) {
            fedTax = Math.round((0.17 * 29590 + 0.26 * 29590 + 0.29 * (income - 59180)) * 100);
            fedTax = fedTax / 100;
        }

        /*System.out.println(fedTax);
        * provTax = 0.425 * fedTax + (160.5 + 328 * dependents) ;
        * */
        base = 0.425 * fedTax;
        deductions = 160.5 + 328 * dependents;
        if (base > deductions){
            provTax = base - deductions;
        }
        totalTax = fedTax + provTax;


        System.out.println("Here is your tax breakdown:\n");
        System.out.println(String.format("%-14s%14s","Income", strFormat(income)));
        System.out.println(String.format("%-14s%14d","Dependants", dependents));
        System.out.println("----------------------------");
        System.out.println(String.format("%-14s%14s","Federal Tax", strFormat(fedTax)));
        System.out.println(String.format("%-14s%14s","Provincial Tax", strFormat(provTax)));
        System.out.println("============================");
        System.out.println(String.format("%-14s%14s","Total Tax", strFormat(totalTax)));

    }
    public static String strFormat(double a){
        String result = String.format("%s%,.2f", "$", a);
        return result;
    }
}
