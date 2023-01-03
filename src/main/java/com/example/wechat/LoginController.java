package com.example.wechat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField Password;

    @FXML
    private TextField UserName;

    @FXML
    private Label Wrong1;

    @FXML
    private Label Wrong2;

    @FXML
    private Button enter;

    @FXML
    private Button register;

    @FXML
    private Button setPassword;
    Main main;

    @FXML
    void enter(ActionEvent event) throws IOException {
        Wrong1.setText("");
        Wrong2.setText("");
        if ("".equals(UserName.getText()) || UserName.getText() == null) {
            UserName.requestFocus();
            Wrong1.setText("Enter Account!");
            return;
        } else if ("".equals(Password.getText()) || Password.getText() == null) {
            Password.requestFocus();
            Wrong2.setText("Enter Password!");
            return;
        }
        if (ServiceAccountCheck()) {
            if (ServicePasswordCheck()) {
                System.out.println("登录成功");
                //----------------------------------------------------------------------------------------------------
                //登录成功，这里补充登录后的函数：
                String account = UserName.getText();
                String password = Password.getText();
                main.MainWindow(account);

                //------------------------------------------------------------------------------------------------------
            } else {
                return;
            }
        } else {
            return;
        }
        //如果在登录成功后加return，就不会运行到这里了

    }

    private boolean ServicePasswordCheck() {
        if (UserName.getText().equals("chilun")) {
            if (Password.getText().equals("123456")) {
                Wrong1.setText("");
                Wrong2.setText("");
                return true;
            } else {
                Wrong1.setText("");
                Wrong2.setText("Wrong Password!");
                return false;
            }
        } else {
            Wrong1.setText("");
            Wrong2.setText("");
            return true;
        }
    }

    private boolean ServiceAccountCheck() {
        if (UserName.getText().equals("chilun")) {
            Wrong1.setText("");
            Wrong2.setText("");
            return true;
        } else if (UserName.getText().charAt(0) == 'p') {
            Wrong1.setText("");
            Wrong2.setText("");
            return true;
        }
        Wrong2.setText("");
        Wrong1.setText("Inexistent Account!");
        return false;
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        if (Tools.stageMap.get("Register") == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("SignIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            SignInController controller = fxmlLoader.getController();
            controller.init();
            stage.show();
            Tools.stageMap.put("Register", stage);
        } else {
            Tools.stageMap.get("Register").show();
        }
        Tools.stageMap.get("Login").close();
    }

    public void change(String username, String password) {
        UserName.setText(username);
        Password.setText(password);
    }

    @FXML
    void setPassword(ActionEvent event) throws IOException {
        if (Tools.stageMap.get("setPassword") == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("setPassword.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setTitle("Forget Password");
            stage.setScene(scene);
            setPasswordController controller = fxmlLoader.getController();
            controller.init(UserName.getText());
            stage.show();
            Tools.stageMap.put("setPassword", stage);
        } else {
            Tools.stageMap.get("setPassword").show();
        }
        Tools.stageMap.get("Login").close();
    }

    public void setApp(Main main){
        this.main=main;
    }

}