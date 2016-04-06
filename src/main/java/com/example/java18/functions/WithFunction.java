package main.java.com.example.java18.functions;

import java.util.function.Function;

public class WithFunction {

	public static void main(String[] args) {
		//old approach
		Converter<Integer, String> intToString = new Converter<Integer, String>(){
			public String convert(Integer i){
				return i.toString();
			}
		};
		
		Converter<String, Integer> stringToInt = new Converter<String, Integer>(){
			public Integer convert(String s){
				return Integer.parseInt(s);
			}
		};
		
		System.out.println("intToString "+ intToString.convert(12));
		System.out.println("stringToInt "+ stringToInt.convert("123"));
		
		//new approach - 1
		Function<Integer, String> iToS = i -> i.toString();
		Function<String, Integer> sToI = s -> Integer.parseInt(s);
		System.out.println("intToString "+iToS.apply(12));
		System.out.println("stringToInt "+sToI.apply("123"));
		
		//new approach - 2
		doTest(i -> i.toString(), 12);
		doTest(s -> Integer.parseInt(s), "123");
	}

	private static void doTest(Function<Integer, String> f, Integer i){
		System.out.println("intToString "+f.apply(i));
	}
	
	private static void doTest(Function<String, Integer> f, String i){
		System.out.println("stringToInt "+f.apply(i));
	}
	
}

interface Converter<I, O>{
	O convert(I i);
}