package com.greatlearning.datastructureassignmentsolution;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class SkyscraperBuilding {
	Scanner sc = new Scanner(System.in);
	int n;
	Integer[] floorSizes;
	Integer[] floorSizesSorted;

	public void inputData() {
		System.out.println("Wecome to Skyscrapper - Floor planner");
		System.out.println("enter the total no of floors in the building \n");
		n = sc.nextInt();
		floorSizes = new Integer[n];
		insertValues();
	}

	public void insertValues() {
		for (int i = 0; i < n; i++) {
			System.out.print("enter the floor size given on day :" + (i + 1)+"\n");
			floorSizes[i] = sc.nextInt();
			
			
		}
	}

	public void orderOfConstruction() {
		floorSizesSorted = floorSizes.clone();
		Arrays.sort(floorSizesSorted, Collections.reverseOrder());
		int j = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {

			if (floorSizes[i] == floorSizesSorted[j]) {
				if (i == n - 1)
					j = i;
				else
					j = i + 1;
				System.out.println("Day: " + (i + 1));
				if (stack != null) {
					System.out.print(floorSizes[i] + " ");
					while (!stack.isEmpty()) {
						int value = stack.pop();
						if (value >= floorSizesSorted[j]) {
							System.out.print(value + " ");
						} else {
							stack.push(value);
							j -= stack.size();
							break;
						}
					}
					System.out.println(" ");
				} else {
					System.out.println(floorSizes[i]);
				}

			} else {
				System.out.println("Day: " + (i + 1));
				System.out.println(" ");
				stack.push(floorSizes[i]);
			}
		}

	}

public static void main(String[] args) {
	SkyscraperBuilding SB = new SkyscraperBuilding();
	SB.inputData();
	SB.orderOfConstruction();
}

}

