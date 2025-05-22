package com.longson.view;
import com.alibaba.fastjson.JSON;
import com.longson.utils.HttpUrlConnect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.util.HashMap;
import java.util.prefs.Preferences;

import static javafx.geometry.HPos.RIGHT;

public class App extends Application {

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Active Apparel Group");
        AnchorPane Pane = new AnchorPane();
        Line line = new Line();
        line.setStroke(Color.GRAY);
        line.setStartX(200.f);
        line.setStartY(30.0f);
        line.setEndX(200.0f);
        line.setEndY(180.0f);


        //允许开发者创建一个灵活的网格，按行列来布局其内容节点。
        GridPane grid = new GridPane();
        // 显示网格线
//		grid.setGridLinesVisible(true);
        //居中
        grid.setAlignment(Pos.CENTER_RIGHT);
        //行列之间的间隔
        grid.setHgap(10);
        grid.setVgap(10);
        //面板边缘周围的间隔
        grid.setPadding(new Insets(35, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
//		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        final TextField name = new TextField();
        name.setPromptText("Enter your name.");

    // 缓存用户名
        grid.add(name, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        final PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password.");
        grid.add(passwordField, 1, 2);

        Button btn = new Button("Sign in");
        //
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        GridPane.setColumnSpan(actiontarget, 2);
        GridPane.setHalignment(actiontarget, RIGHT);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
//				actiontarget.setFill(Color.FIREBRICK);



                String username = name.getText().trim();
                String password = passwordField.getText().trim();
                HashMap<Object, Object> map = new HashMap<>();
                map.put("username", username);
                map.put("password", password);
                String json = JSON.toJSONString(map);
                String data = HttpUrlConnect.doPost("http://10.32.24.85:8010/web/applogin", json);
//                http://10.32.24.85:8010


                if (data.trim().equals("登陆成功")) {
                    actiontarget.setText("Login successful");
                    new MainView(username);
                    primaryStage.close();
                } else {
                    actiontarget.setText("Username or password error, please check");
                }



                System.out.println(json);
            }
        });

		/*
		scene被创建并使用gripane作为root节点，
		这在使用layout容器构建界面时是一种常见用法
		布局 ，可以自动改变大小
		 */

        Image image = new Image("images/company.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(190d);
        imageView.setFitHeight(90);


        Pane.getChildren().addAll(imageView, line, grid);
        AnchorPane.setLeftAnchor(grid, 190D);
        AnchorPane.setTopAnchor(imageView, 40D);
        AnchorPane.setTopAnchor(grid, 20D);

        Pane.setStyle("-fx-background-color: white");

        Scene scene = new Scene(Pane, 450, 225);
        //设置舞台 点击颜色的改变
        scene.getStylesheets().add(UIManager.class.getResource("/css/default.css").toExternalForm());
        scene.setFill(Color.RED);
        primaryStage.setScene(scene);
//            primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("images/icon.png"));


        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }

}






