package ex4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QuickSort {
	private final int n = 50000;
	private int[] a = new int[n];

	public QuickSort(String filename) {
		try {
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(new FileReader(filename));
			String line = null;
			int i = 0;
			while ((line = bf.readLine()) != null) {
				a[i] = Integer.parseInt(line);
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private int partition(int l, int r) {
		return a[(l + r) / 2];
	}

	private void quicksort(int l, int r) {
		if(l <= r){
			int v = partition(l, r);
			int left = l;
			int right = r;
			while (l <= r) {
				while (a[l] < v) {
					l++;
				}
				while (a[r] > v) {
					r--;
				}
				if (l <= r) {
					int tmp = a[l];
					a[l] = a[r];
					a[r] = tmp;
					l++;
					r--;
				}
			}
			quicksort(left, r);
			quicksort(l, right);
		}
	}

	public void sort() {
		quicksort(0, a.length - 1);
	}

	public void output(String filename) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new BufferedWriter(
					new FileWriter(filename)));
			for (int i = 0; i < a.length; i++) {
				writer.println(a[i]);
			}
			writer.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String file1 = "sorted2.txt";
		String file2 = "result_ex4-1_sorted2.txt";

		
		QuickSort qs = new QuickSort(file1);
		long start, stop;
		start = System.currentTimeMillis();
		qs.sort();
		stop = System.currentTimeMillis();
		System.out.println((stop - start) + "[ms]");
		qs.output(file2);
	}
}
