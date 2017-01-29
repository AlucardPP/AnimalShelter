package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LeftPaneController implements Initializable {

	final FileChooser fileChooser = new FileChooser();

	@FXML
	private Button addImageButton;

	@FXML
	private TextField petNameField;

	@FXML
	private Button cancelButton;

	@FXML
	private TextArea descriptionArea;

	@FXML
	private TextField collarIdField;

	@FXML
	private TextField typeAnimalField;

	@FXML
	private Button addButton;

	@FXML
	private ImageView petPicture;

	public Button getAddImageButton() {
		return addImageButton;
	}

	public TextField getPetNameField() {
		return petNameField;
	}

	public TextArea getDescriptionArea() {
		return descriptionArea;
	}

	public TextField getCollarIdField() {
		return collarIdField;
	}

	public TextField getTypeAnimalField() {
		return typeAnimalField;
	}

	public Button getAddButton() {
		return addButton;
	}

	public ImageView getPetPicture() {
		return petPicture;
	}

	public void initialize(URL location, ResourceBundle resources) {
		initializeFieldsDescription();
		cancelButtonAction();
		addImageButtonAction();

	}

	private void addImageButtonAction() {
		addImageButton.setOnAction(event -> {
			chooseImage();
			event.consume();
		});
	}

	private void cancelButtonAction() {
		cancelButton.setOnAction(event -> {
			clearFields(collarIdField, petNameField, typeAnimalField, descriptionArea, petPicture);
			event.consume();
		});
	}

	private void initializeFieldsDescription() {
		collarIdField.setPromptText("Collar ID");
		petNameField.setPromptText("Name of Pet");
		typeAnimalField.setPromptText("Type of Animal");
		descriptionArea.setPromptText("Put some description of animal who you want to register");

	}

	public void clearFields(TextField id, TextField pName, TextField tAnimal, TextArea desc, ImageView imageView) {
		id.clear();
		pName.clear();
		tAnimal.clear();
		desc.clear();
		imageView.setImage(null);
	}

	// sprawdź to czy teraz jest ok??
	public boolean checkIfEmpty(TextField id, TextField pName, TextField tAnimal, TextArea desc) {
		if (id.getText().trim().equals("")) {
			showRedBorder(id, pName, tAnimal);
			return false;

		} else if (pName.getText().trim().equals("")) {
			showRedBorder(pName, id, tAnimal);
			return false;
		} else if (tAnimal.getText().trim().equals("")) {
			showRedBorder(tAnimal, id, pName);
			return false;
		} else if (desc.getText().trim().equals("")) {
			return false;
		} else {
			checkIfEmptyOk(id, pName, tAnimal);
			return true;
		}

	}

	private void showRedBorder(TextField whatIsNull, TextField firstField, TextField secondField) {
		whatIsNull.getStyleClass().add("error");
		firstField.getStyleClass().remove("error");
		secondField.getStyleClass().remove("error");
	}

	private void checkIfEmptyOk(TextField firstField, TextField secondField, TextField thirdField) {
		firstField.getStyleClass().remove("error");
		secondField.getStyleClass().remove("error");
		thirdField.getStyleClass().remove("error");
	}

	private void chooseImage() {
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null) {
			openFile(file);
		}
	}

	private void openFile(File file) {
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			petPicture.setImage(image);
		} catch (IOException ex) {
			// Loggery robimy jako pola statyczne dla klasy!
			Logger.getLogger(LeftPaneController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
