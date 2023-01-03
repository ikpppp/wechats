package com.example.wechat;

import com.example.wechat.Dao.User;
import com.example.wechat.controller.AlertPersonController;
import com.example.wechat.controller.HomePageController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Main extends Application {
    private Stage primaryStage;

    ObservableList<String> friendList = FXCollections.observableArrayList("pjy","ppp");
    public ObservableList<String> getFriendList() {
        return friendList;
    }

    public void addFriend(String friend) {
        friendList.add(friend);
    }
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        scene.setFill(Color.TRANSPARENT);
        // 左上角图标
        primaryStage.getIcons().add(new Image(
                Main.class.getResourceAsStream("CSS/Image/Icon.png")));

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
        Tools.stageMap = new HashMap<>();
        Tools.stageMap.put("Login",primaryStage);
        Tools.fxmlLoader = fxmlLoader;

        LoginController loginController=fxmlLoader.getController();
        loginController.setApp(this);


    }

    public static void main(String[] args) {
        launch();
    }

    public void MainWindow(String account) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),1400,700);

        primaryStage.setTitle("MainWindow");
        primaryStage.setScene(scene);
        primaryStage.show();

        MainWindowController mainWindowController=fxmlLoader.getController();
        mainWindowController.setAccount(account);
        mainWindowController.setApp(this);

    }

    public void homePage(User user) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
        Stage stage=new Stage();
        stage.setTitle("HomePage");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Scene scene=new Scene(fxmlLoader.load(), 600, 700);
        stage.setScene(scene);

        HomePageController homePageController=fxmlLoader.getController();

        homePageController.setStage(stage);
        homePageController.setUser(user);
        homePageController.setApp(this);

        stage.showAndWait();

    }

    public void alertPerson(User user) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("alertPerson.fxml"));
        Stage stage1=new Stage();
        stage1.setTitle("Change");
        stage1.initModality(Modality.WINDOW_MODAL);
        stage1.initOwner(primaryStage);
        Scene scene=new Scene(fxmlLoader.load(), 450, 800);
        stage1.setScene(scene);

        AlertPersonController alertPersonController=fxmlLoader.getController();
        alertPersonController.setStage(stage1);
        alertPersonController.setUser(user);

        stage1.showAndWait();

    }

    public void searchFriend() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchFriend.fxml"));
        Stage stage=new Stage();
        stage.setTitle("SearchFriend");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Scene scene=new Scene(fxmlLoader.load(), 600, 350);
        stage.setScene(scene);

        SearchFriendController searchFriendController=fxmlLoader.getController();
        searchFriendController.setApp(this);

        stage.showAndWait();
    }
}