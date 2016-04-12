package ist.es.refactorings;

public class SimplifyNegation {

    static class MyItem {
        boolean notFound;
        public boolean isNotFound() {
            return notFound;
        }
    }
    
    public static void main(String[] args) {
        MyItem item = new MyItem();
        
        if (!item.isNotFound()) {
            // do something
        }

        /*
         * if ( item.isFound() )
         */
    }
   }
