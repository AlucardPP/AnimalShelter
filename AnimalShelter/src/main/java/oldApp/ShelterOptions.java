/*package oldApp;

import java.util.Scanner;

import utils.Animals;

public enum ShelterOptions {
	HELP("help"), ADD("add"), PRINT("print"), EXIT("exit"),DEFAULT("something goes wrong");

	private String description;
	static Shelter shelter=new Shelter();

	private ShelterOptions(String desc) {
		this.description = desc;

	}

	public String getDescription() {
		return description;
	}

	static ShelterOptions chooseDescripton(String desc) {
		for (ShelterOptions so : ShelterOptions.values()) {
			if (so.getDescription().equals(desc)) {
				return so;
			}

		}
		return ShelterOptions.DEFAULT;

	}
	public static void choose(Scanner sc) {

		String opt;
		boolean check = false;
		while (check != true) {
			opt = sc.nextLine();
			ShelterOptions so = ShelterOptions.chooseDescripton(opt);

			switch (so) {
			case ADD:
				Animals animal = new Animals();
				System.out.println("Podaj numer obrożyt: ");
				animal.setId(sc.nextLine());
				sc.nextLine();
				System.out.println("Podaj imie zwierzaka: ");
				animal.setName(sc.nextLine());
				System.out.println("Podaj typ zwierzaka: ");
				animal.setType(sc.nextLine());
				shelter.addAnimal(animal);
				shelter.help();
				break;
			case HELP:
				shelter.help();
				break;
			case PRINT:
				shelter.printAnimal();
				shelter.help();
				break;
			case EXIT:
				System.out.println("Wychodzisz z programu. Pa pa");
				check = true;
				break;
			default:
				System.out.println("Wybraeś niewasciwą opcj spróbuj ponownie");
				shelter.help();
				break;

			}

		}
	}
}
*/