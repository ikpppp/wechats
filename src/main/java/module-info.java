module com.example.wechat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wechat to javafx.fxml;
    exports com.example.wechat;
    exports com.example.wechat.controller;
    opens com.example.wechat.controller to javafx.fxml;
}