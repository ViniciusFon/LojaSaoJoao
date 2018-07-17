package com.br.fontana.digital.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Teste {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,12,13,15,16,18,19, 20, 23);
		List<Integer> xxx = numbers.subList(0, 4);
		xxx.forEach(System.out::println);
		
		List<Integer> numbers2 = numbers.stream().filter(n -> ((n % 3 == 0) || isPrime(n))).collect(Collectors.toList());
		//numbers2.forEach(System.out::println);
		
	}
	
	public static boolean isPrime(int number) {
	    return number > 2
	      && IntStream.rangeClosed(2, (int) Math.sqrt(number))
	      .noneMatch(n -> (number % n == 0));
	}
}
