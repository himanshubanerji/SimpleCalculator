import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.scene.paint.Color;

public class Main extends Application {
	public static void main(String[] args) {
		System.out.println("Launching javafx application...");
		launch(args);
	}

	public void start (Stage myStage) {
		myStage.setTitle("Arithmetic Operations");
		FlowPane rootNode = new FlowPane(40,40);
		Scene myScene = new Scene(rootNode,400,400);
		myStage.setScene(myScene);
		
		Label firstNum = new Label("Enter first number");
		Label secondNum = new Label("Enter second number");
		Label operation = new Label("Select The Operation");
		TextField f1 = new TextField();
		f1.setPromptText("Enter first number");
		TextField f2 = new TextField();
		f2.setPromptText("Enter second number");

		ObservableList<String> operators = FXCollections.observableArrayList("Add", "Substract", "Multiply", "Divide", "Modulo");
		ComboBox<String> options = new ComboBox<String> (operators);
		options.setValue("Multiply");

		Button calculate = new Button("Calculate");
		Label result = new Label();

		calculate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle (ActionEvent ae) {
				int a = Integer.parseInt(f1.getText());
				int b = Integer.parseInt(f2.getText());

				if(options.getValue().equals("Add"))
					result.setText("Add: "+ (a+b));
				
				if(options.getValue().equals("Substract"))
					result.setText("Substact: "+ (a-b));
				if(options.getValue().equals("Multiply"))
					result.setText("Multiply: "+ (a*b));
				if(options.getValue().equals("Divide"))
					result.setText("Divide: "+ (a/b));
				if(options.getValue().equals("Modulo"))
					result.setText("Modulo: "+ (a%b));
			}
		});

		/*
		ToggleButton tb = new ToggleButton("On/Off");
		tb.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent ae) {
				if(tb.isSelected()) {
					result.setText("Button is selected");
				}
			}
		});

		RadioButton rb = new RadioButton("codm");
		RadioButton rb1 = new RadioButton("pubg");
		*/

		// result.setText("PRODUCT: "+ .getValue());

		calculate.setStyle
			(
                "-fx-font-size: 16px;"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: lightgreen;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
        );

		result.setTextFill(Color.RED);


		rootNode.getChildren().addAll(firstNum,f1,secondNum, f2,operation,options,calculate,result);
		myStage.show();
	}
}
