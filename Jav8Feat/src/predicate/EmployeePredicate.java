package predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeePredicate {

	public static Predicate<Employee> isAge(){
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}
	
	public static List<Employee> getPredicateResult(List<Employee> emp,Predicate<Employee> pre){
		return emp.stream().filter(pre).collect(Collectors.<Employee>toList());
	}
}
