package utils;

import javafx.scene.image.ImageView;

public class Animals {
	private String collarId;
	private String name;
	private String type;
	private String description;
	private ImageView image;

	public Animals(String id, String name, String type, String description, ImageView imageview) {
		this.collarId = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.image = imageview;
	}

	public Animals() {
	}

	public String getCollarId() {
		return collarId;
	}

	public void setCollarId(String collarId) {
		this.collarId = collarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ImageView getImage() {
		return image;
	}

	public void setImage(ImageView image) {
		this.image = image;
	}

}