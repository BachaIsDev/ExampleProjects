package dao;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import model.Product;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDao {
    private static Connection connection;

    private String CREATE_PRODUCT = "INSERT INTO person(name, cost) VALUES ";
    private String DELETE_PRODUCT = "DELETE FROM person WHERE id";
    private String GET_PRODUCT = "SELECT * FROM person WHERE id = ";
    private String GET_ALL = "SELECT * FROM person";
    private String REFRESH_PRODUCT = "UPDATE person SET";

    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:/Users/bacha/IdeaProjects/SomeProj/src/main/resources/db.properties"));

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Class.forName(properties.getProperty("db.driverClassName"));

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void add(Product product){

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_PRODUCT + "('" + product.getName() + "', '" +
                    product.getCost() + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);

            while(resultSet.next()){
                Product product = new Product();
                product.setName(resultSet.getString("name"));
                product.setCost(resultSet.getInt("cost"));
                product.setId(resultSet.getInt("id"));

                products.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public Product findById(int id){
        Product product = new Product();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_PRODUCT + "'" + id + "'");

            if(resultSet.next()) {
                product.setName(resultSet.getString("name"));
                product.setCost(resultSet.getInt("cost"));
                product.setId(resultSet.getInt("id"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    public void delete(int id){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_PRODUCT + "=" + " '" + id + "'");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Product product){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(REFRESH_PRODUCT + " name = " + " '" + product.getName() +"' " + ", cost = " + "'" + product.getCost() + "'"
            + "WHERE id = " + product.getId());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
