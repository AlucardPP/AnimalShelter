package controller;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Animals;

public class MainPaneController implements Initializable {

	private final ObservableList<Animals> data=FXCollections.observableArrayList();

	@FXML
	private MenuPaneController menuPaneController;

	@FXML
	private LeftPaneController leftPaneController;

	@FXML
	private BottomPaneController bottomPaneController;


	//metoda ma 30 lini kodu a uncle bob twierdzi że max 7 mieć powinna
	// rozbij po typie inicjacji na 3 mniejsze
	public void initialize(URL location, ResourceBundle resources) {
		TextField collarId = leftPaneController.getCollarIdField();
		TextField petName = leftPaneController.getPetNameField();
		TextField typeOfAnimal = leftPaneController.getTypeAnimalField();
		TextArea description = leftPaneController.getDescriptionArea();
		Button addButton = leftPaneController.getAddButton();
		ImageView animalImage = leftPaneController.getPetPicture();
		TableView<Animals> tableOfAnimals = bottomPaneController.getTableView();
		TableColumn<Animals, String> collarIdColumn = bottomPaneController.getCollarIdColumn();
		//od jakiegoś czasu pisze się new PropertyValueFactory("collarId")
		//nie jest to błąd ale intellij poprawia to już nawet, bo taka deklaracja nie ma sensu
		collarIdColumn.setCellValueFactory(new PropertyValueFactory<Animals, String>("collarId"));
		TableColumn<Animals, String> petNameColumn = bottomPaneController.getPetNameColumn();
		petNameColumn.setCellValueFactory(new PropertyValueFactory<Animals, String>("name"));
		TableColumn<Animals, String> typeAnimalColumn = bottomPaneController.getTypeOfAnimalColumn();
		typeAnimalColumn.setCellValueFactory(new PropertyValueFactory<Animals, String>("type"));
		TableColumn<Animals, String> descriptionColumn = bottomPaneController.getDescriptionColumn();
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<Animals, String>("description"));
		TableColumn<Animals, ImageView> imageColumn = bottomPaneController.getImageColumn();
		imageColumn.setCellValueFactory(new PropertyValueFactory<Animals, ImageView>("image"));
		//coś nie commitnięte
		Button viewSelectedRow = bottomPaneController.getViewButton();

		addButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (leftPaneController.checkIfEmpty(collarId, petName, typeOfAnimal, description) == false) {
					// add some window with information about error
				} else {
						//a o formatowaniu kodu kolega słyszał ?
					 addToTable(collarId, petName, typeOfAnimal, description, animalImage, tableOfAnimals);
					 leftPaneController.clearFields(collarId, petName,
					  typeOfAnimal, description, animalImage);


				}
				event.consume();



			}
		});

		viewSelectedRow.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				leftPaneController.clearFields(collarId, petName,
						  typeOfAnimal, description, animalImage);
				viewTableRow(tableOfAnimals, collarId, petName, typeOfAnimal, description, animalImage);


			}


		});

	}

	//dobra porada dnia - czasem jak robisz 3 proste myśli w ramach jednej metody ( clean code karze rozbijać to na 3 metody ale nie bądźmy nadgorliwi) to te myśli rozbija się enterami
	//czyta się taki kod łatwiej wtedy
	public void addToTable(TextField id, TextField pName, TextField tAnimal, TextArea desc, ImageView imageView,
			TableView<Animals> table ) {
		String colId = id.getText();
		// co oznacza petN? to samo co to pName - nazewnictwo, nazewnictwo, nazewnictwo
		// za 3 tyg nie będziesz tego pamiętał co do czego służy
		String petN = pName.getText();
		String type = tAnimal.getText();
		String dsc = desc.getText();
		Image animalImg = imageView.getImage();
		ImageView image = new ImageView();
		image.setFitHeight(50);
		image.setFitWidth(50);
		image.setImage(animalImg);
		Animals animal = new Animals(colId, petN, type, dsc, image);
		data.add(animal);
		table.setItems(data);

	}
	private void viewTableRow(TableView table, TextField id,TextField name, TextField type,TextArea desc, ImageView image){
		ObservableList<Animals> singleRow=table.getSelectionModel().getSelectedItems();
		Animals animal=singleRow.get(0);
		id.setText(animal.getCollarId());
		name.setText(animal.getName());
		type.setText(animal.getType());
		desc.setText(animal.getDescription());
		Image img=animal.getImage().getImage();
		image.setImage(img);

	}

}