package euskalcinesprograma;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class test {
    private App app = new App();
    private ArrayList<Pelicula> g = new ArrayList<Pelicula>();

    @Test
    public void testAñadeArrayPelicula() {
        g = app.añadeArrayPelicula(g, "estar wors", 120, "cienciaficcion");
        assertEquals(1, g.size());
        assertEquals("estar wors", g.get(0).getNombre());
        assertEquals(120, g.get(0).getDuracion());
        assertEquals("cienciaficcion", g.get(0).getGenero());
    }

    @Test
    public void testLogin() {
        assertEquals(true, app.verificacionDelLogin("admin", "1234"));
    }

    @Test
    public void testLogin2() {
        assertEquals(false, app.verificacionDelLogin("admi", "1234"));
    }

    @Test
    public void testLogin3() {
        assertEquals(false, app.verificacionDelLogin("admin", "123"));
    }

    @Test
    public void testAñadACartelera() {
        App apps = new App();
        ArrayList<Pelicula> s = new ArrayList<>();
        Pelicula p = new Pelicula("null", 13, "terror");
        s.add(p);
        s.add(p);
        s.add(p);
        s.add(p);
        s.add(p);
        Cartelera cart = new Cartelera();
        assertEquals(true, apps.añadirACatelera(1, s, cart, true, true));
        assertEquals(false, apps.añadirACatelera(1, s, cart, false, true));
        assertEquals(false, apps.añadirACatelera(1, s, cart, true, false));
        assertEquals(false, apps.añadirACatelera(1, s, cart, false, false));
        assertEquals(false, apps.añadirACatelera(-1, s,cart,  true, true));
    }
}
