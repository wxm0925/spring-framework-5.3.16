package aop.step1;

public class SimpleService implements ISimpleService{
	@Override
    public void doSomething() {
        System.out.println("SimpleService: Doing something...");
    }
}