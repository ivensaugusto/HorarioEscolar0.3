package Principal;

import java.util.Scanner;

/**
 * A classe Tools � uma classe de ferramentas para a programa��o b�sica. 
 * Ela cont�m m�todos que facilitam atividades de rotina, em fun��o da
 * simplifica��o da cria��o de algoritmos.
 * 
 * @author Carlos "Corvo" Padua.
 * @version 1.0.
 * 
 * Sum�rio:
 *
 * (1 - 10): Conjunto "in" (entrada de dados);
 * (11 - 12): Conjunto "check" (verfica��o de dados);
 * (13 - 24): Conjunto "random" (cria��o de vetores e matrizes aleat�rios);
 * (25 - 36): Conjunto "write" (escrita de vetores e matrizes);
 * (37 - 54): Conjunto "biggest" (retorno de maior valor de vari�veis, vetores e matrizes);
 * (55 - 72): Conjunto "smallest" (retorno de menor valor de vari�veis, vetores e matrizes);
 * (73 - 84): Conjunto "sortInc" (ordena��o crescente de vetores e matrizes);
 * (85 - 96): Conjunto "sortDec" (ordena��o decrescente de vetores e matrizes);
 * (97 - 108): Conjunto "largest" (retorno da quantidade de caracteres do mais comprido valor de vetores e matrizes)
 * (109): "align" (alinhamento da escrita de valores de vetores e matrizes);
 */
public class Tools {
	private static Scanner input;
	//	// M�todo para testes:
	//	public static void main (String[] args) {
	//		final int y = 10, x = 5;
	//		final byte minR = -128, maxR = 127;
	//		byte[] vec = randomByteVec(x, minR, maxR);
	//		String output = writeByteVec(vec);
	//		System.out.println(output + "\n");
	//		sortDecByteVec(vec);
	//		output = writeByteVec(vec);
	//		System.out.println(output + "\n");
	//		sortIncByteVec(vec);
	//		output = writeByteVec(vec);
	//		System.out.println(output + "\n");
	//		output = "" + biggestByteVec(vec);
	//		System.out.println(output + "\n");
	//		output = "" + smallestByteVec(vec);
	//		System.out.println(output + "\n");
	//		byte[][] mat = randomByteMat(y, x, minR, maxR);
	//		output = writeByteMat(mat);
	//		System.out.println(output + "\n");
	//		sortDecByteMat(mat);
	//		output = writeByteMat(mat);
	//		System.out.println(output + "\n");
	//		sortIncByteMat(mat);
	//		output = writeByteMat(mat);
	//		System.out.println(output + "\n");
	//		output = "" + biggestByteMat(mat);
	//		System.out.println(output + "\n");
	//		output= "" + smallestByteMat(mat);
	//		System.out.println(output + "\n");
	//		output = "";
	//		for (int i = 1; i <= 500; i ++) {
	//			output += i + " - perfect: " + checkPerfect(i) + "  prime: " + checkPrime(i) + "\n";
	//		}
	//		System.out.println(output);
	//	}
	/**
	 * 1 - inString: L� um conjunto de caracteres fornecidos pelo usu�rio.
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Conjunto de caracteres (String).
	 */
	public static String inString (String message) {
		input = new Scanner(System.in);
		System.out.print(message);
		String text = input.nextLine();
		return text;
	}
	/**
	 * 2 - inChar: L� um �nico caracter (Char) fornecido pelo usu�rio, tratando exce��es.
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um caracter (Char).
	 */
	public static char inChar (String message) {
		input = new Scanner(System.in);
		String text = "";
		do {
			System.out.print(message);
			text = input.nextLine();		
			if (text.length() > 1) {
				System.out.print("\nVoc� deve informar um �nico caracter!\n");
			}
		}while (text.length() > 1);	
		return text.charAt(0);
	}
	/**
	 * 3 - inByte: L� um valor do tipo Byte fornecido pelo usu�rio, tratando exce��es. 
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor do tipo Byte.
	 */
	public static byte inByte (String message) {
		input = new Scanner (System.in);
		boolean error = true;
		byte number = 0;
		do {
			try {
				System.out.print(message);
				String test = input.nextLine ();
				number = Byte.parseByte(test);
				error = false;
			}catch (Exception e) {
				System.out.print ("\nVoc� deve informar um valor n�merico do "
						+ "tipo Byte!\n");
			}
		}while (error);
		return number;
	}
	/**
	 * 4 - inShort: L� um valor do tipo Short fornecido pelo usu�rio, tratando exce��es.
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor do tipo Short.
	 */
	public static short inShort (String message) {
		input = new Scanner (System.in);
		boolean error = true;
		short number = 0;
		do {
			try {
				System.out.print(message);
				String test = input.nextLine ();
				number = Short.parseShort(test);
				error = false;
			}catch (Exception e) {
				System.out.print ("\nVoc� deve informar um valor n�merico do "
						+ "tipo Short!\n");
			}
		}while (error);
		return number;
	}
	/**
	 * 5 - inInt: L� um valor do tipo Integer fornecido pelo usu�rio, tratando exce��es. 
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor do tipo Integer.
	 */
	public static int inInt (String message) {
		input = new Scanner (System.in);
		boolean error = true;
		int number = 0;
		do {
			try {
				System.out.print(message);
				String test = input.nextLine ();
				number = Integer.parseInt(test);
				error = false;
			}catch (Exception e) {
				System.out.print ("\nVoc� deve informar um valor n�merico do "
						+ "tipo Integer!\n");
			}
		}while (error);
		return number;
	}
	/**
	 * 6 - inLong: L� um valor do tipo Long fornecido pelo usu�rio, tratando exce��es.
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor do tipo Long.
	 */
	public static long inLong (String message) {
		input = new Scanner (System.in);
		boolean error = true;
		long number = 0;
		do {
			try {
				System.out.print(message);
				String test = input.nextLine ();
				number = Long.parseLong(test);
				error = false;
			}catch (Exception e) {
				System.out.print ("\nVoc� deve informar um valor n�merico do "
						+ "tipo Long!\n");
			}
		}while (error);
		return number;
	}
	/**
	 * 7 - inFloat: L� um valor do tipo Float fornecido pelo usu�rio, tratando exce��es.
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor do tipo Float.
	 */
	public static float inFloat (String message) {
		input = new Scanner (System.in);
		boolean error = true;
		float number = 0;
		do {
			try {
				System.out.print(message);
				String test = input.nextLine ();
				number = Float.parseFloat(test);
				error = false;
			}catch (Exception e) {
				System.out.print ("\nVoc� deve informar um valor n�merico do "
						+ "tipo Float!\n");
			}
		}while (error);
		return number;
	}
	/**
	 * 8 - inDouble: L� um valor do tipo Double fornecido pelo usu�rio, tratando exce��es.
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor do tipo Double.
	 */
	public static double inDouble (String message) {
		input = new Scanner (System.in);
		boolean error = true;
		double number = 0;
		do {
			try {
				System.out.print(message);
				String test = input.nextLine ();
				number = Double.parseDouble(test);
				error = false;
			}catch (Exception e) {
				System.out.print ("\nVoc� deve informar um valor n�merico do "
						+ "tipo Double!\n");
			}
		}while (error);
		return number;
	}
	/**
	 * 9 - inNatural: L� um valor do tipo Integer n�o negativo fornecido pelo usu�rio, tratando exce��es.
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor do tipo Integer.
	 */
	public static int inNatural (String message) {
		int number = 0;
		do {
			number = inInt(message);
			if (number < 0) {
				System.out.print("\nVoc� deve informar um valor num�rico do "
						+ "tipo Integer n�o negativo!\n");
			}
		}while (number < 0);
		return number;
	}
	/**
	 * 10 - inInterval: L� um valor incluso num determinado intervalo (Double).
	 * 
	 * @param Conjunto de caracteres (String);
	 * @param Valor m�nimo do intervalo;
	 * @param Valor m�ximo do intervalo.
	 * @return Um valor do tipo Double.
	 */
	public static double inInterval (String message, double minN, double maxN) {
		input = new Scanner(System.in);
		double number = 0;
		do {
			number = Tools.inDouble(message);
			if (number < minN || number > maxN) {
				System.out.print("\nVoc� deve informar um valor num�rico do "
						+ "tipo Double entre " + minN + " e " + maxN + "!\n");
			}
		}while (number < minN || number > maxN);		
		return number;
	}
	/**
	 * 11 - checkPrime: L� um valor do tipo Long (ou inferior) fornecido pelo usu�rio, tratando exce��es, e 
	 * informa se o valor � um n�mero primo ("true" para sim e "false" para n�o). 
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor l�gico (Boolean).
	 */
	public static boolean checkPrime (long number) {
		boolean prime = true;
		if (number != 1) {
			for (int i = 2; i < number; i ++) {
				if (number % i == 0) {
					prime = false;
				}
			}
		}else {
			prime = false;
		}
		return prime;
	}
	/**
	 * 12 - checkPerfect: L� um valor do tipo Long (ou inferior) fornecido pelo usu�rio, tratando exce��es, e 
	 * informa se o valor � um n�mero perfeito ("true" para sim e "false" para n�o). 
	 * 
	 * @param Conjunto de caracteres (String).
	 * @return Um valor l�gico (Boolean).
	 */
	public static boolean checkPerfect (long number) {
		boolean perfect = false;
		long divisors = 0;
		for (int i = 1; i <= (number / 2); i ++) {
			if (number % i == 0) {
				divisors += i;
			}
		}
		if (number == divisors) {
			perfect = true;
		}
		return perfect;
	}
	/**
	 * 13 - randomByteVec: Cria um vetor contendo valores do tipo Byte aleat�rios.
	 * 
	 * @param Comprimento do vetor;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Um vetor contendo valores do tipo Byte aleat�rios.
	 */
	public static byte[] randomByteVec (int length, byte minR, byte maxR) {		
		if (minR > maxR || length <= 0) {
			return null;
		}else {
			byte[] vec = new byte [length];
			for (int i = 0; i < length; i ++) {
				vec[i] = (byte)(Math.random() * (maxR - minR + 1) + minR);
			}
			return vec;
		}
	}
	
