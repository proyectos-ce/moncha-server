package cr.tec.utils.sort;

import cr.tec.struct.*;
import cr.tec.struct.generic.GenericList;


public class Radix {
	public static void radixSort(GenericList<Ingredient> list){
			int w =0;
	        int n = list.getLength();
	        int R = 256;

	        /////SEARCHES FOR THE STRING WITH MAJOR AMOUNT OF CHARACTERS
	        for (int i = 0; i < n; i++){
	        	if(list.getAt(i).getData().getName().length()>w)w = list.getAt(i).getData().getName().length();
			}
	        
	        //FIXES THE LENGHT OF THE OTHER STRINGS
	        for (int i=0; i<n; i++){
	        	if(list.getAt(i).getData().getName().length()<w){
	        		for(int add = w - list.getAt(i).getData().getName().length(); add > 0; add--){
	        			list.getAt(i).getData().setName(list.getAt(i).getData().getName() + " ");
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
	            	
	            	count1.getAt(list.getAt(i).getData().getName().charAt(d) +1).setData((count1.getAt(list.getAt(i).getData().getName().charAt(d) +1).getData()+1));
	            	
	            }
	            // DOES THE ADJUSTMENT
	            for (int r = 0; r < R; r++){

	            	count1.getAt(r+1).setData(count1.getAt(r).getData() + count1.getAt(r+1).getData());
	            	
	            }
	            //DOES THE REARRANGING
	            for (int i = 0; i < n; i++){

	            	aux1.getAt(count1.getAt(list.getAt(i).getData().getName().charAt(d)).getData()).setData(list.getAt(i).getData().getName());
	            	count1.getAt(list.getAt(i).getData().getName().charAt(d)).setData(count1.getAt(list.getAt(i).getData().getName().charAt(d)).getData()+1);

	            }
	            // REARRANGES THE INPUT LIST
	            for (int i = 0; i < n; i++){
	            	list.getAt(i).getData().setName(aux1.getAt(i).getData());
	            	
	            }
	            
	        }
	        
	        for(int i = 0; i<n; i++){
	        	list.getAt(i).getData().setName(list.getAt(i).getData().getName().replaceAll("\\s", ""));
	        }
	        
	        for(int i = 0; i<n; i++){
	        	list.getAt(i).getData().setId(i+61);
	        }
	        
	    }

	}


