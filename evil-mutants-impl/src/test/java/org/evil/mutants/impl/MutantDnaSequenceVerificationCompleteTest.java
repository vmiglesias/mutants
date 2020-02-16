package org.evil.mutants.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {FindHorizontalMutants.class, FindVerticalMutants.class, FindDiagonalMutants.class})
public class MutantDnaSequenceVerificationCompleteTest {
	
	@Autowired
	@Qualifier("findHorizontalMutants")
	private DNAVerification horizontalDNAVerificationService;
	
	@Autowired
	@Qualifier("findVerticalMutants")
	private DNAVerification verticalDNAVerificationService;
	
	
	@Autowired
	@Qualifier("findDiagonalMutants")
	private DNAVerification diagonalDNAVerificationService;
	
	public String[] horizontalMutantDnaChain;
	public String[] verticalMutantDnaChain;
	public String[] diagonalMutantDnaChain;
	
	@Before
	public void setup() {
		
		
	}
	
	
	@Test
	public void horizontalDnaSequenceCompleteVerification() {
		horizontalMutantDnaChain = new String[]{"ATGCGA","CGGTGC","TTATTT","AGAAGG","CCCCTA","TCACTG"};
		assertTrue(horizontalDNAVerificationService.isSequenceComlete(horizontalMutantDnaChain));
	}
	
	@Test
	public void verticalDnaSequenceCompleteVerification() {
		verticalMutantDnaChain = new String[]{"ATGCGA","CGGTGC","TTATGT","AGAAGG","CACCTA","TCACTG"};
		assertTrue(verticalDNAVerificationService.isSequenceComlete(verticalMutantDnaChain));
	}
	
	@Test
	public void diagonalDnaSequenceCompleteVerification() {
		diagonalMutantDnaChain = new String[]{"ATGCGA","CAGTGC","TTATTT","AGAAGG","CCCATA","TCACTG"};
		assertTrue(diagonalDNAVerificationService.isSequenceComlete(diagonalMutantDnaChain));
	}
	
	
}
