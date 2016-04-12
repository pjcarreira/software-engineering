package ist.es.puzzles;

import java.util.Collections;

/**
 * Based on Effective Java item #41 Overriding is resolved at compile-time not resolved at
 * run-time.
 */
public class OverloadingVsOverriding2 {

    static class Wine {
       String name() {return "wine";}
    }

    static class RedWine extends Wine {
        @Override
        String name() {return "Red Wine";}
    }

    static class Champagne extends Wine {
        @Override
        String name() {return "Champagne";}
    }

    static class Classifier {
        public void classify(Wine w) {
            System.out.println(w.name());
        }
    };

    public static void main(String[] args) {
        final Wine[] wines = new Wine[] { new RedWine(), new Champagne() };

        final Classifier c = new Classifier();
        for (Wine w : wines) {
            c.classify(w);
        }
    }
}
