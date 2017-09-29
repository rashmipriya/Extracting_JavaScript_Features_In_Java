package readingFiles;

import java.util.*; 

public class Features {
	
	private float count_of_words;
	private float count_of_lines;
	private float count_of_comments;
	private float count_of_characters;
	private float count_of_average_number_of_characters_per_line;
	private float count_of_eval;
	//private float count_of_functions;
	private float count_of_hex_numbers;
	private float count_of_human_readable;
	private float count_number_of_whitespaces;
	private float count_of_unicodes;
	private float percentage_of_lines_more_thousand;
	//private float is_obfuscated;
	int [] n = new int[64];
	
	public Features() {
		super();
	}
	
	
	public Features(float count_of_words, float count_of_lines, float count_of_comments, float count_of_characters,
			float count_of_average_number_of_characters_per_line, float count_of_eval, float count_of_hex_numbers,
			float count_of_human_readable, float count_number_of_whitespaces, float count_of_unicodes,
			float percentage_of_lines_more_thousand, int[] n) {
		super();
		this.count_of_words = count_of_words;
		this.count_of_lines = count_of_lines;
		this.count_of_comments = count_of_comments;
		this.count_of_characters = count_of_characters;
		this.count_of_average_number_of_characters_per_line = count_of_average_number_of_characters_per_line;
		this.count_of_eval = count_of_eval;
		this.count_of_hex_numbers = count_of_hex_numbers;
		this.count_of_human_readable = count_of_human_readable;
		this.count_number_of_whitespaces = count_number_of_whitespaces;
		this.count_of_unicodes = count_of_unicodes;
		this.percentage_of_lines_more_thousand = percentage_of_lines_more_thousand;
		this.n = Arrays.copyOf(n,  n.length);
	}


	public float getPercentage_of_lines_more_thousand() {
		return percentage_of_lines_more_thousand;
	}

	public void setPercentage_of_lines_more_thousand(float percentage_of_lines_more_thousand) {
		this.percentage_of_lines_more_thousand = percentage_of_lines_more_thousand;
	}

	public float getCount_of_average_number_of_characters_per_line() {
		return count_of_average_number_of_characters_per_line;
	}

	public void setCount_of_average_number_of_characters_per_line(float count_of_average_number_of_characters_per_line) {
		this.count_of_average_number_of_characters_per_line = count_of_average_number_of_characters_per_line;
	}

	public float getCount_of_unicodes() {
		return count_of_unicodes;
	}

	public void setCount_of_unicodes(float count_of_unicodes) {
		this.count_of_unicodes = count_of_unicodes;
	}

	public float getCount_number_of_whitespaces() {
		return count_number_of_whitespaces;
	}


	public void setCount_number_of_whitespaces(float count_number_of_whitespaces) {
		this.count_number_of_whitespaces = count_number_of_whitespaces;
	}


	public float getCount_of_hex_numbers() {
		return count_of_hex_numbers;
	}


	public void setCount_of_hex_numbers(float count_of_hex_numbers) {
		this.count_of_hex_numbers = count_of_hex_numbers;
	}


	public float getCount_of_words() {	
		return count_of_words;
	}
	public void setCount_of_words(float count_of_words) {
		this.count_of_words = count_of_words;
	}
	public float getCount_of_lines() {
		return count_of_lines;
	}
	public void setCount_of_lines(float count_of_lines) {
		this.count_of_lines = count_of_lines;
	}
	public float getCount_of_comments() {
		return count_of_comments;
	}
	public void setCount_of_comments(float count_of_comments) {
		this.count_of_comments = count_of_comments;
	}
	public float getCount_of_characters() {
		return count_of_characters;
	}
	public void setCount_of_characters(float count_of_characters) {
		this.count_of_characters = count_of_characters;
	}
	public float getCount_of_eval() {
		return count_of_eval;
	}
	public void setCount_of_eval(float count_of_eval) {
		this.count_of_eval = count_of_eval;
	}
	public float getCount_of_human_readable() {
		return count_of_human_readable;
	}
	public void setCount_of_human_readable(float count_of_human_readable) {
		this.count_of_human_readable = count_of_human_readable;
	}
	public int[] getN() {
		return Arrays.copyOf(n,n.length);
	}
	public void setN(int[] n) {
		this.n = Arrays.copyOf(n, n.length);
	}
	
}