/*
RESUMO      : Exercício 05, Implementação de quick sort; algoritmo de ordenação. Ele estará inserido na biblioteca de Sorts (projeto TED_20230314_04)
PROGRAMADORA: Luiza Felix
DATA        : 18/03/2023
 */

package br.edu.fateczl.ordenacao;

public class QuickSort {
	public QuickSort() {
		super();
	}

	public int[] main(int[] vetor) {
		vetor = subvetoracao(vetor, 0, vetor.length-1);
		return vetor;
	}

	private int[] subvetoracao(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			// enquanto o fim for maior que o começo, o pivô não estoura pro negativo eu sigo repartindo com base no pivô fixo determinado anteriormente preciso saber a posição onde o pivo foi fixado para depois determinar os subvetores, como o "meio" em mergesort
			int pivofixado = pivotizacao(vetor, inicio, fim);
			/* subvetor da esquerda */ subvetoracao(vetor, inicio, (pivofixado-1));
			/* subvetor da direita */ subvetoracao(vetor, (pivofixado + 1), fim);
		}
		return vetor;
		
	}

	private int pivotizacao(int[] vetor, int inicio, int fim) {
		// agoritmo seguindo a lógica passada no vídeo, para a ordenação do vetor

		/* ponteiro começo-fim */int red = (inicio + 1);
		/* ponteirofim-começo */int green = fim;

		// caminhada das setas
		while (red <= green) {
			
			while (red <= green && vetor[red] <= vetor[inicio]) {
				// o vermelho pode estourar o comprimento do vetor, se só houverem números menores que o pivô, fazendo com que ele se encaixe na útima posição do vetor(e se isso for executado, estourar ele). o WHILE faz com que isso se repita sem sobrecarregar a pilha de execução abrindo um while só consecutivamente
				red++;
			} // a incrementação dele cessa e a do verde começa
			while (green >= red && vetor[green] > vetor[inicio]) {
//					se não for especificado esse limite, o código estoura tbm (decrementa para além do 0)
					green--;
			}// parou a decrementação e achou uma variável menor ou igual, se eles não estão referenciados na mesma posição, eu devo fazer uma troca
			if (red < green) {
//				nesse caso eles não se cruzaram ainda, depois dessa troca eu continuo rodando
				int aux = vetor[red];
				vetor[red] = vetor[green];
				vetor[green] = aux;
				
//				logicamente se eles ainda não se cruzaram eu sigo andando
				red++;
				green--;
			}
			}
		
//		troca dos valores, determinando o novo pivô (número que ocupava a casa 0)
		int aux = vetor[inicio];
		vetor[inicio] = vetor[green];
		vetor[green] = aux;
		

		return green;
	}
}
