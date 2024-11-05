package com.example.lab3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public TextField iid;
    public TextField iname;
    public TextField iemail;
    public TextField ipassword;
    @FXML
    private TableView<Admin> tableView;
    @FXML
    private TableColumn<Admin,Integer > id;
    @FXML
    private TableColumn<Admin, String> name;
    @FXML
    private TableColumn<Admin,String> email;
    @FXML
    private TableColumn<Admin,Integer> password;
    ObservableList<Admin> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<Admin,Integer>("id"));
        name.setCellValueFactory(new
                PropertyValueFactory<Admin,String>("name"));
        email.setCellValueFactory(new
                PropertyValueFactory<Admin,String>("email"));
        password.setCellValueFactory(new
                PropertyValueFactory<Admin,Integer>("password"));
        tableView.setItems(list);
    }
    @FXML
    protected void onHelloButtonClick() {
        list.clear();tableView.setItems(list);
        populateTable();
    }
    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/tbl_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int password = resultSet.getInt("password");
                tableView.getItems().add(new Admin(id, name, email,
                        password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadData(ActionEvent actionEvent) {

        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/tbl_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admin WHERE `id`= '"+getid+"' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");


                iname.setText(name);
                iemail.setText(email);
                ipassword.setText(password);



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



    public void DeleteData(ActionEvent actionEvent) {

        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/tbl_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM admin WHERE `id`= '"+getid+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void InsertData(ActionEvent actionEvent) {

        String getid = iid.getText();
        String getName = iname.getText();
        String getEmail = iemail.getText();
        String getPassword = ipassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/tbl_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `admin`(`name`, `email`, `password`) VALUES ('"+getName+"','"+getEmail+"','"+getPassword+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateData(ActionEvent actionEvent) {

        String getid = iid.getText();
        String getName = iname.getText();
        String getemail = iemail.getText();
        String getpassword = ipassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/tbl_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `admin` SET `name`='"+getName+"',`email`='"+getemail+"',`password`='"+getpassword+"' WHERE `id` = '"+getid+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

