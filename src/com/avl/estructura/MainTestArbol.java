package com.avl.estructura;

import javax.swing.JOptionPane;

public class MainTestArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option=0, elemento;
		String nombre;
		ArbolBinario arbolito = new ArbolBinario();
		do{
			try{
				option= Integer.parseInt(JOptionPane.showInputDialog(null, 
						"1. agregar un nodo\n"
						+ "2. recorrer inOrden \n "
						+ "3. recorrer PreOrden \n "
						+ "4. recorrer PostOrden \n "
						+ "5. recorrer PostOrden \n "
						+ "6. salir \n "
						+ "Elige una opcion ", JOptionPane.QUESTION_MESSAGE));
				switch(option){
				case 1:
					elemento =Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Ingresa el numero del nodo","Agregando nodo",
							JOptionPane.QUESTION_MESSAGE));
					nombre = JOptionPane.showInputDialog(null, 
							"Ingresar nombre del nodo","Agregando nodo",
							JOptionPane.QUESTION_MESSAGE);
					arbolito.agregarNodo(elemento, nombre);
					break;
				case 2:
					if(!arbolito.estaVacio()){
						arbolito.inOrden(arbolito.raiz);
					}else{
						JOptionPane.showInputDialog(null, 
								"raiz esta vacio","fin",
								JOptionPane.QUESTION_MESSAGE);
					}
					break;
				case 3:
					if(!arbolito.estaVacio()){
						arbolito.preOrden(arbolito.raiz);
					}else{
						JOptionPane.showInputDialog(null, 
								"raiz esta vacio","fin",
								JOptionPane.QUESTION_MESSAGE);
					}
					break;
				case 4:
					if(!arbolito.estaVacio()){
						arbolito.postOrden(arbolito.raiz);
					}else{
						JOptionPane.showInputDialog(null, 
								"raiz esta vacio","fin",
								JOptionPane.QUESTION_MESSAGE);
					}
					break;
				case 5:
					if(!arbolito.estaVacio()){
						elemento =Integer.parseInt(JOptionPane.showInputDialog(null, 
								"Ingresa el numero del nodo buscado..","Agregando nodo",
								JOptionPane.QUESTION_MESSAGE));
						arbolito.buscarNodo(elemento);
						if(arbolito.buscarNodo(elemento)==null){
							JOptionPane.showInputDialog(null, 
									"El nodo no se encuentra en el arbol","fin",
									JOptionPane.QUESTION_MESSAGE);
						}
						else{
							System.out.println("Nodo Encontrado, sus datos son:"+arbolito.buscarNodo(elemento));
						} 
					}else{
						JOptionPane.showInputDialog(null, 
								"raiz esta vacio","fin",
								JOptionPane.QUESTION_MESSAGE);
					}
					
					break;
				case 6:
					if(!arbolito.estaVacio()){
						elemento =Integer.parseInt(JOptionPane.showInputDialog(null, 
								"Ingresa el numero del nodo a eliminar..","eliminar nodo nodo",
								JOptionPane.QUESTION_MESSAGE));
						arbolito.buscarNodo(elemento);
						
						if(arbolito.eliminar(elemento)==false){
							JOptionPane.showInputDialog(null, 
									"El nodo no se encuentra en el arbol","fin",
									JOptionPane.QUESTION_MESSAGE);
						}
						else{
							JOptionPane.showInputDialog(null, 
									"El nodo ha sido eliminado del arbol","fin",
									JOptionPane.QUESTION_MESSAGE);
						} 
					}else{
						JOptionPane.showInputDialog(null, 
								"raiz esta vacio","fin",
								JOptionPane.QUESTION_MESSAGE);
					}
					break;
				case 7:
					JOptionPane.showInputDialog(null, 
							"Aplicacion finalizada","fin",
							JOptionPane.QUESTION_MESSAGE);
					break;
				default:
					JOptionPane.showInputDialog(null, 
							"Opcion Incorrecta","Cuidado",
							JOptionPane.QUESTION_MESSAGE);
				} 
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "Error"+ n.getMessage());
			}
		}while(option!=7);
	}

}
