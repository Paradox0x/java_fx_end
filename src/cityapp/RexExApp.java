package cityapp;

import jdk.nashorn.internal.objects.NativeString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexExApp {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d\\d-\\d\\d\\d");
        Matcher matcher = pattern.matcher("41-300");
        System.out.println(matcher.matches());

        Pattern pattern2 = Pattern.compile("\\D\\D-\\d\\d\\d");
        Matcher matcher2 = pattern2.matcher("AB-300");

        System.out.println(matcher2.matches());

        Pattern pattern3 = Pattern.compile("\\w+");
        Matcher matcher3 = pattern3.matcher("Abc123");

        System.out.println(matcher3.matches());

        Pattern pattern4 = Pattern.compile("\\w+\\s\\w+");
        Matcher matcher4 = pattern4.matcher("Abc 123");

        System.out.println(matcher4.matches());

        Pattern pattern5 = Pattern.compile("\\b\\b\\s+");
        Matcher matcher5 = pattern5.matcher("asd");

        //PODAJ KOD POCZTOWY
        System.out.println("podaj kod pocztowy");
        Pattern pattern6 = Pattern.compile("\\d{2}-\\d{3}");
        Scanner scanner = new Scanner(System.in);
        String input = (scanner).nextLine();
        Matcher matcher6 = pattern6.matcher(input);

        while(matcher.find()) {
            System.out.println(matcher6.start());
            System.out.println(input.substring(matcher6.start(), matcher6.end()));
        }
        System.out.println(matcher6.matches());

        System.out.println("a teraz powiedz ile umie szymon?");

        Pattern pattern7 = Pattern.compile("\\D{8}");
        String input2 = (scanner).nextLine();
        Matcher matcher7 = pattern7.matcher(input2);

        System.out.println(matcher7.matches());

    }
    List<String> getZipCode(String input){
        if(input == null){
            return Collections.emptyList();
        }
        Pattern pattern = Pattern.compile("\\d{2}-\\d");
        Matcher matcher = pattern.matcher(input);
        List<String> result = new ArrayList<>();

        while (matcher.find()){
            result.add(input.substring(matcher.start(), matcher.end()));
        }
        return result;
    }
}
