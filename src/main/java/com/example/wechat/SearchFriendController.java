package com.example.wechat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

/**
 * @author 皮皮皮
 * @date 2022/12/29 19:55
 */
public class SearchFriendController {

    public TextField search_TextField;
    public ListView searchList;
    public Button add_Button;
    public Button add_Button1;
    Main main;
    ObservableList<String> friendList = FXCollections.observableArrayList("pjy","hzl","xmf","zy");
    ObservableList<String> search = FXCollections.observableArrayList();
    public void Search(ActionEvent actionEvent) {
        String searchAccount=search_TextField.getText();
        if(searchAccount.equals("")){
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("确认", ButtonBar.ButtonData.OK_DONE));
            dialog.setTitle("警告");
            dialog.setHeaderText("未输入账号！");
            dialog.show();
        }else if(friendList.contains(searchAccount)){
            search.clear();
            search.add(searchAccount);
            searchList.setItems(search);
            add_Button.setVisible(true);
        }else{
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("确认", ButtonBar.ButtonData.OK_DONE));
            dialog.setTitle("警告");
            dialog.setHeaderText("没有相关结果！");
            dialog.show();
            search_TextField.clear();
            search.clear();
        }
    }

    public void AddFriend(ActionEvent actionEvent) {
        String search_friend=search.get(0);
        if(!main.friendList.contains(search_friend)){
            main.friendList.add(search_friend);
            search.remove(0);
            add_Button.setVisible(false);
        }else{
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("确认", ButtonBar.ButtonData.OK_DONE));
            dialog.setTitle("提示");
            dialog.setHeaderText("该用户已是您的好友!");
            dialog.show();
        }

    }

    public void AddFriend1(ActionEvent actionEvent) {
        String search_friend=search.get(1);
        if(!main.friendList.contains(search_friend)){
            main.friendList.add(search_friend);
            search.remove(0);
            add_Button1.setVisible(false);
        }else{
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.getDialogPane().getButtonTypes().add(new ButtonType("确认", ButtonBar.ButtonData.OK_DONE));
            dialog.setTitle("提示");
            dialog.setHeaderText("该用户已是您的好友!");
            dialog.show();
        }

    }

    public void setApp(Main main){
        this.main=main;
    }
}
