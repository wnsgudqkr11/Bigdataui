package Ch19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Func1 {
	void say (String message);
}

@FunctionalInterface
interface Func2{
	int sum(Integer ...args);
}

@FunctionalInterface
interface Func3{
	List<Integer> sum (Object... args);
}

public class C01FunctionalInterfaceMain {

	public static void main(String[] args) {
		// 01
		Func1 func1 = (message) -> {System.out.println(message + "_!");};
		func1.say("Hi");
		
		Func1 func1_2 = System.out::println;
		func1_2.say("HI");
		
		// 02
		Func2 func2 = (arr)->{
			int sum = 0;
			for(Integer  n : arr)
				sum += n;
			return sum;
		};
		System.out.println(func2.sum(10,20,30,40,50,60));
		
		//03
		Func3 func3 = (arr) -> {
			return Arrays.stream(arr)
//						.filter((obj)->{return obj instanceof Integer;})
//						.filter(obj-> obj instanceof Integer)
						
						.map((obj)->{return (Integer)obj;})
						.collect(Collectors.toList());
		};
		System.out.println(func3.sum(10,20,30.5,"PJH", true));
	
		
	}

}
