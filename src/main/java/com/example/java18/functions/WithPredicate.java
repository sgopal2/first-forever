package main.java.com.example.java18.functions;

import java.util.function.Predicate;

public class WithPredicate {

	public static void main(String[] args) {
	
		//Old approach
		LabBloodGroupTestingMachine<String> oldMachine = new LabBloodGroupTestingMachine<String>(){
			public boolean test(String t){
				System.out.println("Testing blood group : "+t);
				return true;
			}
		};
		
		oldMachine.test("A+");
		
		//New approach
		Predicate<String> newMachine = t -> {
							System.out.println("Testing blood group : "+t);
							return true;
						};
		newMachine.test("B+");
	}

	
	interface LabBloodGroupTestingMachine<T>{
		public boolean test(T t);
	}
}

