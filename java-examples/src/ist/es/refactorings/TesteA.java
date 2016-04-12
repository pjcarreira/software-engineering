package ist.es.refactorings;

public abstract class TesteA {

    public abstract void teste() ;
}

class MyException extends Exception {
    
}

class TesteB extends
        TesteA {

    @Override
    public void teste() throws MyException {
        // TODO Auto-generated method stub

    }

}
