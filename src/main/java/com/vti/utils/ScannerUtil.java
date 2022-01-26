package com.vti.utils;

import java.util.Scanner;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);

	public static int scInt() {
		int ketQua = 0;
		boolean stop = false;
		do {
			try {
				ketQua = Integer.parseInt(scanner.next());
				scanner.nextLine();
				stop = true;
			} catch (Exception e) {
				System.err.println("Nhap sai, vui long nhap lai : ");
			}
		} while (!stop);

		return ketQua;
	}
	
	public static String scString() {
		return scanner.nextLine();
	}
}
