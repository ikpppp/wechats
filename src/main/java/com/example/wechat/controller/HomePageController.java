package com.example.wechat.controller;

import com.example.wechat.AlterApplication;
import com.example.wechat.Dao.User;
import com.example.wechat.HelloApplication;
import com.example.wechat.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HomePageController {

    public TextArea label;
    public TextField name;
    public TextField address;
    public TextField sex;
    public TextField age;
    public TextField phone;
    Main main=new Main();
    @FXML
    Stage stage;
    @FXML
    private Button alter;
    User user;

    public void alter(ActionEvent actionEvent) throws IOException {
        //User user=new User();
        main.alertPerson(user);
        label.setText(user.getLabel());
        name.setText(user.getName());
        sex.setText(user.getSex());
        age.setText(String.valueOf(user.getAge()));
        address.setText(user.getAddress());
        phone.setText(user.getPhone());


//        stage= (Stage) alter.getScene().getWindow();
//        stage.hide();
//        Stage register_stage = new Stage();
//        try{
//            AlterApplication alterApplication=new AlterApplication();
//            alterApplication.start(register_stage);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
    public void setApp(Main main){
        this.main=main;

    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    public void setUser(User user){
        this.user=user;
    }
}