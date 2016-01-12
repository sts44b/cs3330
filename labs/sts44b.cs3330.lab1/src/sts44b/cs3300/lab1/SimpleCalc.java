package sts44b.cs3300.lab1;

public class SimpleCalc {
	private double num1;
	private double num2;

	public SimpleCalc(double x, double y) {
		setNum1(x);
		setNum2(y);
	}

	private void setNum1(double num1){
		this.num1 = num1;
	}
	
	private void setNum2(double num2){
		this.num2 = num2;
	}
	
	public double getNum1(){
		return this.num1;
	}
	
	public double getNum2(){
		return this.num2;
	}
	
	public double addNumbers(){
		return this.getNum1() + this.getNum2();
	}

	public double subtractNumbers(){
		return this.getNum1() - this.getNum2();
	}
	
	public double multiplyNumbers(){
		return this.getNum1() * this.getNum2();
	}
	
	public double divideNumbers(){
		if (num2 == 0){
			System.exit(1);
		}
		return this.getNum1() / this.getNum2();
	}
}
