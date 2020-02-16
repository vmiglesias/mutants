package org.evil.mutants.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Qualifier("findHorizontalMutants")
public class FindHorizontalMutants implements DNAVerification{

	@Value("${mutant.quantity.sequence:4}")
	private int mutantMaxSeq;
	
	
	@Override
	public boolean isSequenceComlete(String[] dnaChain) {
		boolean isSequenceComplete = false;
		//loop dnaChain
		for (int i = 0; i < dnaChain.length; i++) {
			char[] assetsArray = dnaChain[i].toCharArray();
			//loop character of dna link
			for (int j = 0; j < assetsArray.length; j++) {
				//generate sequence to find dinamically
				String sequenceToFind = generateSequenceToFind(assetsArray[j], mutantMaxSeq);
				//check if sequence generated matchig with looped dna piece
				int index = dnaChain[i].indexOf(sequenceToFind);
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

	
	
	
}
