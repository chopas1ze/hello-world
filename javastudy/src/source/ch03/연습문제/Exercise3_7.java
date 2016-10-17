package source.ch03.연습문제;
class Exercise3_7 {
	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (int)(((fahrenheit-32)*5/9f)*100+0.5f)/100f;
		
		
		
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
	}
}
