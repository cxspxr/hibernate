package lab4;

import lab4.model.Length;
import lab4.service.LengthService;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;
import java.util.Date;


public class App {
    private static LengthService lengthService = new LengthService();
    private static Scanner in = new Scanner(System.in);
    private static String user;

    private static void menu() {
        System.out.println("1. Calculate (Create+Store)");
        System.out.println("2. Update stored length");
        System.out.println("3. Delete all lengths");
        System.out.println("4. Delete length by id");
        System.out.println("5. Show all stored lengths");
        System.out.println("6. Show an existing length");
        System.out.println("0. Exit");
    }

    private static Integer getId() {
        System.out.println("Enter the ID:");

        return in.nextInt();
    }

    private static Double getOriginalValue() {
        System.out.println("Enter an original value:");

        return in.nextDouble();
    }

    private static String getOriginalType() {
        System.out.println("Enter an original type: \"cm\" / \"mm\" / \"m\":");

        return in.next();
    }

    private static String getConvertedType() {
        System.out.println("Enter a type to convert to: \"cm\" / \"mm\" / \"m\":");

        return in.next();
    }

    private static String getUsername() {
        System.out.println("Enter your username:");

        return in.next();
    }

    private static Double evaluate(Double value, String originalType, String typeToConvertTo) {
        Double convertedValue = 0.0;

        if (originalType.equals("cm")) {
            if (typeToConvertTo.equals("mm")) {
                convertedValue = value * 10;
            } else if (typeToConvertTo.equals("cm")) {
                convertedValue = value;
            } else if (typeToConvertTo.equals("m")) {
                convertedValue = value / 100;
            }
        } else if (originalType.equals("mm")) {
            if (typeToConvertTo == "mm") {
                convertedValue = value;
            } else if (typeToConvertTo.equals("cm")) {
                convertedValue = value / 10;
            } else if (typeToConvertTo.equals("m")) {
                convertedValue = value / 1000;
            }
        } else if (originalType.equals("m")) {
            if (typeToConvertTo.equals("mm")) {
                convertedValue = value * 1000;
            } else if (typeToConvertTo.equals("cm")) {
                convertedValue = value * 100;
            } else if (typeToConvertTo.equals("m")) {
                convertedValue = value;
            }
        }

        return convertedValue;
    }

    private static void calculate() {
        double value = 0.0,  convertedValue = 0.0;
        String originalType = "", typeToConvertTo = "";

        value = getOriginalValue();
        originalType = getOriginalType();
        typeToConvertTo = getConvertedType();

        convertedValue = evaluate(value, originalType, typeToConvertTo);

        System.out.println(value + originalType + " equals to " + convertedValue + typeToConvertTo + "\n");

        Integer id = getId();

        Length length = new Length(id, value, convertedValue, originalType, typeToConvertTo, user, new Date());

        lengthService.persist(length);

        System.out.println("Length stored is " + length.toString());
    }

    private static void update() {
        System.out.println("Enter an existing ID");
        Integer id = in.nextInt();
        Double originalValue, convertedValue;
        String originalType, convertedType, user;

        Length length = lengthService.findById(id);

        originalValue = getOriginalValue();
        convertedType = getConvertedType();
        originalType = getOriginalType();
        user = getUsername();

        convertedValue = evaluate(originalValue, originalType, convertedType);

        length.setOriginal(originalValue);
        length.setUser(user);
        length.setOriginal_type(originalType);
        length.setConverted_type(convertedType);
        length.setConverted(convertedValue);

        lengthService.update(length);
        System.out.println("Length updated is =>" + lengthService.findById(length.getId()).toString());
    }

    private static void deleteAll() {
        lengthService.deleteAll();

        System.out.println("All lengths have been deleted");
    }

    private static void deleteById() {
        Integer id = getId();

        lengthService.delete(id);

        System.out.println("A record with id " + id + " has been deleted successfully");
    }

    private static void listAll() {
        List<Length> lengths = lengthService.findAll();
        System.out.println("Lengths found are :");
        for (Length b : lengths) {
            System.out.println("-" + b.toString());
        }
    }

    private static void listById() {
        Integer id = getId();
        Length length = lengthService.findById(id);
        System.out.println("Length found with id " + id + " is =>" + length.toString());
    }

    public static void main(String[] args) {
        String choice;

        System.out.println("----WELCOME TO LENGTH CONVERTATOR----\n");

        System.out.println("Enter your username:");
        user = in.next();

        do {
            menu();
            choice = in.next().trim();

            if (choice.equals("1")) {
                calculate();
            } else if (choice.equals("2")) {
                update();
            } else if (choice.equals("3")) {
                deleteAll();
            } else if (choice.equals("4")) {
                deleteById();
            } else if (choice.equals("5")) {
                listAll();
            } else if (choice.equals("6")) {
                listById();
            }


        } while (!choice.equals("0"));


    }
}
