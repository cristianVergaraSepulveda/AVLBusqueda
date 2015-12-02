package com.avl.estructura;

public class ArbolBinario {
	NodoArbol raiz;
	public ArbolBinario(){
		raiz= null;		
	}
	public void agregarNodo(int d, String nom){
		NodoArbol nuevo = new NodoArbol(d, nom);
		if(raiz==null){
			raiz=nuevo;
		}else{
			NodoArbol auxiliar = raiz;
			NodoArbol padre;
			
			while(true){
				padre= auxiliar;
				if(d<auxiliar.dato){
					auxiliar= auxiliar.hijoizq;
					if(auxiliar==null){
						padre.hijoizq=nuevo;
						return;
					}
				}else{
					auxiliar= auxiliar.hijoder;
					if(auxiliar==null){
						padre.hijoder= nuevo;
						return;
					}
				}
				
			}
		}
	}
	
	//metodo para saber si raiz esta vacia
	public boolean  estaVacio(){
		return raiz==null;
	}
	public void inOrden(NodoArbol r){
		if(r!=null){
			inOrden(r.hijoizq);
			System.out.println(r.dato);
			inOrden(r.hijoder);
		}
	}
	
	// metodo para recorrer en preorden
	public void preOrden(NodoArbol r){
		if(r!=null){
			System.out.println(r.dato);
			preOrden(r.hijoizq);
			preOrden(r.hijoder);
		}
	}	
	// metodo postOrden
	public void postOrden(NodoArbol r){
		if(r!=null){
			postOrden(r.hijoizq);
			postOrden(r.hijoder);
			System.out.println(r.dato);
		}
	}
	//  metodo para buscar  un  dato
	public NodoArbol buscarNodo(int d){
		NodoArbol aux= raiz;
		while(aux.dato!=d){
			if(d<aux.dato){
				aux=aux.hijoizq;
			}else{
				aux=aux.hijoder;
			}
			if(aux==null){
				return null;
			}
		}
		return aux;
	}
	
	// eliminar nodo 
	public boolean eliminar(int d){
		NodoArbol auxiliar=raiz;
		NodoArbol padre =raiz;
		boolean esHijoIzq=true;
		while(auxiliar.dato!=d){
			padre= auxiliar;
			if(d<auxiliar.dato){
				esHijoIzq=true;
				auxiliar=auxiliar.hijoizq;
			}
			else{
				esHijoIzq= false;
				auxiliar=auxiliar.hijoder;
			}
			if(auxiliar==null){
				return  false;
			}
		}// fin del while
		if(auxiliar.hijoder== null && auxiliar.hijoizq== null){
			if(auxiliar==raiz){
				raiz=null;
			}else if(esHijoIzq){
				padre.hijoizq=null;
			}else{
				padre.hijoder= null;
			}
			
		}else if(auxiliar.hijoder== null){
			if(auxiliar==raiz){
				raiz=auxiliar.hijoizq;
			}else if(esHijoIzq){
				padre.hijoizq=auxiliar.hijoizq;
			}else{
				padre.hijoder=auxiliar.hijoizq;
			}
		}else if( auxiliar.hijoizq== null){
			if(auxiliar==raiz){
				raiz=auxiliar.hijoder;
			}else if(esHijoIzq){
				padre.hijoizq=auxiliar.hijoder;
			}else{
				padre.hijoder=auxiliar.hijoizq;
			}
		}else{
			NodoArbol remplazo= obtenerNodoRemplazo(auxiliar);
			if(auxiliar==raiz){
				raiz=remplazo;				
			}else{
				padre.hijoder= remplazo;
			}
			remplazo.hijoizq=auxiliar.hijoizq;
		} 		
		return true;
	}
	// metodo encargado de devolver el nodo remplazo
	public NodoArbol obtenerNodoRemplazo(NodoArbol nodoReemp){
		NodoArbol remplazarPadre=nodoReemp;
		NodoArbol reemplazo= nodoReemp;
		NodoArbol auxiliar=nodoReemp.hijoder;
		while(auxiliar!=null){
			remplazarPadre=reemplazo;
			reemplazo= auxiliar;
			auxiliar=auxiliar.hijoizq;
		}
		if(reemplazo!=nodoReemp.hijoder){
			remplazarPadre.hijoizq= reemplazo.hijoder;
			reemplazo.hijoder= nodoReemp.hijoder;
		} 
		System.out.println("el nodo reeemplazo es: "+reemplazo);
		return reemplazo;
	}
	
}
