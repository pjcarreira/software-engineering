package ist.es.puzzles;

/**
 * Based on Effective Java item #41 Overriding is resolved at compile-time not resolved at
 * run-time.
 */
public class OverloadingVsOverriding1 {

    static class Wine {
    }

    static class RedWine extends Wine {
    }

    static class Champagne extends Wine {
    }

    static class Classifier {
        public void classify(Wine w) {
            System.out.println("Wine");
        }

        public void classify(RedWine w) {
            System.out.println("Red Wine");
        }

        public void classify(Champagne w) {
            System.out.println("Champagne");
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