	/**
	 * 14 - randomShortVec: Cria um vetor contendo valores do tipo Short aleat�rios.
	 * 
	 * @param Comprimento do vetor;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Um vetor contendo valores do tipo Short aleat�rios.
	 */
	public static short[] randomShortVec (int length, short minR, short maxR) {		
		if (minR > maxR || length <= 0) {
			return null;
		}else {
			short[] vec = new short [length];
			for (int i = 0; i < length; i ++) {
				vec[i] = (short)(Math.random() * (maxR - minR + 1) + minR);
			}
			return vec;
		}
	}
	/**
	 * 15 - randomIntVec: Cria um vetor contendo valores do tipo Integer aleat�rios.
	 * 
	 * @param Comprimento do vetor;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Um vetor contendo valores do tipo Integer aleat�rios.
	 */
	public static int[] randomIntVec (int length, int minR, int maxR) {		
		if (minR > maxR || length <= 0) {
			return null;
		}else {
			int[] vec = new int [length];
			for (int i = 0; i < length; i ++) {
				vec[i] = (int)(Math.random() * (maxR - minR + 1) + minR);
			}
			return vec;
		}
	}
	/**
	 * 16 - randomLongVec: Cria um vetor contendo valores do tipo Long aleat�rios.
	 * 
	 * @param Comprimento do vetor;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Um vetor contendo valores do tipo Long aleat�rios.
	 */
	public static long[] randomLongVec (int length, long minR, long maxR) {		
		if (minR > maxR || length <= 0) {
			return null;
		}else {
			long[] vec = new long [length];
			for(int i = 0; i < length; i ++) {
				vec[i] = (long)(Math.random() * (maxR - minR + 1) + minR);
			}
			return vec;
		}
	}
	/**
	 * 17 - randomFloatVec: Cria um vetor comntendo valores do tipo Float aleat�rios.
	 * 
	 * @param Comprimento do vetor;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Um vetor com valores do tipo Float.
	 */
	public static float[] randomFloatVec (int length, float minR, float maxR) {		
		if (minR > maxR || length <= 0) {
			return null;
		}else {
			float[] vec = new float[length];
			for (int i = 0; i < length; i ++) {
				vec[i] = (float)(Math.random() * (maxR - minR + 1) + minR);
			}
			return vec;
		}
	}
	/**
	 * 18 - randomDoubleVec: Cria um vetor contendo valores do tipo Double aleat�rios.
	 * 
	 * @param Comprimento do vetor;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Um vetor com valores do tipo Double.
	 */
	public static double[] randomDoubleVec (int length, double minR, double maxR) {		
		if (minR > maxR || length <= 0) {
			return null;
		}else {
			double[] vec = new double [length];
			for (int i = 0; i < length; i ++) {
				vec[i] = Math.random() * (maxR - minR + 1) + minR;
			}
			return vec;
		}
	}
	/**
	 * 19 - randomByteMat: Cria uma matriz contendo valores do tipo Byte aleat�rios.
	 * 
	 * @param Quantidade de linhas;
	 * @param Quantidade de colunas;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Uma matriz contendo valores do tipo Byte aleat�rios.
	 */
	public static byte[][] randomByteMat (int lengthL, int lengthC, byte minR, byte maxR) {		
		if (minR > maxR || lengthL <= 0 || lengthC <= 0) {
			return null;
		}else{ 
			byte[][] mat = new byte [lengthL][lengthC];
			for (int i = 0; i < lengthL; i ++) {
				for (int j = 0; j < lengthC; j ++) {
					mat[i][j] = (byte)(Math.random() * (maxR - minR + 1) + minR);
				}
			}
			return mat;
		}
	}
	/**
	 * 20 - randomShortMat: Cria uma matriz contendo valores do tipo Short aleat�rios.
	 * 
	 * @param Quantidade de linhas;
	 * @param Quantidade de colunas;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Uma matriz contendo valores do tipo Short aleat�rios.
	 */
	public static short[][] randomShortMat (int lengthL, int lengthC, short minR, short maxR) {		
		if (minR > maxR || lengthL <= 0 || lengthC <= 0) {
			return null;
		}else {
			short[][] mat = new short [lengthL][lengthC];
			for (int i = 0; i < lengthL; i ++) {
				for (int j = 0; j < lengthC; j ++) {
					mat[i][j] = (short)(Math.random() * (maxR - minR + 1) + minR);
				}
			}
			return mat;
		}
	}
	/**
	 * 21 - randomIntMat: Cria uma matriz contendo valores do tipo Integer aleat�rios.
	 * 
	 * @param Quantidade de linhas;
	 * @param Quantidade de colunas;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Uma matriz contendo valores do tipo Integer aleat�rios.
	 */
	public static int[][] randomIntMat (int lengthL, int lengthC, int minR, int maxR) {		
		if (minR > maxR || lengthL <= 0 || lengthC <= 0) {
			return null;
		}else {
			int[][] mat = new int [lengthL][lengthC];
			for (int i = 0; i < lengthL; i ++) {
				for (int j = 0; j < lengthC; j ++) {
					mat[i][j] = (int)(Math.random() * (maxR - minR + 1) + minR);
				}
			}
			return mat;
		}
	}
	/**
	 * 22 - randomLongMat: Cria uma matriz contendo valores do tipo Long aleat�rios.
	 * 
	 * @param Quantidade de linhas;
	 * @param Quantidade de colunas;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Uma matriz contendo valores do tipo Long aleat�rios.
	 */
	public static long[][] randomLongMat (int lengthL, int lengthC, long minR, long maxR) {		
		if (minR > maxR || lengthL <= 0 || lengthC <= 0) {
			return null;
		}else {
			long[][] mat = new long [lengthL][lengthC];
			for (int i = 0; i < lengthL; i ++) {
				for (int j = 0; j < lengthC; j ++) {
					mat[i][j] = (long)(Math.random() * (maxR - minR + 1) + minR);
				}
			}
			return mat;
		}
	}
	/**
	 * 23 - randomFloatMat: Cria uma matriz contendo valores do tipo Float aleat�rios.
	 * 
	 * @param Quantidade de linhas;
	 * @param Quantidade de colunas;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Uma matriz contendo valores do tipo Float aleat�rios.
	 */
	public static float[][] randomFloatMat (int lengthL, int lengthC, float minR, float maxR) {		
		if (minR > maxR || lengthL <= 0 || lengthC <= 0) {
			return null;
		}else {
			float[][] mat = new float [lengthL][lengthC];
			for (int i = 0; i < lengthL; i ++) {
				for (int j = 0; j < lengthC; j ++) {
					mat[i][j] = (float)(Math.random() * (maxR - minR + 1) + minR);
				}
			}
			return mat;
		}
	}
	/**
	 * 24 - randomDoubleMat: Cria uma matriz contendo valores do tipo Double aleat�rios.
	 * 
	 * @param Quantidade de linhas;
	 * @param Quantidade de colunas;
	 * @param M�nimo de randomiza��o de valores;
	 * @param M�ximo de randomiza��o de valores.
	 * @return Uma matriz contendo valores do tipo Double aleat�rios.
	 */
	public static double[][] randomDoubleMat (int lengthL, int lengthC, double minR, double maxR) {		
		if (minR > maxR || lengthL <= 0 || lengthC <= 0) {
			return null;
		}else {
			double[][] mat = new double [lengthL][lengthC];
			for (int i = 0; i < lengthL; i ++) {
				for (int j = 0; j < lengthC; j ++) {
					mat[i][j] = (Math.random() * (maxR - minR + 1) + minR);
				}
			}
			return mat;
		}
	}

