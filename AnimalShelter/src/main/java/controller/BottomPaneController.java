package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import utils.Animals;

public class BottomPaneController implements Initializable {

	@FXML
	private TableColumn<Animals, String> petNameColumn;

	@FXML
	private Button deleteButton;

	@FXML
	private TableColumn<Animals, ImageView> imageColumn;

	@FXML
	private TableColumn<Animals, String> typeOfAnimalColumn;

	@FXML
	private TableView<Animals> tableView;

	@FXML
	private TableColumn<Animals, String> collarIdColumn;

	@FXML
	private Button viewButton;

	@FXML
	private TableColumn<Animals, String> descriptionColumn;

	public Button getViewButton() {
		return viewButton;
	}

	public TableView<Animals> getTableView() {
		return tableView;
	}

	public TableColumn<Animals, String> getPetNameColumn() {
		return petNameColumn;
	}

	public TableColumn<Animals, ImageView> getImageColumn() {
		return imageColumn;
	}

	public TableColumn<Animals, String> getTypeOfAnimalColumn() {
		return typeOfAnimalColumn;
	}

	public TableColumn<Animals, String> getCollarIdColumn() {
		return collarIdColumn;
	}

	public TableColumn<Animals, String> getDescriptionColumn() {
		return descriptionColumn;
	}

	public void initialize(URL location, ResourceBundle resources) {
		deleteSingleRow();

	}

	private void deleteSingleRow() {
		deleteButton.setOnAction(event -> {
			ObservableList<Animals> singleRow = tableView.getSelectionModel().getSelectedItems();
			Animals animal = singleRow.get(0);
			tableView.getItems().remove(animal);
		});
	}

	public boolean checkSizeOfTable(int maxSize) {
		int size = tableView.getItems().size();
		if (size < maxSize) {
			return true;
		}

		else
			return false;
	}

}
