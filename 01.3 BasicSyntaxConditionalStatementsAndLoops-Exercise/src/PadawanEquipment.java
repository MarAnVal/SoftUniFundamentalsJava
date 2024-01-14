import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· The amount of money George Lucas has – the floating-point number in the range [0.00…1,000.00].
        //· The count of students – integer in the range [0…100].
        //· The price of lightsabers for a single saber – the floating-point number in the range [0.00…100.00].
        //· The price of robes for a single robe – the floating-point number in the range [0.00…100.00].
        //· The price of belts for a single belt – the floating-point number in the range [0.00…100.00].
        double money = Double.parseDouble(input.nextLine());
        int students = Integer.parseInt(input.nextLine());
        double lightSabers = Double.parseDouble(input.nextLine());
        double robes = Double.parseDouble(input.nextLine());
        double belts = Double.parseDouble(input.nextLine());
        //George Lucas should buy 10% more lightsabers, rounded up to the next integer. Also, every sixth belt is free.
        double lightSabersExtra = Math.ceil(students * 1.1);
        int beltsFree = students / 6;
        double totalPrice = lightSabers * lightSabersExtra + robes * students + belts * (students - beltsFree);

        //· If the calculated price of the equipment is less or equal to the money George Lucas has:
        //"The money is enough - it would cost {the cost of the equipment}lv."
        //· If the calculated price of the equipment is more than the money George Lucas has:
        //"George Lucas will need {neededMoney}lv more."
        //· All prices must be rounded to two digits after the decimal point.
        if (totalPrice <= money){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - money);
    }
}
