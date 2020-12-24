package com.nosql.sasha;

import com.nosql.sasha.AggragionEntity.Count;
import com.nosql.sasha.MongoEntity.CartridgeMongo;
import com.nosql.sasha.MongoEntity.ModelMongo;
import com.nosql.sasha.MongoEntity.PrinterMongo;
import com.nosql.sasha.MongoEntity.TypeMongo;
import com.nosql.sasha.MongoRepository.CartridgeMongoRepository;
import com.nosql.sasha.MongoRepository.ModelMongoRepository;
import com.nosql.sasha.MongoRepository.PrinterMongoRepository;
import com.nosql.sasha.MongoRepository.TypeMongoRepository;
import com.nosql.sasha.SQLEntity.CartridgeSQL;
import com.nosql.sasha.SQLEntity.ModelSQL;
import com.nosql.sasha.SQLEntity.PrinterSQL;
import com.nosql.sasha.SQLEntity.TypeSQL;
import com.nosql.sasha.SQLRepository.CartridgeSQLRepository;
import com.nosql.sasha.SQLRepository.ModelSQLRepository;
import com.nosql.sasha.SQLRepository.PrinterSQLRepository;
import com.nosql.sasha.SQLRepository.TypeSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SashaApplication implements CommandLineRunner {
    @Autowired
    private CartridgeSQLRepository cartridgeSQLRepository;
    @Autowired
    private ModelSQLRepository modelSQLRepository;
    @Autowired
    private PrinterSQLRepository printerSQLRepository;
    @Autowired
    private TypeSQLRepository typeSQLRepository;

    @Autowired
    private CartridgeMongoRepository cartridgeMongoRepository;
    @Autowired
    private ModelMongoRepository modelMongoRepository;
    @Autowired
    private PrinterMongoRepository printerMongoRepository;
    @Autowired
    private TypeMongoRepository typeMongoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SashaApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        //sql();
        //  mongo();
        //speedTest();
        //  migrationFromSqlToMongo();
        //   migrationFromMongoToSql();
        //replication();
        aggregation();
    }

    public void sql() {
        //cartridge
        CartridgeSQL cartridgeSql = new CartridgeSQL((long) 1, "cart1", 1000, "CanonCatridge", 1.5, "black", "ink_type1");
        //insert
        cartridgeSQLRepository.save(cartridgeSql);
        //select
        for (CartridgeSQL c : cartridgeSQLRepository.findAll()) {
            System.out.println(c.toString());
        }
        //update
        cartridgeSql.setPrint_capacity(800);
        cartridgeSQLRepository.save(cartridgeSql);
        for (CartridgeSQL c : cartridgeSQLRepository.findAll()) {
            System.out.println(c.toString());
        }
        //delete
        /*cartridgeSQLRepository.deleteById((long) 1);
        for (CartridgeSQL c : cartridgeSQLRepository.findAll()) {
            System.out.println(c.toString());
        }


         */

//

        //cartridgeSQLRepository.save(cartridgeSql);
        //Type
        //cartridge
        TypeSQL typeSQL = new TypeSQL((long) 1, "type1", "description of type printer", cartridgeSql);
        //insert
        typeSQLRepository.save(typeSQL);
        //select
        for (TypeSQL t : typeSQLRepository.findAll()) {
            System.out.println(t.toString());
        }
        //update
        typeSQL.setName("new type1");
        typeSQLRepository.save(typeSQL);
        for (TypeSQL t : typeSQLRepository.findAll()) {
            System.out.println(t.toString());
        }
        //delete
       /* typeSQLRepository.deleteById((long) 1);
        for (TypeSQL t : typeSQLRepository.findAll()) {
            System.out.println(t.toString());
        }

        */


    }

    public void mongo() {
       /* //cartridge
        CartridgeMongo cartridgeMongo = new CartridgeMongo("cart1", 1000, "CanonCartridge", 1.5, "black", "ink_type1");
        //insert
        cartridgeMongoRepository.save(cartridgeMongo);
        //select
        for (CartridgeMongo c : cartridgeMongoRepository.findAll()) {
            System.out.println(c.toString());
        }
        //update
        cartridgeMongo.setPrint_capacity(800);
        cartridgeMongoRepository.save(cartridgeMongo);
        for (CartridgeMongo c : cartridgeMongoRepository.findAll()) {
            System.out.println(c.toString());
        }
        //delete
        cartridgeMongoRepository.deleteAllByFirm("CanonCartridge");
        for (CartridgeMongo c : cartridgeMongoRepository.findAll()) {
            System.out.println(c.toString());
        }
//
        cartridgeMongoRepository.save(cartridgeMongo);
        //Type
        //cartridge
        TypeMongo typeMongo = new TypeMongo("type1", "description of type printer", cartridgeMongo);
        //insert
        typeMongoRepository.save(typeMongo);
        //select
        for (TypeMongo t : typeMongoRepository.findAll()) {
            System.out.println(t.toString());
        }
        //update
        typeMongo.setName("new type1");
        typeMongoRepository.save(typeMongo);
        for (TypeMongo t : typeMongoRepository.findAll()) {
            System.out.println(t.toString());
        }
        //delete
        typeMongoRepository.deleteAllByName("new type1");
        typeMongoRepository.save(typeMongo);
        for (TypeMongo t : typeMongoRepository.findAll()) {
            System.out.println(t.toString());
        }


        CartridgeMongo cartridgeMongo = new CartridgeMongo("cart1", 1000, "CanonCartridge", 1.5, "black", "ink_type1");

        cartridgeMongoRepository.save(new CartridgeMongo("cart2", 1000, "CanonCartridge", 1.5, "black", "ink_type1"));
        cartridgeMongoRepository.save(new CartridgeMongo("cart3", 1000, "CanonCartridge", 1.5, "black", "ink_type1"));
        cartridgeMongoRepository.save(new CartridgeMongo("cart4", 1000, "CanonCartridge", 1.5, "black", "ink_type1"));
        cartridgeMongoRepository.save(new CartridgeMongo("cart5", 1000, "CanonCartridge", 1.5, "black", "ink_type1"));
    */
        CartridgeMongo cartridgeMongo = new CartridgeMongo("cart1", 1000, "CanonCartridge", 1.5, "black", "ink_type1");

        TypeMongo typeMongo = new TypeMongo("type1", "description of type printer", cartridgeMongo);
        typeMongoRepository.save(typeMongo);
        typeMongoRepository.save(new TypeMongo("type2", "description of type printer", cartridgeMongo));
        typeMongoRepository.save(new TypeMongo("type3", "description of type printer", cartridgeMongo));
        typeMongoRepository.save(new TypeMongo("type4", "description of type printer", cartridgeMongo));
        typeMongoRepository.save(new TypeMongo("type5", "description of type printer", cartridgeMongo));
/*
        modelMongoRepository.save(new ModelMongo("typeName2","Canon","CanonProject","France"));
        modelMongoRepository.save(new ModelMongo("typeName3","Canon","CanonProject","France"));
        modelMongoRepository.save(new ModelMongo("typeName4","Canon","CanonProject","France"));
        printerMongoRepository.save(new PrinterMongo("Canonx2",6530.0,"white",typeMongo,
                new ModelMongo("typeName1","Canon","CanonProject","France")));
        printerMongoRepository.save(new PrinterMongo("Canonx3",4530.0,"white",typeMongo,
                new ModelMongo("typeName1","Canon","CanonProject","France")));
        printerMongoRepository.save(new PrinterMongo("Canonx4",4430.0,"white",typeMongo,
                new ModelMongo("typeName1","Canon","CanonProject","France")));
  */
    }

    public void speedTest() {
        CartridgeSQL cartridgeSql = cartridgeSQLRepository.findById((long) 1).get();
        Long startTime = System.nanoTime();
        for (Integer i = 2; i < 102; i++) {
            typeSQLRepository.save(new TypeSQL((long) i, "type" + i, "description of type printer", cartridgeSql));
        }
        Long endTime = System.nanoTime();
        System.out.print("Insert into SQL took:");
        System.out.println(endTime - startTime);

        CartridgeMongo cartridgeMongo = cartridgeMongoRepository.findFirstByFirm("CanonCartridge").get();
        startTime = System.nanoTime();
        for (Integer i = 2; i < 102; i++) {
            typeMongoRepository.save(new TypeMongo("type" + i, "description of type printer", cartridgeMongo));
        }
        endTime = System.nanoTime();
        System.out.print("Insert into Mongo took:");
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        typeSQLRepository.findAllByName("type100");
        endTime = System.nanoTime();
        System.out.print("Select from SQL took:");
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        typeMongoRepository.findAllByName("type100");
        endTime = System.nanoTime();
        System.out.print("Select from Mongo took:");
        System.out.println(endTime - startTime);

    }

    public void migrationFromSqlToMongo() {
        List<CartridgeSQL> cartridgeSQLList = cartridgeSQLRepository.findAll();
        for (CartridgeSQL c : cartridgeSQLList) {
            Optional<CartridgeMongo> cartridgeMongo = cartridgeMongoRepository.findFirstByTittle(c.getTittle());
            if (cartridgeMongo.isEmpty()) {
                cartridgeMongoRepository.save(new CartridgeMongo(c.getTittle(), c.getPrint_capacity(), c.getFirm(), c.getLife_time(), c.getColors(), c.getInk_type()));
            }
        }

        List<ModelSQL> modelSQLList = modelSQLRepository.findAll();
        for (ModelSQL m : modelSQLList) {
            Optional<ModelMongo> modelMongo = modelMongoRepository.findFirstByTypeName(m.getTypeName());
            if (modelMongo.isEmpty()) {
                modelMongoRepository.save(new ModelMongo(m.getTypeName(), m.getBrand(), m.getFirm(), m.getCountry()));
            }
        }

        List<TypeSQL> typeSQLList = typeSQLRepository.findAll();
        for (TypeSQL t : typeSQLList) {
            Optional<TypeMongo> typeMongo = typeMongoRepository.findFirstByName(t.getName());
            if (typeMongo.isEmpty()) {
                Optional<CartridgeMongo> cartridgeMongo = cartridgeMongoRepository.findFirstByTittle(t.getCartridgeSQL().getTittle());
                typeMongoRepository.save(new TypeMongo(t.getName(), t.getDescription(), cartridgeMongo.get()));
            }
        }

        List<PrinterSQL> printerSQLList = printerSQLRepository.findAll();
        for (PrinterSQL p : printerSQLList) {
            Optional<PrinterMongo> printerMongo = printerMongoRepository.findFirstByName(p.getName());
            if (printerMongo.isEmpty()) {
                Optional<TypeMongo> typeMongo = typeMongoRepository.findFirstByName(p.getTypeSQL().getName());
                Optional<ModelMongo> modelMongo = modelMongoRepository.findFirstByTypeName(p.getModelSQL().getTypeName());
                printerMongoRepository.save(new PrinterMongo(p.getName(), p.getPrice(), p.getColor(), typeMongo.get(), modelMongo.get()));
                {
                }
            }


        }
    }

    public void migrationFromMongoToSql() {
        List<CartridgeMongo> cartridgeMongoList = cartridgeMongoRepository.findAll();
        for (CartridgeMongo c : cartridgeMongoList) {
            Optional<CartridgeSQL> cartridgeSQL = cartridgeSQLRepository.findFirstByTittle(c.getTittle());
            if (cartridgeSQL.isEmpty()) {
                cartridgeSQLRepository.save(new CartridgeSQL(c.getTittle(), c.getPrint_capacity(), c.getFirm(), c.getLife_time(), c.getColors(), c.getInk_type()));
            }
        }

        List<ModelMongo> modelMongoList = modelMongoRepository.findAll();
        for (ModelMongo m : modelMongoList) {
            Optional<ModelSQL> modelSQL = modelSQLRepository.findFirstByTypeName(m.getTypeName());
            if (modelSQL.isEmpty()) {
                modelSQLRepository.save(new ModelSQL(m.getTypeName(), m.getBrand(), m.getFirm(), m.getCountry()));
            }
        }


        List<TypeMongo> typeMongoList = typeMongoRepository.findAll();
        for (TypeMongo t : typeMongoList) {
            Optional<TypeSQL> typeSQL = typeSQLRepository.findFirstByName(t.getName());
            if (typeSQL.isEmpty()) {
                Optional<CartridgeSQL> cartridgeSQL = cartridgeSQLRepository.findFirstByTittle(t.getCartridgeMongo().getTittle());

                typeSQLRepository.save(new TypeSQL(t.getName(), t.getDescription(), cartridgeSQL.get()));
            }
        }

        List<PrinterMongo> printerMongoList = printerMongoRepository.findAll();
        for (PrinterMongo p : printerMongoList) {
            Optional<PrinterSQL> printerSQL = printerSQLRepository.findFirstByName(p.getName());
            if (printerSQL.isEmpty()) {
                Optional<TypeSQL> typeSQL = typeSQLRepository.findFirstByName(p.getTypeMongo().getName());
                Optional<ModelSQL> modelSQL = modelSQLRepository.findFirstByTypeName(p.getModelMongo().getTypeName());

                printerSQLRepository.save(new PrinterSQL(p.getName(), p.getPrice(), p.getColor(), typeSQL.get(), modelSQL.get()));
            }
        }


    }

    public void replication() throws InterruptedException {
        cartridgeMongoRepository.deleteAll();
        long startTime = System.nanoTime();
        for (Integer i = 0; i < 10000; i++) {
            insert(new CartridgeMongo("Cartridge" + i.toString(), 1000, "CanonType№" + i.toString(), 1.5, "black", "ink_type"));
        }
        long endTime = System.nanoTime();
        System.out.println("Insert: " + (double) (endTime - startTime) / 1000000000);
        startTime = System.nanoTime();
        cartridgeMongoRepository.findAll();
        endTime = System.nanoTime();
        System.out.println("Select: " + (double) (endTime - startTime) / 1000000000);
    }

    public boolean insert(CartridgeMongo cartridgeMongo) throws InterruptedException {
        int retries = 3;
        while (retries > 0) {
            try {
                if (cartridgeMongoRepository.save(cartridgeMongo) != null) {
                    return true;
                }
            } catch (Exception e) {
                retries--;
                Thread.sleep(1000);
            }
        }
        System.out.println("Error to insert document");
        return false;
    }

    public void aggregation() {
        //1Agg
        long startTime = System.nanoTime();
        // for (Count p : printerMongoRepository.countAllByModelMongo_Brand()) {
        //    System.out.println(p);
        // }
        printerMongoRepository.countAllByModelMongo_Brand();
        long endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//1Not
        startTime = System.nanoTime();
        List<PrinterMongo> temp = printerMongoRepository.findAll();
        HashMap<String, Integer> countByBrand = new HashMap<>();
        for (PrinterMongo p : temp) {
            Integer frequency = countByBrand.get(p.getModelMongo().getBrand());
            countByBrand.put(p.getModelMongo().getBrand(), frequency == null ? 1 : frequency + 1);
        }
        List<Count> result = new ArrayList<Count>();
        for (Map.Entry<String, Integer> entry : countByBrand.entrySet()) {
            result.add(new Count(entry.getKey(), entry.getValue()));
        }
        //   for (Count p : result) {
        //      System.out.println(p);
        //   }

        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
//2Agg
        startTime = System.nanoTime();
        // for (Count p : printerMongoRepository.countAllByModelMongo_Country()) {
        //     System.out.println(p);
        // }

        printerMongoRepository.countAllByModelMongo_Country();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//2Not
        startTime = System.nanoTime();
        temp = printerMongoRepository.findAll();
        HashMap<String, Integer> countByCountry = new HashMap<>();
        for (PrinterMongo p : temp) {
            Integer frequency = countByCountry.get(p.getModelMongo().getCountry());
            countByCountry.put(p.getModelMongo().getCountry(), frequency == null ? 1 : frequency + 1);
        }
        result = new ArrayList<Count>();
        for (Map.Entry<String, Integer> entry : countByCountry.entrySet()) {
            result.add(new Count(entry.getKey(), entry.getValue()));
        }

        //  for (Count p : result) {
        //     System.out.println(p);
        // }

        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //3 Agg
        startTime = System.nanoTime();

        // for (PrinterMongo p : printerMongoRepository.findAllByPriceMin()) {
        //      System.out.println(p);
        //  }

        printerMongoRepository.findAllByPriceMin();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//3Not
        startTime = System.nanoTime();
        temp = printerMongoRepository.findAll();
        Double min_price = 1000000.0;
        for (PrinterMongo p : temp) {
            if (p.getPrice() < min_price) {
                min_price = p.getPrice();
            }
        }
        List<PrinterMongo> result3 = new ArrayList<PrinterMongo>();
        for (PrinterMongo p : temp) {
            if (p.getPrice() == min_price) {
                result3.add(p);
            }
        }
        //  for (PrinterMongo p : result3) {
        //      System.out.println(p);
        //  }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//4 Agg
        startTime = System.nanoTime();
        // for (CartridgeMongo c : cartridgeMongoRepository.matchColors()) {
        //      System.out.println(c);
        //   }
        cartridgeMongoRepository.matchColors();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //4Not
        startTime = System.nanoTime();
        //   for (CartridgeMongo c : cartridgeMongoRepository.findAllByColors("black")) {
        //      System.out.println(c);
        //   }
        cartridgeMongoRepository.findAllByColors("black");
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //5Agg
        startTime = System.nanoTime();
        //  for (Count c : cartridgeMongoRepository.countAllByColors()) {
        //       System.out.println(c);
        //   }
        cartridgeMongoRepository.countAllByColors();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//5Not
        startTime = System.nanoTime();
        List<CartridgeMongo> temp2 = cartridgeMongoRepository.findAll();
        HashMap<String, Integer> countByColors = new HashMap<>();
        for (CartridgeMongo c : temp2) {
            Integer frequency = countByColors.get(c.getColors());
            countByColors.put(c.getColors(), frequency == null ? 1 : frequency + 1);
        }
        result = new ArrayList<Count>();
        for (Map.Entry<String, Integer> entry : countByColors.entrySet()) {
            result.add(new Count(entry.getKey(), entry.getValue()));
        }
        //  for (Count c : result) {
        //      System.out.println(c);
        //  }

        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

    }
}
