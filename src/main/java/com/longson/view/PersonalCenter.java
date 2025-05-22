package com.longson.view;
import com.longson.utils.GetScreenSize;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.util.Arrays;


public class PersonalCenter extends VBox {

    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = " ltaly";
    final static String usa = "America";


    public PersonalCenter() {


        //Preparing ObservbleList object
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(


                new PieChart.Data("Iphone 5S", 13),
                new PieChart.Data("Samsung Grand", 25),
                new PieChart.Data("MOTO G", 10),
                new PieChart.Data("Nokia Lumia", 22));


        PieChart pieChart = new PieChart();
        pieChart.setData(pieChartData);
        pieChart.setTitle("Mobile Sales");


        NumberAxis xAxis = new NumberAxis();
        xAxis.setUpperBound(200);

        CategoryAxis yAxis = new CategoryAxis();
        BarChart<Number, String> bc = new BarChart<>(xAxis, yAxis);
        bc.setTitle("AAG recently earned B Corp Certification after a rigorous two year journey");
        xAxis.setLabel("技术能力");
        xAxis.setTickLabelRotation(200);
        yAxis.setLabel("国家");
//    bc.setBarGap(200);  设置 类别间距

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("防守能力");
        series1.getData().add(new XYChart.Data(26.34, austria));
        series1.getData().add(new XYChart.Data(21.82, brazil));
        series1.getData().add(new XYChart.Data(00, france));
        series1.getData().add(new XYChart.Data(34.15, italy));
        series1.getData().add(new XYChart.Data(10, usa));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("体力");
        series2.getData().add(new XYChart.Data(54.85, austria));
        series2.getData().add(new XYChart.Data(19.19, brazil));
        series2.getData().add(new XYChart.Data(52.37, france));
        series2.getData().add(new XYChart.Data(10.16, italy));
        series2.getData().add(new XYChart.Data(15.27, usa));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("进攻能力");
        series3.getData().add(new XYChart.Data(50.65, austria));
        series3.getData().add(new XYChart.Data(35.76, brazil));
        series3.getData().add(new XYChart.Data(22.18, france));
        series3.getData().add(new XYChart.Data(17.31, italy));
        series3.getData().add(new XYChart.Data(93.68, usa));


        Image st = new Image("images/statistics.png");
        ImageView statistics = new ImageView(st);
        statistics.setFitHeight((GetScreenSize.getScreenheight - 100) / 2);
        statistics.setFitWidth((GetScreenSize.getScreenwidth - 50) / 2);




        //Defining the x axis
        CategoryAxis xa = new CategoryAxis();

        xa.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
                "A01", "A02", "A03", "A04","A05", "A06", "A07", "A08","A09", "A10", "A11", "A12")));
        xa.setLabel("category");

//Defining the y axis
        NumberAxis ya = new NumberAxis();
        ya.setLabel("score");

        //Creating the Bar chart
        BarChart<String, Number> bar = new BarChart<>(xa, ya);
        bar.setTitle("AAG Team Output");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<String, Number> seriesA = new XYChart.Series<>();
        seriesA.setName("Fiat");
        seriesA.getData().add(new XYChart.Data<>("A01", 300));
        seriesA.getData().add(new XYChart.Data<>("A02", 200));
        seriesA.getData().add(new XYChart.Data<>("A03", 200));
        seriesA.getData().add(new XYChart.Data<>("A04", 300));
        seriesA.getData().add(new XYChart.Data<>("A05", 300));
        seriesA.getData().add(new XYChart.Data<>("A06", 200));
        seriesA.getData().add(new XYChart.Data<>("A07", 200));
        seriesA.getData().add(new XYChart.Data<>("A08", 300));
        seriesA.getData().add(new XYChart.Data<>("A09", 300));
        seriesA.getData().add(new XYChart.Data<>("A10", 200));
        seriesA.getData().add(new XYChart.Data<>("A11", 200));
        seriesA.getData().add(new XYChart.Data<>("A12", 300));


        XYChart.Series<String, Number> seriesB= new XYChart.Series<>();
        seriesB.setName("Audi");
        seriesB.getData().add(new XYChart.Data<>("A01", 300.0));
        seriesB.getData().add(new XYChart.Data<>("A02", 230.0));
        seriesB.getData().add(new XYChart.Data<>("A03", 112.0));
        seriesB.getData().add(new XYChart.Data<>("A04", 550.0));
        seriesB.getData().add(new XYChart.Data<>("A05", 210.0));
        seriesB.getData().add(new XYChart.Data<>("A06", 321.0));
        seriesB.getData().add(new XYChart.Data<>("A07", 110.0));
        seriesB.getData().add(new XYChart.Data<>("A08", 411.0));
        seriesB.getData().add(new XYChart.Data<>("A09", 210.0));
        seriesB.getData().add(new XYChart.Data<>("A10", 321.0));
        seriesB.getData().add(new XYChart.Data<>("A11", 110.0));
        seriesB.getData().add(new XYChart.Data<>("A12", 411.0));


        XYChart.Series<String, Number> seriesC = new XYChart.Series<>();
        seriesC.setName("Ford");
        seriesC.getData().add(new XYChart.Data<>("A01", 4.0));
        seriesC.getData().add(new XYChart.Data<>("A02", 2.0));
        seriesC.getData().add(new XYChart.Data<>("A03", 3.0));
        seriesC.getData().add(new XYChart.Data<>("A04", 6.0));
        seriesC.getData().add(new XYChart.Data<>("A05", 4.0));
        seriesC.getData().add(new XYChart.Data<>("A06", 2.0));
        seriesC.getData().add(new XYChart.Data<>("A07", 3.0));
        seriesC.getData().add(new XYChart.Data<>("A08", 6.0));
        seriesC.getData().add(new XYChart.Data<>("A09", 4.0));
        seriesC.getData().add(new XYChart.Data<>("A10", 2.0));
        seriesC.getData().add(new XYChart.Data<>("A07", 3.0));
        seriesC.getData().add(new XYChart.Data<>("A08", 6.0));

        bar.getData().addAll(seriesA,seriesB,seriesC);
        bar.setBarGap(2); // 设置柱子之间的间隔大小
        bar.setCategoryGap(10); // 设置柱子的宽度












//        bc.getData().addAll(series1, series2, series3);


        BorderPane gridPane = new BorderPane();

        gridPane.setLeft(pieChart);
//        gridPane.setBottom(bc);liqiangqiang
        gridPane.setCenter(bar);
//        gridPane.setBottom(barChart);

        this.setStyle("-fx-background-color: white");


        this.getChildren().add(gridPane);

    }
}
