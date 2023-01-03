package com.example.wechat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @auther 齿轮
 * @create 2022-12-28-13:38
 */
public class setPasswordController {


    @FXML
    private TextField account;

    @FXML
    private Label accountError;

    @FXML
    private Button cancel;

    @FXML
    private TextField name;

    @FXML
    private Label nameError;

    @FXML
    private PasswordField password;

    @FXML
    private Label passwordError;

    @FXML
    private TextField phone;

    @FXML
    private Label phoneError;

    @FXML
    private PasswordField rePassword;

    @FXML
    private Label rePasswordError;

    @FXML
    private Button reset;


    @FXML
    void cancel(ActionEvent event) {
        Tools.stageMap.get("Login").show();
        Tools.stageMap.get("setPassword").close();
    }

    @FXML
    void reset(ActionEvent event) {
        if (check()) {
            Tools.stageMap.get("Login").show();
            Tools.stageMap.get("setPassword").close();
            LoginController controller = Tools.fxmlLoader.getController();
            controller.change(account.getText(), password.getText());
        }
    }

    private boolean check() {
        Boolean flag = true;
        accountError.setText("");
        nameError.setText("");
        phoneError.setText("");
        passwordError.setText("");
        rePasswordError.setText("");
        if ("".equals(account.getText())) {
            accountError.setText("Enter a Account!");
            flag = false;
        }
        if (account.getText().equals("chilun")) {
            accountError.setText("Account not exist!");
            flag = false;
        }
        if ("".equals(name.getText())) {
            nameError.setText("Enter a name!");
            flag = false;
        }
        if ("".equals(phone.getText())) {
            phoneError.setText("Enter a phone!");
            flag = false;
        }
        if ("".equals(password.getText())) {
            passwordError.setText("Enter a password!");
            flag = false;
        }
        if ("".equals(rePassword.getText())) {
            rePasswordError.setText("Enter a rePassword!");
            flag = false;
        }

        return flag;
    }

    public void init(String account) {
        this.account.setText(account);
    }
}
