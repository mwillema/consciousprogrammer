import com.sun.tools.doclets.Taglet;
import com.sun.javadoc.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * A Taglet representing @invariant.
 *
 * Here is the command to compile this class:
 *     javac -cp $JAVA_HOME/lib/tools.jar Invariant.java
 *
 * @author Marco Willemart
 * @version 1.0
 * @since 2013-02-25
 */
public class Invariant implements Taglet {

    private static final String NAME = "invariant";
    private static final String HEADER = "Abstract Invariant:";

    /**
     * Return the name of this custom tag.
     */
    public String getName() {
        return NAME;
    }

    /**
     * Will return false since <code>@specfield</code>
     * cannot be used in field documentation.
     */
    public boolean inField() {
        return false;
    }

    /**
     * Will return false since <code>@specfield</code>
     * cannot be used in constructor documentation.
     */
    public boolean inConstructor() {
        return false;
    }

    /**
     * Will return false since <code>@specfield</code>
     * cannot be used in method documentation.
     */
    public boolean inMethod() {
        return false;
    }

    /**
     * Will return false since <code>@specfield</code>
     * cannot be used in overview documentation.
     */
    public boolean inOverview() {
        return false;
    }

    /**
     * Will return false since <code>@specfield</code>
     * cannot be used in package documentation.
     */
    public boolean inPackage() {
        return false;
    }

    /**
     * Will return true since <code>@specfield</code>
     * can be used in type documentation (classes or interfaces).
     */
    public boolean inType() {
        return true;
    }

    /**
     * Will return false since <code>@specfield</code>
     * is not an inline tag.
     */

    public boolean isInlineTag() {
        return false;
    }

    /**
     * Register this Taglet.
     * @param tagletMap  the map to register this tag to.
     */
    public static void register(Map tagletMap) {
       Invariant tag = new Invariant();
       Taglet t = (Taglet) tagletMap.get(tag.getName());
       if (t != null) {
           tagletMap.remove(tag.getName());
       }
       tagletMap.put(tag.getName(), tag);
    }

    /**
     * Given the <code>Tag</code> representation of this custom
     * tag, return its string representation.
     * @param tag   the <code>Tag</code> representation of this custom tag.
     */
    public String toString(Tag tag) {
        StringTokenizer s = new StringTokenizer(tag.text(), " ");
        String text = "<code>" + s.nextToken() + "</code>";
        while (s.hasMoreTokens()) {
            text += " " + s.nextToken();
        }
        return "<DT><B>" + HEADER + "</B><DD>" + text + "</DD>\n";
    }

    /**
     * Given an array of <code>Tag</code>s representing this custom
     * tag, return its string representation.
     * @param tags the array of <code>Tag</code>s representing of this custom
     * tag.
     */
    public String toString(Tag[] tags) {
        if (tags.length == 0) {
            return null;
        }
        String result = "\n<DT><B>" + HEADER + "</B><DD>";
        for (int i = 0; i < tags.length; i++) {
            StringTokenizer s = new StringTokenizer(tags[i].text(), " ");
            String text = "<li>";
            while (s.hasMoreTokens()) {
                text += " " + s.nextToken();
            }
            text += "</li>";
            result += text;
        }
        return result + "</DD>\n";
    }
}