	/**
	 * 25.1 - writeByteVec: Escreve um vetor contendo valores do tipo Object numa vari�vel do tipo String.
	 * 
	 * @param Um vetor.
	 * @return Uma String contendo o vetor.
	 */
	public static String writeVec (Object[] o) {
		String output = "";
		for (Object object : o) {
			output += object.toString()+"\n";
		}
		return output;
	}

	/**
	 * 25 - writeByteVec: Escreve um vetor contendo valores do tipo Byte numa vari�vel do tipo String.
	 * 
	 * @param Um vetor.
	 * @return Uma String contendo o vetor.
	 */

	public static String writeByteVec (byte[] vec) {
		String output = "";
		String largest = "" + largestByteVec(vec);
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			if (vecL.length() < largest.length()){
				byte diff = (byte)(largest.length() - vecL.length());
				output += " | " + align(diff) + vec[i];
			}else {
				output += " | " + vec[i];
			}
		}
		output += " | ";
		return output;
	}
	/**
	 * 26 - writeShortVec: Escreve um vetor contendo valores do tipo Short numa vari�vel do tipo String.
	 * 
	 * @param Um vetor.
	 * @return Uma String contendo o vetor.
	 */
	public static String writeShortVec (short[] vec) {
		String output = "";
		String largest = "" + largestShortVec(vec);
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			if (vecL.length() < largest.length()){
				byte diff = (byte)(largest.length() - vecL.length());
				output += " | " + align(diff) + vec[i];
			}else {
				output += " | " + vec[i];
			}
		}
		output += " | ";
		return output;
	}

	/**
	 * 27 - writeIntVec: Escreve um vetor contendo valores do tipo Integer numa vari�vel do tipo String.
	 * 
	 * @param Um vetor.
	 * @return Uma String contendo o vetor.
	 */
	public static String writeVec (int[] vec) {
		String output = "";
		String largest = "" + largestIntVec(vec);
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			if (vecL.length() < largest.length()){
				byte diff = (byte)(largest.length() - vecL.length());
				output += " | " + align(diff) + vec[i];
			}else {
				output += " | " + vec[i];
			}
		}
		output += " | ";
		return output;
	}
	/**
	 * 28 - writeLongVec: Escreve um vetor contendo valores do tipo Long numa vari�vel do tipo String.
	 * 
	 * @param Um vetor.
	 * @return Uma String contendo o vetor.
	 */
	public static String writeLongVec (long[] vec) {
		String output = "";
		String largest = "" + largestLongVec(vec);
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			if (vecL.length() < largest.length()){
				byte diff = (byte)(largest.length() - vecL.length());
				output += " | " + align(diff) + vec[i];
			}else {
				output += " | " + vec[i];
			}
		}
		output += " | ";
		return output;
	}
	/**
	 * 29 - writeFloatVec: Escreve um vetor contendo valores do tipo Float numa vari�vel do tipo String.
	 * 
	 * @param Um vetor.
	 * @return Uma String contendo o vetor.
	 */
	public static String writeFloatVec (float[] vec) {
		String output = "";
		String largest = "" + largestFloatVec(vec);
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			if (vecL.length() < largest.length()){
				byte diff = (byte)(largest.length() - vecL.length());
				output += " | " + align(diff) + vec[i];
			}else {
				output += " | " + vec[i];
			}
		}
		output += " | ";
		return output;
	}
	/**
	 * 30 - writeDoubleVec: Escreve um vetor contendo valores do tipo Double numa vari�vel do tipo String.
	 * 
	 * @param Um vetor.
	 * @return Uma String contendo o vetor.
	 */
	public static String writeDoubleVec (double[] vec) {
		String output = "";
		String largest = "" + largestDoubleVec(vec);
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			if (vecL.length() < largest.length()){
				byte diff = (byte)(largest.length() - vecL.length());
				output += " | " + align(diff) + vec[i];
			}else {
				output += " | " + vec[i];
			}
		}
		output += " | ";
		return output;
	}

	/**
	 * 31.1 - writeMat: Escreve uma matriz numa variavel do tipo String.
	 * 
	 * @param Um matriz.
	 * @return Uma String contendo a matriz.
	 */
	public static String writeMat (Object[][] matriz) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matriz.length; i++) {
			sb.append("|");
			for (int j = 0; j < matriz[0].length; j++) {
				sb.append(matriz[i][j]+"|");
			}
			if (i < matriz.length-1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * 31 - writeByteMat: Escreve uma matriz contendo valores do tipo Byte numa vari�vel do tipo String.
	 * 
	 * @param Uma matriz.
	 * @return Uma String contendo a matriz.
	 */
	public static String writeByteMat (byte[][] mat) {
		String output = "";
		String largest = "" + largestByteMat(mat);
		output = "";
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				if (matL.length() < largest.length()){
					byte diff = (byte)(largest.length() - matL.length());
					output += " | " + align(diff) + mat[i][j];
				}else {
					output += " | " + mat[i][j];
				}
			}
			output += " |\n";
		}
		return output;
	}
	/**
	 * 32 - writeShortMat: Escreve uma matriz contendo valores do tipo Short numa vari�vel do tipo String.
	 * 
	 * @param Uma matriz.
	 * @return Uma String contendo a matriz.
	 */
	public static String writeShortMat (short[][] mat) {
		String output = "";
		String largest = "" + largestShortMat(mat);
		output = "";
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				if (matL.length() < largest.length()){
					byte diff = (byte)(largest.length() - matL.length());
					output += " | " + align(diff) + mat[i][j];
				}else {
					output += " | " + mat[i][j];
				}
			}
			output += " |\n";
		}
		return output;
	}
	/**
	 * 33 - writeIntMat: Escreve uma matriz contendo valores do tipo Integer numa vari�vel do tipo String.
	 * 
	 * @param Uma matriz.
	 * @return Uma String contendo a matriz.
	 */
	public static String writeIntMat (int[][] mat) {
		String output = "";
		String largest = "" + largestIntMat(mat);
		output = "";
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				if (matL.length() < largest.length()){
					byte diff = (byte)(largest.length() - matL.length());
					output += " | " + align(diff) + mat[i][j];
				}else {
					output += " | " + mat[i][j];
				}
			}
			output += " |\n";
		}
		return output;
	}
	/**
	 * 34 - writeLongMat: Escreve uma matriz contendo valores do tipo Long numa vari�vel do tipo String.
	 * 
	 * @param Uma matriz.
	 * @return Uma String contendo a matriz.
	 */
	public static String writeLongMat (long[][] mat) {
		String output = "";
		String largest = "" + largestLongMat(mat);
		output = "";
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				if (matL.length() < largest.length()){
					byte diff = (byte)(largest.length() - matL.length());
					output += " | " + align(diff) + mat[i][j];
				}else {
					output += " | " + mat[i][j];
				}
			}
			output += " |\n";
		}
		return output;
	}
	/**
	 * 35 - writeFloatMat: Escreve uma matriz contendo valores do tipo Float numa vari�vel do tipo String.
	 * 
	 * @param Uma matriz.
	 * @return Uma String contendo a matriz.
	 */
	public static String writeFloatMat (float[][] mat) {
		String output = "";
		String largest = "" + largestFloatMat(mat);
		output = "";
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				if (matL.length() < largest.length()){
					byte diff = (byte)(largest.length() - matL.length());
					output += " | " + align(diff) + mat[i][j];
				}else {
					output += " | " + mat[i][j];
				}
			}
			output += " |\n";
		}
		return output;
	}
	/**
	 * 36 - writeDoubleMat: Escreve uma matriz contendo valores do tipo Double numa vari�vel do tipo String.
	 * 
	 * @param Uma matriz.
	 * @return Uma String contendo a matriz.
	 */
	public static String writeDoubleMat (double[][] mat) {
		String output = "";
		String largest = "" + largestDoubleMat(mat);
		output = "";
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				if (matL.length() < largest.length()){
					byte diff = (byte)(largest.length() - matL.length());
					output += " | " + align(diff) + mat[i][j];
				}else {
					output += " | " + mat[i][j];
				}
			}
			output += " |\n";
		}
		return output;
	}
	/**
	 * 37 - biggestByte: Retorna o maior entre dois valores do tipo Byte.
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O maior deles.
	 */
	public static byte biggestByte (byte number1, byte number2) {
		if (number1 > number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 38 - biggestShort: Retorna o maior entre dois valores do tipo Short.
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O maior deles.
	 */
	public static short biggestShort (short number1, short number2) {
		if (number1 > number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 39 - biggestInt: Retorna o maior entre dois valores do tipo Integer.
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O maior deles.
	 */
	public static int biggestInt (int number1, int number2) {
		if (number1 > number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 40 - biggestLong: Retorna o maior entre dois valores do tipo Long.
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O maior deles.
	 */
	public static long biggestLong(long number1, long number2) {
		if (number1 > number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 41 - biggestFloat: Retorna o maior entre dois valores do tipo Float.
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O maior deles.
	 */
	public static float biggestFloat (float number1, float number2) {
		if (number1 > number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 42 - biggestDouble: Retorna o maior entre dois valores do tipo Double.
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O maior deles.
	 */
	public static double biggestDouble (double number1, double number2) {
		if (number1 > number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 43 - biggestByteVec: Retorna o maior valor dentro de um vetor do tipo Byte.
	 * 
	 * @param Um vetor contendo valores do tipo Byte. 
	 * @return O maior valor do vetor.
	 */
	public static byte biggestByteVec (byte[] vec) {
		byte biggest = Byte.MIN_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] > biggest) {
				biggest = vec[i];
			}
		}
		return biggest;
	}
	/**
	 * 44 - biggestShortVec: Retorna o maior valor dentro de um vetor do tipo Short.
	 * @param Um vetor contendo valores do tipo Short. 
	 * @return O maior valor do vetor.
	 */
	public static short biggestShortVec (short[] vec) {
		short biggest = Short.MIN_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] > biggest) {
				biggest = vec[i];
			}
		}
		return biggest;
	}
	/**
	 * 45 - biggestIntVec: Retorna o maior valor dentro de um vetor do tipo Integer.
	 * 
	 * @param Um vetor contendo valores do tipo Integer. 
	 * @return O maior valor do vetor.
	 */
	public static int biggestIntVec (int[] vec) {
		int biggest = Integer.MIN_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] > biggest) {
				biggest = vec[i];
			}
		}
		return biggest;
	}
	/**
	 * 46 - biggestLongVec: Retorna o maior valor dentro de um vetor do tipo Long.
	 * 
	 * @param Um vetor contendo valores do tipo Long. 
	 * @return O maior valor do vetor.
	 */
	public static long biggestLongVec (long[] vec) {
		long biggest = Long.MIN_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] > biggest) {
				biggest = vec[i];
			}
		}
		return biggest;
	}
	/**
	 * 47 - biggestFloatVec: Retorna o maior valor dentro de um vetor do tipo Float.
	 * 
	 * @param Um vetor contendo valores do tipo Float. 
	 * @return O maior valor do vetor.
	 */
	public static float biggestFloatVec (float[] vec) {
		float biggest = Float.MIN_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] > biggest) {
				biggest = vec[i];
			}
		}
		return biggest;
	}
	/**
	 * 48 - biggestDoubleVec: Retorna o maior valor dentro de um vetor do tipo Double.
	 * 
	 * @param Um vetor contendo valores do tipo Double. 
	 * @return O maior valor do vetor.
	 */
	public static double biggestDoubleVec (double[] vec) {
		double biggest = Double.MIN_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] > biggest) {
				biggest = vec[i];
			}
		}
		return biggest;
	}
	/**
	 * 49 - biggestByteMat: Retorna o maior valor dentro de uma matriz do tipo Byte.
	 * 
	 * @param Uma matriz contendo valores do tipo Byte. 
	 * @return O maior valor da matriz.
	 */
	public static byte biggestByteMat (byte[][] mat) {
		byte biggest = Byte.MIN_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] > biggest) {
					biggest = mat[i][j];
				}
			}
		}
		return biggest;
	}
	/**
	 * 50 - biggestShortMat: Retorna o maior valor dentro de uma matriz do tipo Short.
	 * 
	 * @param Uma matriz contendo valores do tipo Short. 
	 * @return O maior valor da matriz.
	 */
	public static short biggestShortMat (short[][] mat) {
		short biggest = Short.MIN_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] > biggest) {
					biggest = mat[i][j];
				}
			}
		}
		return biggest;
	}
	/**
	 * 51 - biggestIntMat: Retorna o maior valor dentro de uma matriz do tipo Integer.
	 * 
	 * @param Uma matriz contendo valores do tipo Integer. 
	 * @return O maior valor da matriz.
	 */
	public static int biggestIntMat (int[][] mat) {
		int biggest = Integer.MIN_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] > biggest) {
					biggest = mat[i][j];
				}
			}
		}
		return biggest;
	}
	/**
	 * 52 - biggestLongMat: Retorna o maior valor dentro de uma matriz do tipo Long.
	 * 
	 * @param Uma matriz contendo valores do tipo Long.
	 * @return O maior valor da matriz.
	 */
	public static long biggestLongMat (long[][] mat) {
		long biggest = Long.MIN_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] > biggest) {
					biggest = mat[i][j];
				}
			}
		}
		return biggest;
	}
	/**
	 * 53 - biggestFloatMat: Retorna o maior valor dentro de uma matriz do tipo Float.
	 * 
	 * @param Uma matriz contendo valores do tipo Float. 
	 * @return O maior valor da matriz.
	 */
	public static float biggestFloatMat (float[][] mat) {
		float biggest = Float.MIN_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] > biggest) {
					biggest = mat[i][j];
				}
			}
		}
		return biggest;
	}
	/**
	 * 54 - biggestDoubleMat: Retorna o maior valor dentro de uma matriz do tipo Double.
	 * 
	 * @param Uma matriz contendo valores do tipo Double. 
	 * @return O maior valor da matriz.
	 */
	public static double biggestDoubleMat (double[][] mat) {
		double biggest = Double.MIN_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[0].length; j ++) {
				if (mat[i][j] > biggest) {
					biggest = mat[i][j];
				}
			}
		}
		return biggest;
	}
	/**
	 * 55 - smallestByte: Retorna o menor entre dois valores do tipo Byte.
	 * 
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O menor deles.
	 */
	public static byte smallestByte (byte number1, byte number2) {
		if (number1 < number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 56 - smallestShort: Retorna o menor entre dois valores do tipo Short.
	 * 
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O menor deles.
	 */
	public static short smallestShort (short number1, short number2) {
		if (number1 < number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 57 - smallestInt: Retorna o menor entre dois valores do tipo Integer.
	 * 
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O menor deles.
	 */
	public static int samllerInt (int number1, int number2) {
		if (number1 < number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 58 - smallestLong: Retorna o menor entre dois valores do tipo Long.
	 * 
	 * @param Primeiro valor;  
	 * @param Segundo valor.
	 * @return O menor deles.
	 */
	public static long smallestLong (long number1, long number2) {
		if (number1 < number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 59 - smallestFloat: Retorna o menor entre dois valores do tipo Float.
	 * 
	 * @param Primeiro n�mero;  
	 * @param Segundo n�mero.
	 * @return O menor deles.
	 */
	public static float smallestFloat (float number1, float number2) {
		if (number1 < number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 60 - smallestDouble: Retorna o menor entre dois valores do tipo Double.
	 * @param Primeiro n�mero;  
	 * @param Segundo n�mero.
	 * @return O menor deles.
	 */
	public static double smallestDouble (double number1, double number2) {
		if (number1 < number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/**
	 * 61 - smallestByteVec: Retorna o menor valor dentro de um vetor do tipo Byte.
	 * 
	 * @param Um vetor contendo valores do tipo Byte. 
	 * @return O menor valor do vetor.
	 */
	public static byte smallestByteVec (byte[] vec) {
		byte smallest = Byte.MAX_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] < smallest) {
				smallest = vec[i];
			}
		}
		return smallest;
	}
	/**
	 * 62 - smallestShortVec: Retorna o menor valor dentro de um vetor do tipo Short.
	 * 
	 * @param Um vetor contendo valores do tipo Short. 
	 * @return O menor valor do vetor.
	 */
	public static short smallestShortVec (short[] vec) {
		short smallest = Short.MAX_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] < smallest) {
				smallest = vec[i];
			}
		}
		return smallest;
	}
	/**
	 * 63 - smallestIntVec: Retorna o menor valor dentro de um vetor do tipo Integer.
	 * 
	 * @param Um vetor contendo valores do tipo Integer. 
	 * @return O menor valor do vetor.
	 */
	public static int smallestIntVec (int[] vec) {
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] < smallest) {
				smallest = vec[i];
			}
		}
		return smallest;
	}
	/**
	 * 64 - smallestLongVec: Retorna o menor valor dentro de um vetor do tipo Long.
	 * 
	 * @param Um vetor contendo valores do tipo Long. 
	 * @return O menor valor do vetor.
	 */
	public static long smallestLongVec (long[] vec) {
		long smallest = Long.MAX_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] < smallest) {
				smallest = vec[i];
			}
		}
		return smallest;
	}
	/**
	 * 65 - smallestFloatVec: Retorna o menor valor dentro de um vetor do tipo Float.
	 * 
	 * @param Um vetor contendo valores do tipo Float. 
	 * @return O menor valor do vetor.
	 */
	public static float smallestFloatVec (float[] vec) {
		float smallest = Float.MAX_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] < smallest) {
				smallest = vec[i];
			}
		}
		return smallest;
	}
	/**
	 * 66 - smallestDoubleVec: Retorna o menor valor dentro de um vetor do tipo Double.
	 * 
	 * @param Um vetor contendo valores do tipo Double. 
	 * @return O menor valor do vetor.
	 */
	public static double smallestDoubleVec (double[] vec) {
		double smallest = Byte.MAX_VALUE;
		for (int i = 0; i < vec.length; i ++) {
			if (vec[i] < smallest) {
				smallest = vec[i];
			}
		}
		return smallest;
	}
	/**
	 * 67 - smallestByteMat: Retorna o menor valor dentro de uma matriz do tipo Byte.
	 * 
	 * @param Uma matriz contendo valores do tipo Byte. 
	 * @return O menor valor da matriz.
	 */
	public static byte smallestByteMat (byte[][] mat) {
		byte smallest = Byte.MAX_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] < smallest) {
					smallest = mat[i][j];
				}
			}
		}
		return smallest;
	}
	/**
	 * 68 - smallestShortMat: Retorna o menor valor dentro de uma matriz do tipo Short.
	 * 
	 * @param Uma matriz contendo valores do tipo Short. 
	 * @return O menor valor da matriz.
	 */
	public static short smallestShortMat (short[][] mat) {
		short smallest = Short.MAX_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] < smallest) {
					smallest = mat[i][j];
				}
			}
		}
		return smallest;
	}
	/**
	 * 69 - smallestIntMat: Retorna o menor valor dentro de uma matriz do tipo Integer.
	 * 
	 * @param Uma matriz contendo valores do tipo Integer. 
	 * @return O menor valor da matriz.
	 */
	public static int smallestIntMat (int[][] mat) {
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] < smallest) {
					smallest = mat[i][j];
				}
			}
		}
		return smallest;
	}
	/**
	 * 70 - smallestLOngMat: Retorna o menor valor dentro de uma matriz do tipo Long.
	 * 
	 * @param Uma matriz contendo valores do tipo Long. 
	 * @return O menor valor da matriz.
	 */
	public static long smallestLongMat (long[][] mat) {
		long smallest = Long.MAX_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] < smallest) {
					smallest = mat[i][j];
				}
			}
		}
		return smallest;
	}
	/**
	 * 71 - smallestFloatMat: Retorna o menor valor dentro de uma matriz do tipo Float.
	 * 
	 * @param Uma matriz contendo valores do tipo Float. 
	 * @return O menor valor da matriz.
	 */
	public static float smallestFloatMat (float[][] mat) {
		float smallest = Float.MAX_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] < smallest) {
					smallest = mat[i][j];
				}
			}
		}
		return smallest;
	}
	/**
	 * 72 - smallestDoubleMat: Retorna o menor valor dentro de uma matriz do tipo Double.
	 * 
	 * @param Uma matriz contendo valores do tipo Double. 
	 * @return O menor valor da matriz.
	 */
	public static double smallestDoubleMat (double[][] mat) {
		double smallest = Double.MAX_VALUE;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				if (mat[i][j] < smallest) {
					smallest = mat[i][j];
				}
			}
		}
		return smallest;
	}
	/**
	 * 73 - sortIncByteVec: Ordena os valores contidos num vetor do tipo Byte de forma crescente.
	 * 
	 * @param Um vetor do tipo Byte.
	 */
	public static void sortIncByteVec (byte[] vec) {
		int i, j;
		byte assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] < vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 74 - sortIncShortVec: Ordena os valores contidos num vetor do tipo Short de forma crescente.
	 * 
	 * @param Um vetor do tipo Short.
	 */
	public static void sortIncShortVec (short[] vec) {
		int i, j;
		short assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] < vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 75 - sortIncIntVec: Ordena os valores contidos num vetor do tipo Integer de forma crescente.
	 * 
	 * @param Um vetor do tipo Integer.
	 */
	public static void sortIncIntVec (int[] vec) {
		int i, j, assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] < vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 76 - sortIncLongVec: Ordena os valores contidos num vetor do tipo Long de forma crescente.
	 * 
	 * @param Um vetor do tipo Long.
	 */
	public static void sortIncLongVec (long[] vec) {
		int i, j;
		long assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] < vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 77 - sortIncFloatVec: Ordena os valores contidos num vetor do tipo Float de forma crescente.
	 * 
	 * @param Um vetor do tipo Float.
	 */
	public static void sortIncFloatVec (float[] vec) {
		int i, j;
		float assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] < vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 78 - sortIncDoubleVec: Ordena os valores contidos num vetor do tipo Double de forma crescente.
	 * 
	 * @param Um vetor do tipo Double.
	 */
	public static void sortIncDoubleVec (double[] vec) {
		int i, j;
		double assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] < vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 79 - sortIncByteMat: Ordena os valores contidos numa matriz do tipo Byte de forma crescente.
	 * 
	 * @param Uma matriz do tipo Byte.
	 */
	public static void sortIncByteMat (byte[][] mat) {
		int i, j, k, l;
		byte assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] < mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 80 - sortIncShortMat: Ordena os valores contidos numa matriz do tipo Short de forma crescente.
	 * 
	 * @param Uma matriz do tipo Short.
	 */
	public static void sortIncShortMat (short[][] mat) {
		int i, j, k, l;
		short assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] < mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 81 - sortIncIntMat: Ordena os valores contidos numa matriz do tipo Integer de forma crescente.
	 * 
	 * @param Uma matriz do tipo Integer.
	 */
	public static void sortIncIntMat (int[][] mat) {
		int i, j, k, l, assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] < mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 82- sortIncLongMat: Ordena os valores contidos numa matriz do tipo Long de forma crescente.
	 * 
	 * @param Uma matriz do tipo Long.
	 */
	public static void sortIncLongMat (long[][] mat) {
		int i, j, k, l;
		long assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] < mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 83 - sortIncFloatMat: Ordena os valores contidos numa matriz do tipo Float de forma crescente.
	 * 
	 * @param Uma matriz do tipo Float.
	 */
	public static void sortIncFloatMat (float[][] mat) {
		int i, j, k, l;
		float assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] < mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 84 - sortIncDoubleMat: Ordena os valores contidos numa matriz do tipo Double de forma crescente.
	 * 
	 * @param Uma matriz do tipo Double.
	 */
	public static void sortIncDoubleMat (double[][] mat) {
		int i, j, k, l;
		double assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] < mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 85 - sortDecByteVec: Ordena os valores contidos num vetor do tipo Byte de forma decrescente.
	 * 
	 * @param Um vetor do tipo Byte.
	 */
	public static void sortDecByteVec (byte[] vec) {
		int i, j;
		byte assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] > vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 86 - sortDecShortVec: Ordena os valores contidos num vetor do tipo Short de forma decrescente.
	 * 
	 * @param Um vetor do tipo Short.
	 */
	public static void sortDecShortVec (short[] vec) {
		int i, j;
		short assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] > vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 87 - sortDecIntVec: Ordena os valores contidos num vetor do tipo Integer de forma decrescente.
	 * 
	 * @param Um vetor do tipo Integer.
	 */
	public static void sortDecIntVec (int[] vec) {
		int i, j, assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] > vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 88 - sortDecLongVec: Ordena os valores contidos num vetor do tipo Long de forma decrescente.
	 * 
	 * @param Um vetor do tipo Long.
	 */
	public static void sortDecLongVec (long[] vec) {
		int i, j;
		long assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] > vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 89 - sortDecFloatVec: Ordena os valores contidos num vetor do tipo Float de forma decrescente.
	 * 
	 * @param Um vetor do tipo Float.
	 */
	public static void sortDecFloatVec (float[] vec) {
		int i, j;
		float assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] > vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 90 - sortDecDoubleVec: Ordena os valores contidos num vetor do tipo Double de forma decrescente.
	 * 
	 * @param Um vetor do tipo Double.
	 */
	public static void sortDecDoubleVec(double[] vec) {
		int i, j;
		double assist = 0;
		for (i = 0; i < vec.length; i ++) {
			for (j = 0; j < vec.length; j ++) {
				if (vec[i] > vec[j]) {
					assist = vec[i];
					vec[i] = vec[j];
					vec[j] = assist;
				}
			}
		}
	}
	/**
	 * 91 - sortDecByteMat: Ordena os valores contidos numa matriz do tipo Byte de forma decrescente.
	 * 
	 * @param Uma matriz do tipo Byte.
	 */
	public static void sortDecByteMat (byte[][] mat) {
		int i, j, k, l;
		byte assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] > mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 92 - sortDecShortMat: Ordena os valores contidos numa matriz do tipo Short de forma decrescente.
	 * 
	 * @param Uma matriz do tipo Short.
	 */
	public static void sortDecShortMat (short[][] mat) {
		int i, j, k, l;
		short assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] > mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 93 - sortDecIntMat: Ordena os valores contidos numa matriz do tipo Integer de forma decrescente.
	 * 
	 * @param Uma matriz do tipo Integer.
	 */
	public static void sortDecIntMat (int[][] mat) {
		int i, j, k, l, assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] > mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 94 - sortDecLongMat: Ordena os valores contidos numa matriz do tipo Long de forma decrescente.
	 * 
	 * @param Uma matriz do tipo Long.
	 */
	public static void sortDecLongMat (long[][] mat) {
		int i, j, k, l;
		long assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] > mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 95 - sortDecFloatMat:  Ordena os valores contidos numa matriz do tipo Float de forma decrescente.
	 * 
	 * @param Uma matriz do tipo Float.
	 */
	public static void sortDecFloatMat (float[][] mat) {
		int i, j, k, l;
		float assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] > mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 96 - sortDecDoubleMat: Ordena os valores contidos numa matriz do tipo Double de forma decrescente.
	 * 
	 * @param Uma matriz do tipo Double.
	 */
	public static void sortDecDoubleMat (double[][] mat) {
		int i, j, k, l;
		double assist = 0;
		for (i = 0; i < mat.length; i ++) {
			for (j = 0; j < mat[i].length; j ++) {
				for (k = 0; k < mat.length; k ++) {
					for (l = 0; l < mat[i].length; l ++) {
						if (mat[i][j] > mat[k][l]) {
							assist = mat[i][j];
							mat[i][j] = mat[k][l];
							mat[k][l] = assist;
						}
					}
				}
			}
		}
	}
	/**
	 * 97 - largestByteVec: Retorna o valor mais comprido de um vetor do tipo Byte.
	 * 
	 * @param Um vetor do tipo Byte.
	 * @return Uma vari�vel do tipo Byte contendo o valor.
	 */
	public static byte largestByteVec (byte[] vec) {
		byte largest = 0;
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			String largestL = "" + largest;
			if (vecL.length() > largestL.length()) {
				largest = vec[i]; 
			}
		}
		return largest;
	}
	/**
	 * 98 - largestShortVec: Retorna o valor mais comprido de um vetor do tipo Short.
	 * 
	 * @param Um vetor do tipo Short.
	 * @return Uma vari�vel do tipo Short contendo o valor.
	 */
	public static short largestShortVec (short[] vec) {
		short largest = 0;
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			String largestL = "" + largest;
			if (vecL.length() > largestL.length()) {
				largest = vec[i]; 
			}
		}
		return largest;
	}
	/**
	 * 99 - largestIntVec: Retorna o valor mais comprido de um vetor do tipo Integer.
	 * 
	 * @param Um vetor do tipo Integer.
	 * @return Uma vari�vel do tipo Integer contendo o valor.
	 */
	public static int largestIntVec (int[] vec) {
		int largest = 0;
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			String largestL = "" + largest;
			if (vecL.length() > largestL.length()) {
				largest = vec[i]; 
			}
		}
		return largest;
	}
	/**
	 * 100 - largestLongVec: Retorna o valor mais comprido de um vetor do tipo Long.
	 * 
	 * @param Um vetor do tipo Long.
	 * @return Uma vari�vel do tipo Long contendo o valor.
	 */
	public static long largestLongVec (long[] vec) {
		long largest = 0;
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			String largestL = "" + largest;
			if (vecL.length() > largestL.length()) {
				largest = vec[i]; 
			}
		}
		return largest;
	}
	/**
	 * 101 - largestFloatVec: Retorna o valor mais comprido de um vetor do tipo Float.
	 * 
	 * @param Um vetor do tipo Float.
	 * @return Uma vari�vel do tipo Float contendo o valor.
	 */
	public static float largestFloatVec (float[] vec) {
		float largest = 0;
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			String largestL = "" + largest;
			if (vecL.length() > largestL.length()) {
				largest = vec[i];  
			}
		}
		return largest;
	}
	/**
	 * 102 - largestDoubleVec: Retorna o valor mais comprido de um vetor do tipo Double.
	 * 
	 * @param Um vetor do tipo Double.
	 * @return Uma vari�vel do tipo Double contendo o valor.
	 */
	public static double largestDoubleVec (double[] vec) {
		double largest = 0;
		for (int i = 0; i < vec.length; i ++) {
			String vecL = "" + vec[i];
			String largestL = "" + largest;
			if (vecL.length() > largestL.length()) {
				largest = vec[i]; 
			}
		}
		return largest;
	}
	/**
	 * 103 - largestByteMat: Retorna o valor mais comprido de uma matriz do tipo Byte.
	 * 
	 * @param Um matriz do tipo Byte.
	 * @return Uma vari�vel do tipo Byte contendo o valor.
	 */
	public static byte largestByteMat (byte[][] mat) {
		byte largest = 0;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				String largestL = "" + largest;
				if (matL.length() > largestL.length()) {
					largest = mat[i][j]; 
				}
			}
		}
		return largest;
	}
	/**
	 * 104 - largestShortMat: Retorna o valor mais comprido de uma matriz do tipo Short.
	 * 
	 * @param Um matriz do tipo Short.
	 * @return Uma vari�vel do tipo Short contendo o valor.
	 */
	public static short largestShortMat (short[][] mat) {
		short largest = 0;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				String largestL = "" + largest;
				if (matL.length() > largestL.length()) {
					largest = mat[i][j]; 
				}
			}
		}
		return largest;
	}
	/**
	 * 105 - largestIntMat: Retorna o valor mais comprido de uma matriz do tipo Integer.
	 * 
	 * @param Um matriz do tipo Integer.
	 * @return Uma vari�vel do tipo Integer contendo o valor.
	 */
	public static int largestIntMat (int[][] mat) {
		int largest = 0;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				String largestL = "" + largest;
				if (matL.length() > largestL.length()) {
					largest = mat[i][j]; 
				}
			}
		}
		return largest;
	}
	/**
	 * 106 - largestLongMat: Retorna o valor mais comprido de uma matriz do tipo Long.
	 * 
	 * @param Um matriz do tipo Long.
	 * @return Uma vari�vel do tipo Long contendo o valor.
	 */
	public static long largestLongMat (long[][] mat) {
		long largest = 0;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				String largestL = "" + largest;
				if (matL.length() > largestL.length()) {
					largest = mat[i][j]; 
				}
			}
		}
		return largest;
	}
	/**
	 * 107 - largestFloatMat: Retorna o valor mais comprido de uma matriz do tipo Float.
	 * 
	 * @param Um matriz do tipo Float.
	 * @return Uma vari�vel do tipo Float contendo o valor.
	 */
	public static float largestFloatMat (float[][] mat) {
		float largest = 0;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				String largestL = "" + largest;
				if (matL.length() > largestL.length()) {
					largest = mat[i][j]; 
				}
			}
		}
		return largest;
	}
	/**
	 * 108 - largestDoubleMat: Retorna o valor mais comprido de uma matriz do tipo Double.
	 * 
	 * @param Um matriz do tipo Double.
	 * @return Uma vari�vel do tipo Double contendo o valor.
	 */
	public static double largestDoubleMat (double[][] mat) {
		double largest = 0;
		for (int i = 0; i < mat.length; i ++) {
			for (int j = 0; j < mat[i].length; j ++) {
				String matL = "" + mat[i][j];
				String largestL = "" + largest;
				if (matL.length() > largestL.length()) {
					largest = mat[i][j]; 
				}
			}
		}
		return largest;
	}
	/**
	 * 109 - align: Determina a quantidade de espa�os � esquerda para o alinhamento 
	 * da escrita de valores de um vetor ou matriz contendo conjuntos de caracteres.
	 * 
	 * @param Um valor do tipo Byte que represente a diferen�a entre o comprimento do maior valor
	 * do vetor ou matriz e o valor a ser comparado.
	 * @return Uma vari�vel do tipo String contendo os espa�os complementares.
	 */
	public static String align (byte diff) {
		String spaces = "";
		if (diff == 1) {
			spaces = " ";
		}else if (diff == 2) {
			spaces = "  ";
		}else if (diff == 3) {
			spaces = "   ";
		}else if (diff == 4) {
			spaces = "    ";
		}else if (diff == 5) {
			spaces = "     ";
		}else if (diff == 6) {
			spaces = "      ";
		}else if (diff == 7) {
			spaces = "       ";
		}else if (diff == 8) {
			spaces = "        ";
		}else if (diff == 9) {
			spaces = "         ";
		}else if (diff == 10) {
			spaces = "          ";
		}else if (diff == 11) {
			spaces = "           ";
		}else if (diff == 12) {
			spaces = "            ";
		}else if (diff == 13) {
			spaces = "             ";
		}else if (diff == 14) {
			spaces = "              ";
		}else if (diff == 15) {
			spaces = "               ";
		}else if (diff == 16) {
			spaces = "                ";
		}else if (diff == 17) {
			spaces = "                 ";
		}else if (diff == 18) {
			spaces = "                  ";
		}else if (diff == 19) {
			spaces = "                   ";
		}else if (diff == 20) {
			spaces = "                    ";
		}else if (diff == 21) {
			spaces = "                     ";
		}else if (diff == 22) {
			spaces = "                      ";
		}else if (diff == 23) {
			spaces = "                       ";
		}else if (diff == 24) {
			spaces = "                        ";
		}else if (diff == 25) {
			spaces = "                         ";
		}else if (diff == 26) {
			spaces = "                          ";
		}else if (diff == 27) {
			spaces = "                           ";
		}else if (diff == 28) {
			spaces = "                            ";
		}else if (diff == 29) {
			spaces = "                             ";
		}else {
			spaces = "Is it really necessary dude?!!";
		}
		return spaces;
	}

}