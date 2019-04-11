package com.r2b.revision;

public enum TestCouleur {
	MARRON("marron"),
	BLEU("bleu"),
	VERT("vert"),
	VERRON("verron"),
	INCONNU("non d�termin�"),
	ROUGE("rouge mais j'avais piscine...");
	
	private String name = "";
	
	TestCouleur(String n){name = n;}
	public String toString() {return name;}
}
