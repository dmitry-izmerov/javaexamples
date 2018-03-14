package ru.demi.java_examples.java_core;

import java.util.Properties;

/**
 * @author demi
 * @date 07.01.17
 */
public class BlocksWithLabels {
	public static void main(String[] args) {
		p1:
		{
			p2:
			{
				p3:
				{
					System.out.print("p3.1 ");
					if (true) break p2;
					System.out.print("p3.2 ");
				}
				p4:
				{
					System.out.println("p4");
				}
				System.out.print("p2 ");
			}
			System.out.print("p1 ");
		}
	}
}
