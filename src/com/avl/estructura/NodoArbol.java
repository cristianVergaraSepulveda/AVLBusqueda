package com.avl.estructura;

public class NodoArbol {
	int dato;
	String nombre;
	NodoArbol hijoizq, hijoder;
	public NodoArbol(int a, String nom){
		this.dato=a;
		this.nombre=nom;
		this.hijoizq=null;
		this.hijoder=null;
	}
	
	public String toString(){
		return nombre +" Su dato es "+ dato;
	}
}
