package com.example.lab3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class EmployeeController implements Initializable {

    public TextField iid;
    public TextField iname;
    public TextField iAddress;
    public TextField iSalary;
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee,Integer > id;
    @FXML
    private TableColumn<Employee, String> name;
    @FXML
    private TableColumn<Employee,String> Address;
    @FXML
    private TableColumn<Employee,Integer> Salary;
    ObservableList<Employee> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<Employee,Integer>("id"));
        name.setCellValueFactory(new
                PropertyValueFactory<Employee,String>("name"));
        Address.setCellValueFactory(new
                PropertyValueFactory<Employee,String>("Address"));
        Salary.setCellValueFactory(new
                PropertyValueFactory<Employee,Integer>("Salary"));
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
            String query = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String Address = resultSet.getString("Address");
                int Salary = resultSet.getInt("Salary");
                tableView.getItems().add(new Employee(id, name, Address,
                        Salary));
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
            String query = "SELECT * FROM employee WHERE `id`= '"+getid+"' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String Address = resultSet.getString("Address");
                String Salary = resultSet.getString("Salary");


                iname.setText(name);
                iAddress.setText(Address);
                iSalary.setText(Salary);



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
            String query = "DELETE FROM employee WHERE `id`= '"+getid+"' ";
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
        String getAddress = iAddress.getText();
        String getSalary = iSalary.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/tbl_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `employee`(`name`, `Address`, `Salary`) VALUES ('"+getName+"','"+getAddress+"','"+getSalary+"')";
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
        String getAddress = iAddress.getText();
        String getSalary = iSalary.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/tbl_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `employee` SET `name`='"+getName+"',`Address`='"+getAddress+"',`Salary`='"+getSalary+"' WHERE `id` = '"+getid+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

