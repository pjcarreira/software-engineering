package ist.es.equals;

import java.util.ArrayList;
import java.util.List;

/**
 * A case insensitive string implementation. This implementation does not work because it
 * violates symmetry implementing equality on one direction only. 
 * s.equals(cis) returns false, and therefore violates symmetry.ì
 */
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    public static void main(String[] args) {
        final CaseInsensitiveString cis = new CaseInsensitiveString("Portuguese");
        String s = "portuguese";

        System.out.println(cis.equals(s));

        final List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
        list.add(cis);
        
        System.out.println(list.contains(s));
    }
}
