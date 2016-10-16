package Sorting;

import Structures.GenericList;

public class Radix {
	public static void radixSort(GenericList<String> list){
			int w =0;
	        int n = list.getLenght();
	        int R = 256;

	        /////SEARCHES FOR THE STRING WITH MAJOR AMOUNT OF CHARACTERS
	        for (int i = 0; i < n; i++){
	        	if(list.getAt(i).getDato().length()>w)w = list.getAt(i).getDato().length();
			}
	        
	        //FIXES THE LENGHT OF THE OTHER STRINGS
	        for (int i=0; i<n; i++){
	        	if(list.getAt(i).getDato().length()<w){
	        		for(int add = w - list.getAt(i).getDato().length(); add > 0; add--){
	        			list.getAt(i).setDato(list.getAt(i).getDato() + " ");
	        		}
	        	}
	        }
	        
	        //GENERATES THE LIST OF REARRANGING
	        GenericList<String> aux1 =  new GenericList<String>();
	        for(int k = 0; k < n; k++){
	        	aux1.addFirst("");
	        }

	        
	        for (int d = w-1; d >= 0; d--) {

	        	//GENERATES THE LIST FOR COUNTING THE NUMBER OF APPARITIONS OF
	            GenericList<Integer> count1 =  new GenericList<Integer>();
	            for(int k =0; k < R+1; k++){
	            	count1.addFirst(0);
	            }
	            
	            // DOES THE COUNTING METHOD
	            for (int i = 0; i < n; i++){
	            	
	            	count1.getAt(list.getAt(i).getDato().charAt(d) +1).setDato((count1.getAt(list.getAt(i).getDato().charAt(d) +1).getDato()+1));

	            }
	            // DOES THE ADJUSTMENT
	            for (int r = 0; r < R; r++){

	            	count1.getAt(r+1).setDato(count1.getAt(r).getDato() + count1.getAt(r+1).getDato());

	            }
	            //DOES THE REARRANGING
	            for (int i = 0; i < n; i++){
	            	aux1.getAt(count1.getAt(list.getAt(i).getDato().charAt(d)).getDato()).setDato(list.getAt(i).getDato());
	            	count1.getAt(list.getAt(i).getDato().charAt(d)).setDato(count1.getAt(list.getAt(i).getDato().charAt(d)).getDato()+1);

	            }
	            // REARRANGES THE INPUT LIST
	            for (int i = 0; i < n; i++){
	            	list.getAt(i).setDato(aux1.getAt(i).getDato());
	            	
	            }
	            
	        }
	        
	        for(int i = 0; i<n; i++){
	        	list.getAt(i).setDato(list.getAt(i).getDato().replaceAll("\\s", ""));
	        }
	        
	    }

	}


