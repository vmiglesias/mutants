package org.evil.mutants.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Qualifier("findVerticalMutants")
public class FindVerticalMutants implements DNAVerification{

	@Value("${mutant.quantity.sequence:4}")
	private int mutantMaxSeq;
	
	
	@Override
	public boolean isSequenceComlete(String[] dnaChain) {
		//convert dnaChain in vertical dnaChain
		String[] verticalDnaChain = generateVerticalDnaChain(dnaChain);
		boolean isSequenceComplete = false;
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
		return isSequenceComplete;
	}
	
	
	
	private String generateSequenceToFind(Character current , int mutantMaxSeq) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mutantMaxSeq; i++) {
			sb.append(current);
		}
		return sb.toString();
	}

	private String[] generateVerticalDnaChain(String[] dnaChain) {
		
		String[] verticalDnaChain = new String[dnaChain[0].length()];
		for (int i = 0; i < dnaChain.length; i++) {
			char[] assetsArray = dnaChain[i].toCharArray();
			//loop character of dna link
			for (int j = 0; j < assetsArray.length; j++) {
				verticalDnaChain[j] = (verticalDnaChain[j]!=null?verticalDnaChain[j]+assetsArray[j]:String.valueOf(assetsArray[j]));
			}
			
		}
		return verticalDnaChain;
	}
	
	
}
