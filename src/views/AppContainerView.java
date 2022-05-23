package views;

import javafx.scene.layout.Pane;

public class AppContainerView extends Pane{
	
	private static final double Infinity = Double.POSITIVE_INFINITY;
	private static final double NegInfinity = Double.NEGATIVE_INFINITY;

	public AppContainerView() {
		this.setMinHeight(NegInfinity);
		this.setPrefHeight(400.0);
		this.setMaxHeight(NegInfinity);
		this.setPrefWidth(600.0);
		//this.setAnimated(false);
		this.setMinWidth(NegInfinity);
		//this.setText("Joodle");
		this.setMaxWidth(NegInfinity);
	}

}
