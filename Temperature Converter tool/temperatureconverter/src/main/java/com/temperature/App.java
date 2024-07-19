package com.temperature;

// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;

// import java.io.IOException;

// /**
//  * JavaFX App
//  */
// public class App extends Application {

//     private static Scene scene;

//     @Override
//     public void start(Stage stage) throws IOException {
//         scene = new Scene(loadFXML("primary"), 640, 480);
//         stage.setScene(scene);
//         stage.show();
//     }

//     static void setRoot(String fxml) throws IOException {
//         scene.setRoot(loadFXML(fxml));
//     }

//     private static Parent loadFXML(String fxml) throws IOException {
//         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//         return fxmlLoader.load();
//     }

//     public static void main(String[] args) {
//         launch();
//     }

// }

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{
Scene Window;
double celsius = 0.00;
double fahrenheit = 0.00,kelvin = 0.00;
double getAns[] = new double[2];
public static void main(String[] args){
launch(args);
}
public static double[] onEnter(ActionEvent e,String s,double input){
double arr[] = new double[2];
if(s.compareToIgnoreCase("celsius") == 0){
arr[0] = (((9*input)/5) + 32);
arr[1] = (input+273.15);
}
else if(s.compareToIgnoreCase("fahrenheit") == 0){
arr[0] = (5*(input - 32))/9;
arr[1] = (input-32)*(5/9)+273.15;
}
else if(s.compareToIgnoreCase("kelvin") == 0){
arr[0]=(input-273.15);
arr[1]=(9/5)*(input-273.15)+32;
}
return arr;
}
public void start(Stage primaryStage) throws Exception {
primaryStage.setTitle("Temperature Converter");
Label l1=new Label("Welcome to Temperature Convertor Tool");
l1.setStyle("-fx-font-weight: bold 15px");
Label celsiusLbl = new Label("Celcius ");
celsiusLbl.setPadding(new Insets(0,0,0,10));
celsiusLbl.setStyle("-fx-font-weight: bold");
Label fahrenheitLbl = new Label("Fahrenheit ");
fahrenheitLbl.setStyle("-fx-font-weight: bold");
Label kelvinLb1 = new Label("kelvin");
kelvinLb1.setStyle("-fx-font-weight: bold");
TextField celsiusTxt = new TextField();
TextField fahrenheitTxt = new TextField();
TextField kelvinText = new TextField();
celsiusTxt.setOnAction((ActionEvent e)->{
String input = celsiusTxt.getText();
try{
if(input.compareTo("") !=0)
celsius = Double.parseDouble(input);
getAns = App.onEnter(e,"celsius",celsius);
fahrenheit = getAns[0];
kelvin = getAns[1];
fahrenheitTxt.setText(String.valueOf(fahrenheit));
kelvinText.setText(String.valueOf(kelvin));
}
catch(Exception ex){
Alert alert = new Alert(AlertType.INFORMATION);
alert.setHeaderText(null);
alert.setTitle("Error");
alert.setContentText("Error, input must be numerical");
alert.showAndWait();
}

});
fahrenheitTxt.setOnAction((ActionEvent e)->{
String input = fahrenheitTxt.getText();
try{
if(input.compareTo("") != 0)
fahrenheit = Double.parseDouble(input);
getAns = App.onEnter(e,"fahrenheit",fahrenheit);
celsius = getAns[0];
kelvin = getAns[1];
celsiusTxt.setText(String.valueOf(celsius));
kelvinText.setText(String.valueOf(kelvin));

}
catch(Exception ex){
Alert alert = new Alert(AlertType.INFORMATION);
alert.setHeaderText(null);
alert.setTitle("Error");
alert.setContentText("Error, input must be numerical");
alert.showAndWait();
}
});
kelvinText.setOnAction((ActionEvent e)->{
String input = kelvinText.getText();
try{
if(input.compareTo("") != 0)
kelvin= Double.parseDouble(input);
getAns = App.onEnter(e,"kelvin",kelvin);
celsius = getAns[0];
fahrenheit= getAns[1];
celsiusTxt.setText(String.valueOf(celsius));
fahrenheitTxt.setText(String.valueOf(fahrenheit));

}
catch(Exception ex){
Alert alert = new Alert(AlertType.INFORMATION);
alert.setHeaderText(null);
alert.setTitle("Error");
alert.setContentText("Error, input must be numerical");
alert.showAndWait();
}
});
GridPane g = new GridPane();
g.add(celsiusLbl,0,3);
g.add(fahrenheitLbl,0,4);
g.add(kelvinLb1,0,5);
g.add(celsiusTxt,1,3);
g.add(fahrenheitTxt,1,4);
g.add(kelvinText,1,5);
g.add(l1, 1, 0);
g.setHgap(10);
g.setVgap(10);
Window = new Scene(g,500,500);
primaryStage.setScene(Window);
primaryStage.show();
}
public static void setRoot(String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setRoot'");
}
}