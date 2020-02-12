package ohtu;

import ohtu.laskin.Laskin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Viitegeneraattori viitegen = ctx.getBean(Viitegeneraattori.class);
        Kirjanpito kirjanpito = new Kirjanpito();
        Varasto varasto = new Varasto(kirjanpito);
        Pankki pankki = new Pankki(kirjanpito);
        Kauppa kauppa = new Kauppa(varasto, pankki, viitegen);
    }
}

//        //Koe k = ctx.getBean(Koe.class);
//        Koe k = (Koe)ctx.getBean("koe");
//        k.foo();
//        
//        IO io = ctx.getBean(IO.class);
//        io.print("paska");
