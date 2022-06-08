package eu.ase.test;

// This is the Java code playground
class Container {
private String name;
private static Container instance = null;
private Container() {
this.name = "NA";
}
public static Container getInstance() {
if (instance == null) {
instance = new Container();
}
return instance;
}
public void setName(String x) {
this.name = x;
}
public String getName() {
return this.name;
}
}


public class ProgMain {

	public static void main(String[] args) {
		Container ob1 =Container.getInstance();
		Container ob2 = Container.getInstance();
		ob1.setName("Container 1");
		ob2.setName("Container 2");
		System.out.println("s1="+ob1.getName()+",s2=" + ob2.getName());
	}

}
