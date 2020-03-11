package br.edu.ifpb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Professor p1 = new Professor(555, "ata", 15, 1500, 10);
        Professor p2 = new Professor();

        Gerente g1 = new Gerente();
        Gerente g2 = new Gerente(999, "AAAAAA", 56, 4564, 55);


        System.out.println(p1.toString());
    }
}
