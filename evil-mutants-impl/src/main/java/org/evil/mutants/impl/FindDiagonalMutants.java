package org.evil.mutants.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Qualifier("findDiagonalMutants")
public class FindDiagonalMutants implements DNAVerification{

	@Value("${mutant.quantity.sequence:4}")
	private int mutantMaxSeq;
	
	
	@Override
	public boolean isSequenceComlete(String[] dnaChain) {
		//convert dnaChain in vertical dnaChain
		Character[][] matrixDnaChain = generateMatrixDnaChain(dnaChain);
		
		boolean isSequenceComplete = false;
		System.out.println(loopDiagonally(matrixDnaChain));
		/*
		//loop verticalChain
		for (int i = 0; i < verticalDnaChain.length; i++) {
			char[] assetsArray = verticalDnaChain[i].toCharArray();
			//loop character of dna link
			for (int j = 0; j < assetsArray.length; j++) {
				//generate sequence to find dinamically
				String sequenceToFind = generateSequenceToFind(assetsArray[j], mutantMaxSeq);
				//check if sequence generated matchig with looped dna piece
				int index = verticalDnaChain[i].indexOf(sequenceToFind);
				if(index!=-1){
					isSequenceComplete = true;
					break;
				}
			}
			if(isSequenceComplete) {
				break;
			}
		}
		*/
		return isSequenceComplete;
	}
	
	private void printDiagonal(int i, int j, Character[][] matrix) {
		while(i >= 0 && j < matrix[0].length) {
			System.out.println(matrix[i][j]+"  ");
			i--;
			j++;
		}
	}
	
	private String generateSequenceToFind(Character current , int mutantMaxSeq) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mutantMaxSeq; i++) {
			sb.append(current);
		}
		return sb.toString();
	}

	private Character[][] generateMatrixDnaChain(String[] dnaChain) {
		
		Character[][] matrixDnaChain = new Character[dnaChain.length][dnaChain[0].length()];
		for (int i = 0; i < dnaChain.length; i++) {
			char[] assetsArray = dnaChain[i].toCharArray();
			//loop character of dna link
			for (int j = 0; j < assetsArray.length; j++) {
				matrixDnaChain[i][j]=assetsArray[j];
			}
			
		}
		return matrixDnaChain;
	}
	
	
	private String loopDiagonally(Character[][] twoDArray) {

		 int length = twoDArray.length;
	        int diagonalLines = (length + length) - 1;
	        int itemsInDiagonal = 0;
	        int midPoint = (diagonalLines / 2) + 1;
	        StringBuilder output = new StringBuilder();
	         	
	        for (int i = 1; i <= diagonalLines; i++) {

	            StringBuilder items = new StringBuilder();
	            int rowIndex;
	            int columnIndex;

	            if (i <= midPoint) {
	                itemsInDiagonal++;
	                for (int j = 0; j < itemsInDiagonal; j++) {
	                    rowIndex = (i - j) - 1;
	                    columnIndex = j;
	                    items.append(twoDArray[rowIndex][columnIndex]);
	                }
	            } else {
	                itemsInDiagonal--;
	                for (int j = 0; j < itemsInDiagonal; j++) {
	                    rowIndex = (length - 1) - j;
	                    columnIndex = (i - length) + j;
	                    items.append(twoDArray[rowIndex][columnIndex]);
	                }
	            }

	            if (i != diagonalLines) {
	                output.append(items).append(" ");
	            } else {
	                output.append(items);
	            }
	        }
		
        itemsInDiagonal = 0;
        output.append(" ");
        for (int i = 1; i <= diagonalLines; i++) {

        	StringBuilder items = new StringBuilder();
            int rowIndex;
            int columnIndex;

            if (i <= midPoint) {
                itemsInDiagonal++;
                for (int j = 0; j < itemsInDiagonal; j++) {
                	rowIndex = (i - j) - 1;
                    columnIndex = (length-1) - j;
                    items.append(twoDArray[rowIndex][columnIndex]);
                }
               
            } else {
                itemsInDiagonal--;
                for (int j = 0; j < itemsInDiagonal; j++) {
                  	rowIndex = (length - 1) - j;
                    columnIndex = (itemsInDiagonal - 1) - j;
                    items.append(twoDArray[rowIndex][columnIndex]);
                }
            }

            if (i != diagonalLines) {
                output.append(items).append(" ");
            } else {
                output.append(items);
            }
        }
        return output.toString();
    }
	
	
}
