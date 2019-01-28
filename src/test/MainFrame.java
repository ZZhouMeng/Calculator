package test;

import javafx.application.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainFrame extends Application {
	BorderPane pane = new BorderPane();

	static TextField textArea = new TextField();
	String cal = "";

	Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	Button op0, op1, op2, op3, op4, op5, op6, op7, op8;

	private int flag = 0;

	@Override
	public void start(Stage Stage) throws Exception {
		VBox vbox = getVBox();
		pane.setCenter(vbox);

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(20, 20, 0, 20));
		textArea.setPrefSize(430, 50);
		textArea.setFont(new Font("Times Roman", 18));
		textArea.setEditable(false);
		textArea.setText(cal);
		hbox.getChildren().add(textArea);
		pane.setTop(hbox);

		MyEvent h = new MyEvent();
		bt0.setOnAction(h);
		bt1.setOnAction(h);
		bt2.setOnAction(h);
		bt3.setOnAction(h);
		bt4.setOnAction(h);
		bt5.setOnAction(h);
		bt6.setOnAction(h);
		bt7.setOnAction(h);
		bt8.setOnAction(h);
		bt9.setOnAction(h);
		op0.setOnAction(h);
		op1.setOnAction(h);
		op2.setOnAction(h);
		op3.setOnAction(h);
		op4.setOnAction(h);
		op5.setOnAction(h);
		op6.setOnAction(h);
		op7.setOnAction(h);
		op8.setOnAction(h);

		Scene scene = new Scene(pane, 500, 350);
		Stage.setScene(scene);
		Stage.setTitle("CAL");
		Stage.show();

	}

	private VBox getVBox() {
		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);

		HBox hbox1 = new HBox(20);
		hbox1.setAlignment(Pos.CENTER);
		HBox hbox2 = new HBox(20);
		hbox2.setAlignment(Pos.CENTER);
		HBox hbox3 = new HBox(20);
		hbox3.setAlignment(Pos.CENTER);
		HBox hbox4 = new HBox(20);
		hbox4.setAlignment(Pos.CENTER);

		bt0 = new Button("0");
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		bt5 = new Button("5");
		bt6 = new Button("6");
		bt7 = new Button("7");
		bt8 = new Button("8");
		bt9 = new Button("9");
		op0 = new Button(".");
		op1 = new Button("=");
		op2 = new Button("C");
		op3 = new Button("*");
		op4 = new Button("/");
		op5 = new Button("+");
		op6 = new Button("-");
		op7 = new Button("(");
		op8 = new Button(")");

		bt0.setPrefSize(160, 40);
		bt1.setPrefSize(70, 40);
		bt2.setPrefSize(70, 40);
		bt3.setPrefSize(70, 40);
		bt4.setPrefSize(70, 40);
		bt5.setPrefSize(70, 40);
		bt6.setPrefSize(70, 40);
		bt7.setPrefSize(70, 40);
		bt8.setPrefSize(70, 40);
		bt9.setPrefSize(70, 40);
		op0.setPrefSize(70, 40);
		op1.setPrefSize(70, 40);
		op2.setPrefSize(70, 40);
		op3.setPrefSize(70, 40);
		op4.setPrefSize(70, 40);
		op5.setPrefSize(70, 40);
		op6.setPrefSize(70, 40);
		op7.setPrefSize(70, 40);
		op8.setPrefSize(70, 40);

		hbox1.getChildren().addAll(bt0, op0, op1, op2);
		hbox2.getChildren().addAll(bt1, bt2, bt3, op3, op4);
		hbox3.getChildren().addAll(bt4, bt5, bt6, op5, op6);
		hbox4.getChildren().addAll(bt7, bt8, bt9, op7, op8);
		vbox.getChildren().addAll(hbox4, hbox3, hbox2, hbox1);
		return vbox;
	}

	class MyEvent implements EventHandler {
		@Override
		public void handle(Event e) {
			Object obj = e.getSource();
			if (obj == bt0) {
				reset();
				cal = cal + "0";
				textArea.setText(cal);
			} else if (obj == bt1) {
				reset();
				cal = cal + "1";
				textArea.setText(cal);
			} else if (obj == bt2) {
				reset();
				cal = cal + "2";
				textArea.setText(cal);
			} else if (obj == bt3) {
				reset();
				cal = cal + "3";
				textArea.setText(cal);
			} else if (obj == bt4) {
				reset();
				cal = cal + "4";
				textArea.setText(cal);
			} else if (obj == bt5) {
				reset();
				cal = cal + "5";
				textArea.setText(cal);
			} else if (obj == bt6) {
				reset();
				cal = cal + "6";
				textArea.setText(cal);
			} else if (obj == bt7) {
				reset();
				cal = cal + "7";
				textArea.setText(cal);
			} else if (obj == bt8) {
				reset();
				cal = cal + "8";
				textArea.setText(cal);
			} else if (obj == bt9) {
				reset();
				cal = cal + "9";
				textArea.setText(cal);
			} else if (obj == op0) {
				reset();
				cal = cal + ".";
				textArea.setText(cal);
			} else if (obj == op1) {
				Caculating caculating = new Caculating(cal);
				double result = caculating.result;
				String re;
				if (result%1 == 0) {
					re = String.valueOf((int) caculating.result);
				} else {
					re = String.valueOf(caculating.result);
				}
				cal = cal + "=" + re;
				textArea.setText(cal);
				flag = 1;
			} else if (obj == op2) {
				cal = "";
				textArea.setText(cal);
			} else if (obj == op3) {
				reset();
				cal = cal + "*";
				textArea.setText(cal);
			} else if (obj == op4) {
				reset();
				cal = cal + "/";
				textArea.setText(cal);
			} else if (obj == op5) {
				reset();
				cal = cal + "+";
				textArea.setText(cal);
			} else if (obj == op6) {
				reset();
				cal = cal + "-";
				textArea.setText(cal);
			} else if (obj == op7) {
				reset();
				cal = cal + "(";
				textArea.setText(cal);
			} else if (obj == op8) {
				reset();
				cal = cal + ")";
				textArea.setText(cal);
			}
		}
	}

	public void reset() {
		if (flag == 1) {
			cal = "";
			textArea.setText(cal);
			flag = 0;
		}
	}
}
