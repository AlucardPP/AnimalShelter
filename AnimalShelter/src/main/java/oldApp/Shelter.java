/*package oldApp;

import utils.Animals;

public class Shelter {
	private final static int SPACE = 20;
	private Animals[] animals;
	private int regAnimals;

	public Shelter() {
		animals = new Animals[SPACE];
		regAnimals = 0;
	}

	public void addAnimal(Animals animal) {
		if (regAnimals < SPACE) {
			animals[regAnimals] = animal;
			regAnimals++;
		} else {
			System.out.println("Osiągnięto maksymalny limit w schronisku");
		}
	}

	public void printAnimal() {
		for (int i = 0; i < animals.length; i++) {
			System.out.println(animals[i]);
		}
	}

	public void help() {
		System.out.println("Jeżeli chcesz dodać zwierzątko wpisz: " + ShelterOptions.ADD.getDescription());
		System.out.println("Jeżeli chcesz zobaczyć wszystkie zwierzątka w schronisku wpisz: " + ShelterOptions.PRINT.getDescription());
		System.out.println("Jeżeli chcesz wyjść z programu wpisz: " + ShelterOptions.EXIT.getDescription());
		System.out.println("Jeżeli chcesz pomocy wpisz: " + ShelterOptions.HELP.getDescription());
		System.out.println("Co chcesz zrobić:");
	}
}
                             */