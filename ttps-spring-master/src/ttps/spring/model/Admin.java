package model;

import java.util.ArrayList;

public class Admin extends User {
	public ArrayList<Vet> vetsForAcept;
	
	public Admin(String name, String password, String surname, String phone, String mail) {
		super(name, password, surname, phone, mail);
		this.vetsForAcept = new ArrayList<Vet> ();
	}
	
	
	public ArrayList<Vet> getVetsForAcept() {
		return vetsForAcept;
	}


	public void setVetsForAcept(ArrayList<Vet> vetsForAcept) {
		this.vetsForAcept = vetsForAcept;
	}


	public void deleteVet(Vet vet) {
		getVetsForAcept().remove(vet);

	}

}
