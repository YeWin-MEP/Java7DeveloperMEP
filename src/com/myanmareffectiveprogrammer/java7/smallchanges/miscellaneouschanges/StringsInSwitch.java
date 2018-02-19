package com.myanmareffectiveprogrammer.java7.smallchanges.miscellaneouschanges;

public class StringsInSwitch {

	public static void main(String args[]) {

		java6PrintDay(2);
		
		java7PrintDay("Friday");
	}

	private static void java6PrintDay(int dayOfWeek) {
		switch (dayOfWeek) {
		case 0:
			System.out.println("Sunday");
			break;
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		default:
			System.err.println("Error!");
			break;
		}
	}

	private static void java7PrintDay(String dayOfWeek) {
		switch (dayOfWeek) {
		case "Sunday":
			System.out.println("Dimanche");
			break;
		case "Monday":
			System.out.println("Lundi");
			break;
		case "Tuesday":
			System.out.println("Mardi");
			break;
		case "Wednesday":
			System.out.println("Mercredi");
			break;
		case "Thursday":
			System.out.println("Jeudi");
			break;
		case "Friday":
			System.out.println("Vendredi");
			break;
		case "Saturday":
			System.out.println("Samedi");
			break;
		default:
			System.out.println("Error: '" + dayOfWeek
					+ "' is not a day of the week");
			break;
		}
	}
}
