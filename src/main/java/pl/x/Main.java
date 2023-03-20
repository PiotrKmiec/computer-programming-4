package pl.x;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<String> names = Arrays.asList("Piotr","Ewelina","Grzegorz","Aleksandra");

	    names
				.stream()
				.filter(name -> name.endsWith("a"))
				.map(String::toUpperCase)
				.forEach((new Greeter())::greet);
    }
}
