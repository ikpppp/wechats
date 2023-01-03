package com.example.wechat;

import com.example.wechat.Dao.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @author 皮皮皮
 * @date 2022/12/28 16:00
 */
public class MainWindowController {
    public Label nameLabel;
    public Label ageLabel;
    public Label phoneLabel;
    public TextField msg_TextField;
    public Pane photo_Pane;
    public Label account_Label;

    public String account;
    public ListView ChatList=new ListView<>();
    public ListView FriendList=new ListView<>();

    ObservableList<String> chatList = FXCollections.observableArrayList();
    Main main;

    ObservableList<String> friendList;
    User user;

    public void initialize(){

        FriendList.setCellFactory(TextFieldListCell.forListView());
        FriendList.setEditable(true);
    }

    public void setAccount(String account){
        this.account=account;
    }
    public void setApp(Main main){
        this.main=main;
        friendList = main.getFriendList();
        FriendList.setItems(friendList);


        user=new User();
        user.setName("ppp");
        user.setAge(18);
        user.setPhone("150****7753");
        account_Label.setText(account);
        nameLabel.setText(user.getName());
        ageLabel.setText(String.valueOf(user.getAge()));
        phoneLabel.setText(user.getPhone());


    }

    public void addFriend(ActionEvent actionEvent) throws IOException {
        main.searchFriend();
    }

    public void min_Action(ActionEvent actionEvent) {
    }

    public void exit_Action(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void send_Action(ActionEvent actionEvent) {
        String msg="我："+msg_TextField.getText();
        chatList.add(msg);
        ChatList.setItems(chatList);
        msg_TextField.clear();
    }

    public void more_Action(ActionEvent actionEvent) throws IOException {
        main.homePage(user);

        nameLabel.setText(user.getName());
        ageLabel.setText(String.valueOf(user.getAge()));
        phoneLabel.setText(user.getPhone());
    }
}
