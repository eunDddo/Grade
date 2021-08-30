//류은서 2019100867
package assignment1;

import java.util.Scanner;

public class Grade {
	public static int id;
	public static double score;

	// ===================숫자 3개의 평균을 계산하는 메소드========================
	public static double average(double s1, double s2, double s3) {

		return ((s1 + s2 + s3) / 3);

	}

	// ===================숫자 3개의 중앙값을 계산하는 메소드========================
	public static double median(double s1, double s2, double s3) {

		if ((s1 < s2 && s2 < s3) || (s3 < s2 && s2 < s1))
			return s2;
		else if ((s2 < s1 && s1 < s3) || (s3 < s1 && s1 < s2))
			return s1;
		else
			return s3;

	}

	// ======================출석 점수를 계산하는 메소드===========================
	public static double attend(int Absence, int Late) {

		if (Absence <= 3 && Late <= 3)
			return 10.0;

		else if (Absence > 3 && Late <= 3) {
			if ((Absence - 3) + (Late - 3) * 0.5 <= 10)
				return 10 - (Absence - 3);
			else
				return 0.0;
		}

		else if (Absence <= 3 && Late > 3) {
			if ((Absence - 3) + (Late - 3) * 0.5 <= 10)
				return 10 - (Late - 3) * 0.5;
			else
				return 0.0;
		}

		else if (Absence > 3 && Late > 3) {
			if ((Absence - 3) + (Late - 3) * 0.5 <= 10)
				return 10 - (Absence - 3 + (Late - 3) * 0.5);
			else
				return 0.0;
		}
		return Late;

	}

	// ===================최종성적을 필드 score에 저장하는 메소드===================
	public static void total(double s1, double s2, double s3, int Absence, int Late) {

		score = (s1 * 0.03 + s2 * 0.03 + s3 * 0.03 + 1 - (Absence + Late));
	}

	// ===================최종성적이 A인지 확인하는 메소드==========================
	public static boolean isA() {
		if (score >= 90)
			return true;
		else
			return false;
	}

	// ==============필드 id에 저장된 숫자의 모든 자릿수의 합을 계산하는 메소드================
	public static int sumID(int id) {

		int sum = 0;
		while (id != 0) {

			sum += (id % 10);
			id -= (id % 10);
			id = id / 10;
		}

		return sum;

	}

	public static void main(String[] args) {
		

		while (true) {
			System.out.println("============================");
			System.out.println("Welcome to grade calculator!");
			System.out.println("============================");

			System.out.print("Enter student ID: ");

			Scanner input = new Scanner(System.in);
			id = input.nextInt();

			System.out.println("sum of ID: " + sumID(id));
			System.out.println();
			System.out.print("Continue?(Y/N): ");
			char ch = input.next().charAt(0);

			if (ch == 'Y') {
				System.out.println("----------");
				System.out.print("Exam 1: ");
				double s1 = input.nextDouble();

				System.out.print("Exam 2: ");
				double s2 = input.nextDouble();

				System.out.print("Exam 3: ");
				double s3 = input.nextDouble();

				System.out.print("Absence:  ");
				int Absence = input.nextInt();

				System.out.print("Late: ");
				int Late = input.nextInt();

				System.out.println("----------");
				System.out.println("Exam average: " + average(s1, s2, s3));
				System.out.println("Exam median: " + median(s1, s2, s3));

				System.out.println("Attendance score: " + attend(Absence, Late));

				score = (average(s1, s2, s3) * 3 * 0.3 + attend(Absence, Late));
				System.out.println("Final grade: " + score);
				if (score >= 90) {
					System.out.println(">>>> Grade is A!");
				}
				System.out.println("----------");

			}

			else {
				System.out.println();
				System.out.println("[Finish]");
			}
			
			System.out.println();
			System.out.print("Continue?(Y/N): ");
			char cha = input.next().charAt(0);

			if (cha != 'Y') {
				System.out.println();
				System.out.println("[Finish]");
				break;
			}

		}

	}

}
