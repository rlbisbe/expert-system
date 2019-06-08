package net.rlbisbe.expert;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class UI {

    public static void main(String[] args) {
        ExpertSystem system = new ExpertSystem(new YamlLoader());

        Scanner scanner = new Scanner(in);

        while (!system.isDone()) {
            out.printf("%s %s ", system.getMessage(), Option.getOptions());
            system.answer(Option.parse(scanner.nextLine()));
        }

        scanner.close();
        out.println(system.getMessage());
    }
}

