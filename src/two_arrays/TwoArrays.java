package two_arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoArrays 
{
	public static List<String> output = new ArrayList<String>(); 
	public static void swap(int ar[], int i, int j) 
	{
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public static int partitiondec(int ar[], int left, int right)
	{
		int pivotValue = ar[left];
		int pivotIndex = left;
		swap(ar, pivotIndex, right);
		int index = left;
		for(int i = left; i < right; i++)
		{
			if(ar[i] > pivotValue)
			{
				swap(ar, index, i);
				index++;
			}
		}
		swap(ar, index, right);
		return index;
	}
	
	public static void sortdec(int ar[], int l, int u) 
	{
		if(l < u)
		{
			int pivot = partitiondec(ar, l, u);
			sortdec(ar, l, pivot - 1);
			sortdec(ar, pivot + 1, u);
		}
	}
	
	public static int partitionasc(int ar[], int left, int right)
	{
		int pivotValue = ar[left];
		int pivotIndex = left;
		swap(ar, pivotIndex, right);
		int index = left;
		for(int i = left; i < right; i++)
		{
			if(ar[i] < pivotValue)
			{
				swap(ar, index, i);
				index++;
			}
		}
		swap(ar, index, right);
		return index;
	}
	
	public static void sortasc(int ar[], int l, int u) 
	{
		if(l < u)
		{
			int pivot = partitionasc(ar, l, u);
			sortasc(ar, l, pivot - 1);
			sortasc(ar, pivot + 1, u);
		}
	}
	
	public static void checkSum(int a[],int b[],int k) 
	{
		sortasc(a, 0, a.length - 1);
		sortdec(b, 0, b.length - 1);
		boolean status = true;
		for(int i = 0; i < a.length; i++)
		{
			if((a[i] + b[i]) < k)
			{
				status = false;
				break;
			}
		}
		if(status)
		{
			output.add("YES");
		}
		else
		{
			output.add("NO");
		}
	}
	
	public static void main(String args[]) 
	{
		Scanner sr = new Scanner(System.in);
		int t = sr.nextInt();
		for(int i = 0; i < t; i++)
		{
			int n = sr.nextInt();
			int k = sr.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			for(int j = 0; j < n; j++)
			{
				a[j] = sr.nextInt();
			}
			for(int j = 0; j < n; j++)
			{
				b[j] = sr.nextInt();
			}
			checkSum(a, b, k);
		}
		for(String in:output)
		{
			System.out.println(in);
		}
		sr.close();
	}
}