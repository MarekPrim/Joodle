package views;

import controllers.MenuItemController;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

public class SelectionMenuView extends GridPane{
	
	public SelectionMenuView() {
		
		this.setHgap(150); //horizontal gap in pixels => that's what you are asking for
		this.setVgap(10); //vertical gap in pixels
		this.setPadding(new Insets(10, 10, 10, 10));
		
		this.setPrefHeight(213.0);
		this.setPrefWidth(100.0);
		this.setLayoutX(20.0);
		this.setLayoutY(111.0);
		Text text1 = new Text();
		text1.setStrokeWidth(0.0);
		text1.setStrokeType(StrokeType.OUTSIDE);
		text1.setText("EDT");
		this.add(text1, 0, 0);

		// Adding child to parent
		//this.getChildren().add(text1);
		ImageView imageView2 = new ImageView();
		imageView2.setPickOnBounds(true);
		imageView2.setFitWidth(20.0);
		imageView2.setFitHeight(20.0);
		imageView2.setPreserveRatio(true);

		// Adding child to parent
		//this.getChildren().add(imageView2);
		Text text3 = new Text();
		text3.setStrokeWidth(0.0);
		text3.setStrokeType(StrokeType.OUTSIDE);
		//text3.setGridPane.rowIndex(1);
		text3.setText("Cours");
		MenuItemController t = new MenuItemController();
		text3.setOnMouseClicked(t);
		this.add(text3, 0, 1);

		// Adding child to parent
		//this.getChildren().add(text3);
		ImageView imageView4 = new ImageView();
		imageView4.setPickOnBounds(true);
		imageView4.setFitWidth(20.0);
		imageView4.setFitHeight(20.0);
		//imageView4.setGridPane.rowIndex(1);
		imageView4.setPreserveRatio(true);

		// Adding child to parent
		//this.getChildren().add(imageView4);
		Text text5 = new Text();
		text5.setStrokeWidth(0.0);
		text5.setStrokeType(StrokeType.OUTSIDE);
		//text5.setGridPane.rowIndex(2);
		text5.setText("Notes");
		this.add(text5, 0, 2);

		// Adding child to parent
		//this.getChildren().add(text5);
		ImageView imageView6 = new ImageView();
		imageView6.setPickOnBounds(true);
		imageView6.setFitWidth(20.0);
		imageView6.setFitHeight(20.0);
		//imageView6.setGridPane.rowIndex(2);
		imageView6.setPreserveRatio(true);

		// Adding child to parent
		//this.getChildren().add(imageView6);
		Text text7 = new Text();
		text7.setStrokeWidth(0.0);
		text7.setStrokeType(StrokeType.OUTSIDE);
		//text7.setGridPane.rowIndex(3);
		text7.setText("Taches");
		this.add(text7, 0, 3);

		// Adding child to parent
		//this.getChildren().add(text7);
		ImageView imageView8 = new ImageView();
		imageView8.setPickOnBounds(true);
		imageView8.setFitWidth(20.0);
		imageView8.setFitHeight(20.0);
		//imageView8.setGridPane.rowIndex(3);
		imageView8.setPreserveRatio(true);

		// Adding child to parent
		//this.getChildren().add(imageView8);
	}
}
