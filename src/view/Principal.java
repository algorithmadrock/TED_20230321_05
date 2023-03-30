package view;

import br.edu.fateczl.ordenacao.QuickSort;

public class Principal {
	public Principal() {
		super();
	}
	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] vetor = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		int[] quick = sort.main(vetor);
		
		System.out.println("QUICK : ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(quick[i] + " ");
		}
	}
	}

