package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PerdicatePerformance {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i< 100000; i++){
			list.add(i);
			//System.out.println(i + i%2);
			} 
		long startTime = System.currentTimeMillis();
		//Stream<Integer> stream = list.stream();
		//Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
		//Integer[] array = stream.parallel().toArray(Integer[]::new);
		//System.out.println(stream.parallel());
		Integer[] array = list.stream().filter(i->i%2==0).toArray(Integer[]::new);
		System.out.println(array);
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		startTime = System.currentTimeMillis();
		Integer[] evenNumbersArr2 = new Integer[list.size()];
		for(Integer i : list){
		if(i%2 == 0) evenNumbersArr2[i] = i;
		}
		System.out.println(evenNumbersArr2);

		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		}
}
