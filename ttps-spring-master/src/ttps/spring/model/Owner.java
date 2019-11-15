package model;

import java.util.ArrayList;

public class Owner extends User {
	public ArrayList<Pet> pets;
	

	public ArrayList<Pet> getPets() {
		return pets;
	}


	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}


	public Owner(String name, String password, String surname, String phone, String mail) {
		super(name, password, surname, phone, mail);
		this.pets = new ArrayList<Pet>();
		
	}
	
	public void addPet(Pet pet) {
		getPets().add(pet);
	}
	
	public void deletePet(Pet pet) {
		getPets().remove(pet);
	}
	

}
