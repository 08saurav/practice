package flyweight.shivendra;

import flyweight.shivendra.Character;
import java.util.HashMap;

/*                             -------------------- Flyweight Design Pattern -------------------------
 * 1. Suppose there are large number of objects of some type and they share too much data in common and we know for sure
 *    they will always share that data.
 * 2. Issue is it will take log of memory in heap memory. How to minimize that ?
 * 3. Can we store that data in common static place and share it will other objects and reuse ?
 */

/*                            -------------------- Components of Flyweight ------------------------
 * 1. Abstract Flyweight / interface
 * 2. Concrete Flyweight
 * 3. Flyweight Factory
 * 4. Client
 */

public class Runner {
    public static void main(String[] args) {
        GlyphFactory gf = new GlyphFactory();

        Glyph a = gf.getGlyph('A', "Arial", 10);
        Glyph b = gf.getGlyph('B', "Arial", 10);
        Glyph c = gf.getGlyph('C', "Arial", 10);

        Glyph aAgain = gf.getGlyph('A', "Arial", 10);

        System.err.println("a == aAgain: " + (a==aAgain));

        a.draw("q");
        b.draw("q");
        c.draw("q");
    }
}

/*** ----------------------------------------------  Text Editor  -------------------------------------------------- */

// abstract flyweight interface
interface Glyph {
    void draw(String pos);
}

// concrete flyweight
class Character implements Glyph {
    private final char character;
    private final String font;
    private final int size;

    public Character(char ch, String font, int sz) {
        this.character = ch;
        this.font = font;
        this.size = sz;
    }

    @Override
    public void draw(String pos) {
        System.out.println("Drawing '" + character + "' at " + pos + " with font " + font + " and size " + size);
    }
}

// flyweight factory
class GlyphFactory {
    HashMap<String, Glyph>hm = new HashMap<>();

    Glyph getGlyph(char symbol, String font, int size) {
        String key = symbol + "#" + font + "#" + size;
        if(!hm.containsKey(key)) {
            hm.put(key, new Character(symbol, font, size));
        }
        return hm.get(key);
    }
}

/*
Use Cases of Flyweight Pattern
Text Rendering Systems:
Reduce memory usage by sharing character data (e.g., fonts and styles).

Graphics or Game Development:
Efficiently render large numbers of similar objects (e.g., trees in a forest, enemies in a game).

Document Editors:
Manage styles and formatting efficiently for large documents.

Caching Systems:
Share common data across multiple requests (e.g., icons, images).

Geospatial Systems:
Render large maps with repeated features like roads, buildings, or landmarks.
*/