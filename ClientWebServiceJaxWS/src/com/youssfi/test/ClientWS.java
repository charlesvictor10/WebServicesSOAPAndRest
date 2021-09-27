package com.youssfi.test;

import java.util.List;

import com.youssfi.service.BanqueService;
import com.youssfi.service.BanqueWS;
import com.youssfi.service.Compte;

public class ClientWS {

	public static void main(String[] args) {
		BanqueService stub = new BanqueWS().getBanqueServicePort();
		System.out.println("Conversion");
		System.out.println(stub.conversionEuroToDh(9000));
		System.out.println("Consulter un compte");
		Compte cp = stub.getCompte(2L);
		System.out.println("Solde="+cp.getSolde());
		System.out.println("Liste des comptes");
		List<Compte> cptes = stub.getComptes();
		for(Compte c: cptes) {
			System.out.println(c.getCode()+"----"+c.getSolde());
		}
	}
}
