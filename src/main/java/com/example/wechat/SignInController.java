package com.example.wechat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther 齿轮
 * @create 2022-12-28-11:58
 */
public class SignInController {
    @FXML
    private Label AccountWrong;

    @FXML
    private Label AgainPasswordWrong;

    @FXML
    private TextField Age;

    @FXML
    private Label AgeWrong;

    @FXML
    private Button Back;

    @FXML
    private Label NameWrong;

    @FXML
    private PasswordField Password;

    @FXML
    private Label PasswordWrong;

    @FXML
    private TextField Phone;

    @FXML
    private Label PhoneWrong;

    @FXML
    private TextField account;

    @FXML
    private PasswordField againPassword;

    @FXML
    private TextField name;

    @FXML
    private Button rig;

    @FXML
    private RadioButton Woman;
    @FXML
    private RadioButton Man;


    @FXML
    void back(ActionEvent event) {
        Tools.stageMap.get("Login").show();
        Tools.stageMap.get("Register").close();
    }

    @FXML
    void rig(ActionEvent event) {
        if (check()) {
            //通过了就返回原来的界面，再将password和username放一下。
            Tools.stageMap.get("Login").show();
            Tools.stageMap.get("Register").close();
            LoginController controller = Tools.fxmlLoader.getController();
            controller.change(account.getText(), Password.getText());
        }
    }

    private boolean check() {
        AccountWrong.setText("");
        NameWrong.setText("");
        PasswordWrong.setText("");
        AgainPasswordWrong.setText("");
        AgeWrong.setText("");
        PhoneWrong.setText("");
        Boolean flag = true;
        if ("".equals(account.getText())) {
            AccountWrong.setText("Enter a Account!");
            flag = false;
        } else if (account.getText().length() > 15) {
            AccountWrong.setText("Length between 12-15 !");
            flag = false;
        } else if (account.getText().length() < 12) {
            AccountWrong.setText("Length between 12-15 !");
            flag = false;
        } else if (account.getText().equals("chilun")) {
            AccountWrong.setText("Account is already in use!");
            flag = false;
        }
        if ("".equals(name.getText())) {
            NameWrong.setText("Enter a Name!");
            flag = false;
        } else if (name.getText().length() > 20) {
            NameWrong.setText("Length between 2-20 !");
            flag = false;
        } else if (name.getText().length() < 2) {
            NameWrong.setText("Length between 2-20 !");
            flag = false;
        }
        if ("".equals(Password.getText())) {
            PasswordWrong.setText("Enter a Password!");
            flag = false;
        }
        if ("".equals(againPassword.getText())) {
            AgainPasswordWrong.setText("Enter the Password again!");
            flag = false;
        } else if (!Password.getText().equals(againPassword.getText())) {
            AgainPasswordWrong.setText("The two passwords are different!");
        }
        if ("".equals(Age.getText())) {
            AgeWrong.setText("Enter a Age!");
            flag = false;
        }
        String text = Age.getText();
        int age = 0;
        try {
            age = Integer.valueOf(text);
        } catch (Exception e) {
            AgeWrong.setText("Enter a Integer Between 1-150!");
            flag = false;
        }
        if (age>150||age<1){
            AgeWrong.setText("Enter a Integer Between 1-150!");
            flag = false;
        }
        if ("".equals(Phone.getText())) {
            PhoneWrong.setText("Enter a Phone!");
            flag = false;
        }

        return flag;
    }

    public void init() {
        ToggleGroup group = new ToggleGroup();
        Woman.setToggleGroup(group);
        Man.setToggleGroup(group);
        Man.fire();
    }
}
