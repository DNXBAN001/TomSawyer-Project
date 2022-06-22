package application;

import java.io.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ControllerClass extends Scene
{
	
	private Button runButton;
	private TextAreaView note;
	private Label headingLabel;
	private HBox hbox; private VBox vbox;
	private RadioButton palindromeRadioB;
	private RadioButton consonantsRadioB;
	private RadioButton vowelsRadioB;
	private RadioButton otherRadioB;
	private RadioButton anagramsRadioB;
	private Vowels vowelsObject = new Vowels();
	private Consonants consonantsObject = new Consonants();
	private Palindromes palindromeObject = new Palindromes();
	private OtherCharacters otherObject = new OtherCharacters();
	
	public ControllerClass()
	{
		super(new HBox(20));
		this.hbox = new HBox(20);
		this.setRoot(hbox);
		
		this.headingLabel = new Label("Tom Sawyer's Book Statistics");
		
		
		this.vbox = new VBox(20);
		this.runButton = new Button("Run");
		//this.radioButtons = new RadioButtonDemo();
		this.note = new TextAreaView();
		
		vbox.setPadding(new Insets(5, 5, 5, 5));
		//paneForRadioButtons.setStyle("-fx-border-color: green");
		vbox.setStyle("-fx-border-width: 2px; -fx-border-color: green");//set the style of the boarder to green
		
		//create 3 radio buttons in a vbox
		this.palindromeRadioB = new RadioButton("Palindromes");
		this.consonantsRadioB = new RadioButton("Consonants");
		this.vowelsRadioB = new RadioButton("Vowels");
		this.anagramsRadioB = new RadioButton("Anagrams");
		this.otherRadioB = new RadioButton("Other");
		
		//group my radio buttons
		ToggleGroup group = new ToggleGroup();
		palindromeRadioB.setToggleGroup(group);
		consonantsRadioB.setToggleGroup(group);
		vowelsRadioB.setToggleGroup(group);
		anagramsRadioB.setToggleGroup(group);
		otherRadioB.setToggleGroup(group);
		
		vbox.getChildren().addAll(palindromeRadioB,consonantsRadioB,vowelsRadioB, anagramsRadioB, otherRadioB, runButton);//add radio buttons and the button in a vbox layout
		hbox.getChildren().addAll(note, vbox);//add buttons and text area to the pane
		
		palindromeRadioB.setOnAction(e -> note.setText(palindromeObject.getListOfPalindromes()));//handle palindrome radio button event
		consonantsRadioB.setOnAction(e -> note.setText(consonantsObject.getConsonantsAndCount()));//handle consonants radio button even
		vowelsRadioB.setOnAction(e -> note.setText(vowelsObject.getVowelsAndCount()));//handle vowels radio button even
		//handle anagrams radio button here
		otherRadioB.setOnAction(e -> note.setText(otherObject.getOtherCharsAndCount()));//handle other radio button event
		runButton.setOnAction(e -> note.setText(palindromeObject.displayResults()));//handle run button event
	}

	
}
