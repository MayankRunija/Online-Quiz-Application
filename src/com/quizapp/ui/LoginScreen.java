package com.quizapp.ui;

import com.quizapp.dao.UserDAO;
import com.quizapp.model.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");

        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            UserDAO userDao = new UserDAO();
            try {
                User user = userDao.authenticateUser(usernameField.getText(), passwordField.getText());
                if (user != null) {
                    messageLabel.setText("Login Successful!");
                } else {
                    messageLabel.setText("Invalid Credentials!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox layout = new VBox(10, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, messageLabel);
        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setTitle("Login Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
