package com.hiq;

@FunctionalInterface	
interface Executable{
	void execute();
}

class Base implements Executable{
	public void test(Executable exe){
		System.out.println("Test Method");
		exe.execute();
	}

	@Override
	public void execute() {
		System.out.println("execute Method");
		
	}
}

public class Intercheck {
	public static void main(String[] args) {
		Base base = new Base();
		/*base.test(new Executable() {
			@Override
			public void execute() {
				System.out.println("Intercheck Method");
			}
		});
		*/
		/*base.test(() -> System.out.println("Intercheck Method"));
		base.execute();*/
		
		Executable e = ()->System.out.println("new imp Method");
		e.execute();
	}
}
