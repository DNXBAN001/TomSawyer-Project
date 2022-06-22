package application;

import java.util.ArrayList;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class TextAreaView extends TextArea
{
	private StackPane paneForTextArea;
	private String arrayOfPalindromes;
	private TextArea message;
	private String listOfPalindromes;
	
	public TextAreaView()
	{
		//Text Area
		this.paneForTextArea = new StackPane();
		this.message = new TextArea();
		message.setPromptText("Type here...");
		message.setPrefColumnCount(17);
		message.setPrefRowCount(4);
		message.setWrapText(true);//go to next after running out of screen space
		message.setStyle("-fx-text-fill: purple");//color of the text
		message.setFont(Font.font("Times", 12));
		
		//add text area to the pane
		paneForTextArea.getChildren().add(message);
		
	}
	


}
