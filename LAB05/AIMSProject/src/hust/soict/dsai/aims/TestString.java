package hust.soict.dsai.aims;

public class TestString {
	public static void main(String[] args) {
		String party1 = "party";
		String party2 = party1.toLowerCase();
		if(party1==party2){
		   System.out.println("party1 party2 REF TO SAME MEM");
		}else{
		   System.out.println("party1 party2 NOT SAME MEM");
		}
		String party3 = new String("party");
		String party4 = party3.toLowerCase();
		if(party3==party4){
		   System.out.println("party3 party4 REF TO SAME MEM");
		}else{
		   System.out.println("party3 party4 NOT SAME MEM");
		}
		String party5 = "Party";
		String party6 = party5.toLowerCase();

		if(party2==party6){
		   System.out.println("party2 party6 REF TO SAME MEM");
		}else{
		   System.out.println("party2 party6 NOT SAME MEM");
		}
		if(party4==party6){
		   System.out.println("party4 party6 REF TO SAME MEM");
		}else{
		   System.out.println("party4 party6 NOT SAME MEM");
		}
		String party7 = new String("Party");
		String party8 = party7.toLowerCase();
		if(party7==party8){
		   System.out.println("party7 party8 REF TO SAME MEM");
		}else{
		   System.out.println("party7 party8 NOT SAME MEM");
		}
		if(party2==party8){
		   System.out.println("party2 party8 REF TO SAME MEM");
		}else{
		   System.out.println("party2 party8 NOT SAME MEM");
		}
		if(party4==party8){
		   System.out.println("party4 party8 REF TO SAME MEM");
		}else{
		   System.out.println("party4 party8 NOT SAME MEM");
		}
	}
}
