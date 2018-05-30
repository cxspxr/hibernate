package lab4;

import java.sql.Date;
import java.util.List;

import lab4.model.Girl;
import lab4.service.GirlService;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
//        Configuration configuration = new Configuration();
//        configuration.addClass(lab4.model..class)
//        DeclarationService declarationService = new DeclarationService();
//        Declaration declaration1 = new Declaration("1", new Date(1234567), "Ukraine",
//                "Great Britain", "1000", "UAH", "luggage is huge",
//                "Yaroslav", "Leonidovich", "Casper", "MT", "324724",
//                "Ukraine");
//        Declaration declaration2 = new Declaration("2", new Date(150000), "Ukraine",
//                "USA", "500", "USD", "luggage is small",
//                "Kateryna", "Alexandrovna", "Girl", "MT", "300000",
//                "Canada");
//        Declaration declaration3 = new Declaration("3", new Date(150000), "Ukraine",
//                "Brazil", "1500", "CAD", "luggage is medium",
//                "Whatever", "Whateverovych", "What", "MT", "400000",
//                "Georgia");
//        System.out.println("*** Persist - start ***");
//        declarationService.persist(declaration1);
//        declarationService.persist(declaration2);
//        declarationService.persist(declaration3);
//        List<Declaration> declarations1 = declarationService.findAll();
//        System.out.println("declarations Persisted are :");
//        for (Declaration b : declarations1) {
//            System.out.println("-" + b.toString());
//        }
//        System.out.println("*** Persist - end ***");
//        System.out.println("*** Update - start ***");
//        declaration1.setName("Yarik");
//        declarationService.update(declaration1);
//        System.out.println("declaration Updated is =>"
//                +declarationService.findById(declaration1.getId()).toString());
//        System.out.println("*** Update - end ***");
//        System.out.println("*** Find - start ***");
//        String id2 = declaration2.getId();
//        Declaration another = declarationService.findById(id2);
//        System.out.println("declaration found with id " + id2 + " is =>" +
//                another.toString());
//
//        System.out.println("*** Find - end ***");
//        System.out.println("*** Delete - start ***");
//        String id3 = declaration3.getId();
//        declarationService.delete(id3);
//        System.out.println("Deleted declaration with id " + id3 + ".");
//        System.out.println("Now all declarations are " + declarationService.findAll().size()
//
//                + ".");
//
//        System.out.println("*** Delete - end ***");
//        System.out.println("*** FindAll - start ***");
//        List<Declaration> declarations2 = declarationService.findAll();
//        System.out.println("declarations found are :");
//        for (Declaration b : declarations2) {
//            System.out.println("-" + b.toString());
//        }
//        System.out.println("*** FindAll - end ***");
//        System.out.println("*** DeleteAll - start ***");
//        declarationService.deleteAll();
//        System.out.println("declarations found are now " +
//
//                declarationService.findAll().size());
//
//        System.out.println("*** DeleteAll - end ***");
//        System.exit(0);

        GirlService girlService = new GirlService();
        Girl girl1 = new Girl(1,40, "Jessica");
        Girl girl2 = new Girl(2, 20, "Marina");
        Girl girl3 = new Girl(3, 13, "Alice");


        System.out.println("*** Persist - start ***");
        girlService.persist(girl1);
        girlService.persist(girl2);
        girlService.persist(girl3);

        List<Girl> girls1 = girlService.findAll();
        System.out.println("girls Persisted are :");
        for (Girl b : girls1) {
            System.out.println("-" + b.toString());
        }

        System.out.println("*** Persist - end ***");
        System.out.println("*** Update - start ***");

        girl1.setName("Marusya");
        girlService.update(girl1);
        System.out.println("girl Updated is =>"
                +girlService.findById( girl1.getId() ));
        System.out.println("*** Update - end ***");
        System.out.println("*** Find - start ***");
        Integer id2 = girl2.getId();
        Girl another = girlService.findById(id2);
        System.out.println("girl found with id " + id2 + " is =>" +
                another.toString());

        System.out.println("*** Find - end ***");
        System.out.println("*** Delete - start ***");
        Integer id3 = girl3.getId();
        girlService.delete(id3);
        System.out.println("Deleted girl with id " + id3 + ".");
        System.out.println("Now all girls are " + girlService.findAll().size()

                + ".");

        System.out.println("*** Delete - end ***");
        System.out.println("*** FindAll - start ***");
        List<Girl> declarations2 = girlService.findAll();
        System.out.println("girls found are :");
        for (Girl b : declarations2) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** FindAll - end ***");
        System.out.println("*** DeleteAll - start ***");
        girlService.deleteAll();
        System.out.println("girls found are now " +

                girlService.findAll().size());

        System.out.println("*** DeleteAll - end ***");
        System.exit(0);
    }
}
