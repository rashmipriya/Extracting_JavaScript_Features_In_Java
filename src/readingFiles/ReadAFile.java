package readingFiles;

import java.io.*;
import java.util.*;
import java.text.*;

public class ReadAFile {
	
	public static String LinkFile(String link){
		return ("C:\\Users\\singhal\\workspace\\javascripts\\" + link);
	}
	
	public static void main(String[] args) throws IOException {
		
		try{
		String COMMA_DELIMITER =",";
		String NEW_LINE_SEPARATOR="\n";
		String FILE_HEADER ="count_of_words,number_of_lines,count_of_comments,count_of_average_number_of_characters, count_of_average_number_of_characters_per_line, count_of_eval, count_of_human_readable,count_of_hex_numbers,count_of_whitespaces,count_of_unicodes,percentage_of_lines_more_thousand";
		List<Features> listfeatures = new ArrayList<Features>();
		
		File folder = new File("C:\\Users\\singhal\\workspace\\javascripts");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      float count_of_words=0, count_of_lines=0, count_of_comments=0, count_of_functions=0, count_of_characters=0, count_of_average_number_of_characters=0, count_of_eval=0, count_of_human_readable=0, count_of_alphabets=0, count_of_vowels=0, count_of_repititions=0, percentage_of_vowels=0, count_number_of_whitespaces=0, count_of_total_number_of_characters_in_a_file=0, count_of_average_number_of_characters_per_line =0, count_of_number_of_words_in_comments =0,count_of_hex_numbers=0,count_of_unicodes=0,percentage_of_lines_more_thousand=0;
		      int [] n = new int[64];
		      if (listOfFiles[i].isFile()) {
		        System.out.println(listOfFiles[i].getName());
		        String link = listOfFiles[i].getName();
		        String new_link = LinkFile(link);
		        System.out.println(new_link);
		        ArrayList<String> reservedwords= new ArrayList();
		        Collections.addAll(reservedwords, "abstract", "break", "await","boolean","arguments","byte","case", "catch","char","class","const","continue","debugger","default","delete","do","double","else","enum","eval","export","extends","false","final","finally","float","for","function","goto","if","implements","import","in","instanceof","int","interface","let","long","native","new","null","package","private","protected","public","return","short","static","super","switch","synchronized","this","throw","throws","transient","true","try","typeof","var","void","volatile","while","with", "yield");
		        int numbers = reservedwords.size();
		        Scanner input = new Scanner(new File(new_link));
		        while(input.hasNext()){
		        	count_of_characters=0;
		        	float percentage_of_alphabets = 0;
				    String token = input.next();
					count_of_words ++;
					if((token.equals("//")) || (token.equals("/*"))){
						count_of_comments++;
					}
					for(int j=1; j<= token.length(); j++){
						count_of_characters++;
						count_of_total_number_of_characters_in_a_file++;
					}
					//System.out.println("Number of characters for " + token +" is " + count_of_characters);
					if(token.length() > 3){
						 for(int j=0; j <= token.length()-4 ; j++){
							if(token.substring(j, j+4).equals("eval")){
								count_of_eval++;
							 }
						 }
						 for(int l=0; l <= token.length()-3 ; l++){
							if((token.substring(l, l+2).equals("0x")) ||(token.substring(l,l+2).equals("-0x"))){
								count_of_hex_numbers++;
							}
						  }
						 for(int l=0; l <= token.length()-7 ; l++){
								if((token.substring(l, l+6).equals("\u0123"))){
									count_of_unicodes++;
								}
							  }
						} 
						for(int k=0; k < 64; k++){
						   String reserved = reservedwords.get(k);
						   System.out.println(reserved);
						   int number = reserved.length();
						   System.out.println(reserved.length());
							if(token.length() >= number){
								for(int j=0; j <= token.length()-number; j++){
									if(token.substring(j, j+number).equals(reserved)){
										n[k]++;
										}
									 }
								}
							}
					int length_of_token = token.length() - 1;
					count_of_alphabets = 0;
					count_of_vowels=0;
					count_of_repititions=1;
					char previous_character = 0;
					while (length_of_token != -1) {
						char current_character = token.charAt(length_of_token);
						if (previous_character == current_character){
							count_of_repititions++;
						}
					    //System.out.println(current_character + "\t");
					    if (Character.toString(current_character).matches("[a-z?]") || Character.toString(current_character).matches("[A-Z?]")) {
					    	count_of_alphabets++;
					    }
					    if (token.charAt(length_of_token) == 'A' || token.charAt(length_of_token) == 'a' || token.charAt(length_of_token) == 'E' || token.charAt(length_of_token) == 'e' || token.charAt(length_of_token) == 'I' || token.charAt(length_of_token) == 'i' || token.charAt(length_of_token) == 'O' || token.charAt(length_of_token) == 'o' || token.charAt(length_of_token) == 'U' || token.charAt(length_of_token) == 'u') {
					    	count_of_vowels++;
					    }
					    previous_character = token.charAt(length_of_token);
					    length_of_token = length_of_token - 1;
					 }
					System.out.println("Count of Characters" + count_of_characters);
					System.out.println("Count of Alphabets" + count_of_alphabets);
					System.out.println("Count of Vowels" + count_of_vowels);
					System.out.println("Count of Repititions" + count_of_repititions);
					percentage_of_alphabets = count_of_alphabets/count_of_characters;
					percentage_of_vowels = count_of_vowels/count_of_characters;
					System.out.println("percentage_of_alphabets" + percentage_of_alphabets);
					System.out.println("percentage_of_vowels" + percentage_of_vowels);
					if(percentage_of_alphabets >= 0.7 && (percentage_of_vowels> 0.2 && percentage_of_vowels < 0.6) && (count_of_characters < 15) && count_of_repititions < 3 ){
					System.out.println("Yes " + token + " is readable");
					count_of_human_readable++; 
					}
					else{
						System.out.println("No " + token + " is not readable");
					}
			        System.out.println("-------------------------------------");
			        count_number_of_whitespaces++;
		        }
		        System.out.println("Number of words are " + count_of_words);
		        System.out.println("Number of comments are " + count_of_comments);
		        System.out.println("Total number of characters in a file " + count_of_total_number_of_characters_in_a_file);
		        count_of_average_number_of_characters =  count_of_total_number_of_characters_in_a_file/count_of_words;
		        System.out.println("Average Number of characters in a file " + count_of_average_number_of_characters);
		        System.out.println("Number of eval keywords are " + count_of_eval);
		        System.out.println("Number of human readable words are " + count_of_human_readable);
		        System.out.println("Number of whitespaces in the file " + count_number_of_whitespaces);
		        Scanner input1 = new Scanner(new File(new_link));
		        
		        while(input1.hasNextLine()){
				     input1.nextLine();
					 count_of_lines ++;
				}
		        
				System.out.println("Number of lines is " + count_of_lines);
				count_of_average_number_of_characters_per_line =  count_of_total_number_of_characters_in_a_file/count_of_lines;
				if(count_of_average_number_of_characters_per_line > 1000)
					percentage_of_lines_more_thousand++;
		        System.out.println("Average Number of characters per line " + count_of_average_number_of_characters_per_line);
				
				Scanner input2 = new Scanner(new File(new_link));
				//if we want all the metrics like number of words, characters without the words and characters in the comments
				/*while(input2.hasNext()){
					String token = input.next();
					if((token.equals("//")) || (token.equals("/*"))){
						for(int loop=1; loop<= endOfLine(); loop++){
						     
						}
					}
				} */
				
				/* while (input2.hasNextLine()) {
					  String line = input2.nextLine();
					  System.out.println("I am here " + line);
					  String next_word = input2.next();
					  //Scanner lineScanner = new Scanner(line);
					  if((next_word.equals("//")) || (next_word.equals("/*"))){
						System.out.println("The comment is ");
					    while (input2.hasNext()) {
					    String text = input2.next();
					    count_of_number_of_words_in_comments++;
					    System.out.println(text);
					  }
					  //lineScanner.close();
					  // you're at the end of the line here. Do what you have to do.
				} 
				} */
		        
		      	listfeatures.add(new Features(count_of_words, count_of_lines, count_of_comments, count_of_average_number_of_characters, count_of_average_number_of_characters_per_line, count_of_eval, count_of_human_readable, count_of_hex_numbers, count_number_of_whitespaces, count_of_unicodes, percentage_of_lines_more_thousand, n));
		      
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    
		    FileWriter fileWriter = new FileWriter("src\\data\\listFeatures.csv");
			fileWriter.append(FILE_HEADER);
		    
		    for(Features F : listfeatures){
		    	int numbb[] = new int[64];
		    	fileWriter.append(NEW_LINE_SEPARATOR);
		    	fileWriter.append(String.valueOf(F.getCount_of_words()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_lines()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_comments()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_characters()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_average_number_of_characters_per_line()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_eval()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_human_readable()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_hex_numbers()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_number_of_whitespaces()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getCount_of_unicodes()));
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(F.getPercentage_of_lines_more_thousand()));
		    	numbb = F.getN();
		    	for(int increment=0; increment < 64; increment++){
		    	fileWriter.append(COMMA_DELIMITER);
		    	fileWriter.append(String.valueOf(numbb[increment]));
		    	}
		    }
		    fileWriter.flush();
	    	fileWriter.close();
	    	System.out.println("Done");
	}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}

}
	
}
