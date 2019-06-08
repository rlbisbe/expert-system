package net.rlbisbe.expert;

class Option {

    private static final String truthy = "yes";
    private static final String falsy = "no";

    static String getOptions() {
        return String.format("[%s/%s]:", truthy, falsy);
    }

    static boolean parse(String input) {
        if (input.toLowerCase().equals(truthy)) {
            return true;
        } else if (input.toLowerCase().equals(falsy)) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
