package adaptor.shivendra;

/* Structural Design Pattern */
/*
Structural design patterns are a category of design patterns in software engineering that focus on how classes 
and objects are organized and composed to form larger structures.
These patterns provide solutions to simplify relationships between entities, making the design more flexible and scalable.
They emphasize the efficient combination of objects and classes while keeping their functionality intact.

Key Characteristics of Structural Design Patterns:
1. Simplify Structure: They make it easier to understand, organize, and manage relationships in complex systems.
2. Reuse and Extendability: Enable easy reuse of code and allow adding new functionality without altering existing code.
3. Focus on Composition: Often emphasize object composition over inheritance to achieve flexibility.
 */

/* Adaptor Design Patter */

/*
 * Adaptor is a special object that converts the interface of one object so that another object can understand it.
 * 
 */

/*
Adapters can not only convert data into various formats but can also help objects with different interfaces collaborate. Here’s how it works:
1. The adapter gets an interface, compatible with one of the existing objects.
2. Using this interface, the existing object can safely call the adapter’s methods.
3. Upon receiving a call, the adapter passes the request to the second object,
  but in a format and order that the second object expects.
4. Sometimes it’s even possible to create a two-way adapter that can convert the calls in both directions.
 */

public class Adaptor {
    public static void main(String[] args) {
        Database psql = new PostgresAdaptor();
        psql.connect();
        System.out.println(psql.fetchData("SELECT * FROM users;"));

        Database mysql = new MySQLAdaptor();
        mysql.connect();
        System.out.println(mysql.fetchData("SELECT * FROM users;"));
    }
}

interface Database {
    void connect();
    String fetchData(String query);
}

// third Party ( We can't change there Libraries, but we have to use them in our Database....)
class MySQLAPI {
    void mySQLConnect() {
        System.out.println("Connecting to MYSQL .......................");
        for(long i = 0; i < 20000000000L; i++) {}
        System.out.println("Connected to MYSQL .......................");
    }

    String selectMySQL(String query) {
        System.out.println("Got data from MySQL for query [" + query +"]");
        return "";
    }
}

// third Party ( We can't change this)
class PostgresAPI {
    void postgresConnect() {
        System.out.println("Connecting to Postgres Database .......................");
        for(long i = 0; i < 20000000000L; i++) {}
        System.out.println("Connected to Postgres Database .......................");
    }

    String selectPostgres(String query) {
        System.out.println("Got data from Postgres for query [" + query +"]");
        return "";
    }
}

class MySQLAdaptor implements Database {
    private MySQLAPI mySQLAPI;
    public void connect() {
        mySQLAPI = new MySQLAPI();
        mySQLAPI.mySQLConnect();
    }

    public String fetchData(String query) {
        if (mySQLAPI == null) {
            mySQLAPI = new MySQLAPI();
            mySQLAPI.mySQLConnect();
        }
        return mySQLAPI.selectMySQL(query);
    }

}

class PostgresAdaptor implements Database {
    private PostgresAPI postgresAPI;
    public void connect() {
        postgresAPI = new PostgresAPI();
        postgresAPI.postgresConnect();
    }

    public String fetchData(String query) {
        if (postgresAPI == null) {
            postgresAPI = new PostgresAPI();
            postgresAPI.postgresConnect();
        }
        // transformer (query -> postgres query)
        return postgresAPI.selectPostgres(query);
    }

}

/**
 public class UserRepository implements Repository<User> {
    private final Database database;

    public UserRepository(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public void save(User user) {
        databaseClient.save("users", user);
        System.out.println("User saved: " + user);
    }

    @Override
    public User find(String query) {
        return databaseClient.find("users", query);
    }
}

public class Main {
    public static void main(String []args) {
            Database database = new MySQLAdaptor();
            UserRepository userRepository = new UserRepository(database);
            // Save a User
            User user = new User();
            user.setId("1");
            user.setName("John Doe");
            user.setEmail("john@example.com");
            userRepository.save(user);
    }
}


 */