package Exam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String regexBarcode = "(\\@\\#+)(?<word>[A-Z][a-zA-Z0-9]{4,}[A-Z])(\\@\\#+)";
            Pattern pattern = Pattern.compile(regexBarcode);
            Matcher matcher = pattern.matcher(line);
            String productGroup = "";
            boolean invalid = true;
            if (matcher.find()) {
                String barcode = matcher.group();
                if (line.length() == barcode.length()) {
                    String regexDigits = "[0-9]+";
                    Pattern patternDigits = Pattern.compile(regexDigits);
                    Matcher matcherDigits = patternDigits.matcher(barcode);

                    while (matcherDigits.find()) {
                        String digits = matcherDigits.group();
                        productGroup = String.format("%s%s", productGroup, digits);
                    }
                    if (productGroup.isEmpty()) {
                        productGroup = "00";
                    }
                }
                invalid = false;
            }
            if (invalid) {
                System.out.println("Invalid barcode");
            } else {
                System.out.printf("Product group: %s%n", productGroup);
            }
        }
    }
}
