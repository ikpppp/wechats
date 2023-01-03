package com.example.wechat.controller;

import com.example.wechat.Dao.User;
import com.example.wechat.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class AlertPersonController {

    @FXML
    public Button cancel;
    @FXML
    public  Button replace;

    public TextArea label;//签名
    public TextField name;
    public TextField age;
    public TextField address;
    public TextField phone;

    public RadioButton man;
    public RadioButton woman;

    public Label nameError;
    public Label ageError;
    public Label phoneError;

    public Button head;
    @FXML
    Stage stage;

    Stage s;
    private User user;
    public void cancel(ActionEvent actionEvent) throws IOException {
        stage=(Stage) cancel.getScene().getWindow();
        stage.hide();
//        Stage back_stage = new Stage();
//        HelloApplication helloApplication = new HelloApplication();
//        helloApplication.start(back_stage);
    }


    public void replace(ActionEvent actionEvent) throws IOException {
        stage = (Stage)replace.getScene().getWindow();
        Stage stage1 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HeadPortrait.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 440);
        stage1.setTitle("HeadPortrait!");
        stage1.setScene(scene);
        stage1.show();
    }

    public void submit(ActionEvent actionEvent) {
        String label_text=label.getText();
        String name_text= name.getText();
        String age_text= age.getText();
        String address_text=address.getText();
        String phone_text=phone.getText();
        String sex = null;

        String nameRegExp = "^[a-z,A-Z,\\u4e00-\\u9fa5]{1,100}$";
        String phoneRegExp = "^(((13[0-9])|(15[0-3][5-9])|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
        String ageRegExp = "^\\d{1,3}$";

        if(man.isSelected()){
            sex="man";
        }
        if(woman.isSelected()){
            sex="woman";
        }
        if(name_text.equals("")){
            nameError.setText("姓名不能为空！");
        }
        else if(age_text.equals("")){
            ageError.setText("年龄不能为空！");
        }
        else if(phone_text.equals("")){
            phoneError.setText("电话号码不能为空！");
        } else if (!Pattern.matches(nameRegExp, name_text) || !Pattern.matches(ageRegExp, age_text)) {
            if (!Pattern.matches(nameRegExp, name_text)) {
                nameError.setText("姓名格式错误");
            }
//                if (!Pattern.matches(phoneRegExp, phone)) {
//                    alterPerson.setErrorTip("phoneError", "！电话号格式错误");
//                }
            if (!Pattern.matches(ageRegExp, age_text)) {
                ageError.setText("年龄输入有误,年龄只能是数字");
            }
        }else {
            nameError.setText("");
            ageError.setText("");
            phoneError.setText("");
            //user = new User(name_text,Integer.parseInt(age_text),sex,address_text,phone_text);
            user.setName(name_text);
            user.setAge(Integer.parseInt(age_text));
            user.setSex(sex);
            user.setAddress(address_text);
            user.setPhone(phone_text);
            user.setLabel(label_text);

            s.close();
//            Stage stage1 = (Stage) name.getScene().getWindow();
//            stage1.hide();

            /*跳转到主页面，将数据显示出来
            HelloController helloController = new HelloController();
            helloController.label.setText(label_text);
            helloController.name.setText(name_text);
            helloController.age.setText(age_text);
            helloController.address.setText(address_text);
            helloController.phone.setText(phone_text);*/

            //将user的数据传输到展示界面


        }


    }

    public void setStage(Stage stage){
        this.s=stage;
    }
    public void setUser(User user){
        this.user=user;
    }
}
