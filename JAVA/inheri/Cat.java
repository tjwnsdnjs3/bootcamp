package javaFund.inheri;

public class Cat extends Animal {
	
	public String name;
	public String breed;
	
	public Cat(String name, String breed) {
		super("고양이");
		this.name = name;
		this.breed = breed;
	}
	public String toString() {
		return super.toString() + " 이름은 " + name + " 품종은 " + breed;
	}
	public void sound() {
		System.out.println("미야옹미야옹");
	}
	
}
