package org.evil.mutants.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AssetValidatorImpl.class})
public class DnaAssetsValidationTest {
	
	private static final String DNA_VALID_ASSET="ACCTGSA";
	private static final String DNA_NOT_VALID_ASSET="ACCSSSGAF";
	
	@Value("${evil.mutants.dna.valid.assets}")
	private String validAssets;
	
	@Autowired
	private AssetValidator assetValidator;
	
	
	
	@Test
	public void trueDnaAssetValidation() {
		boolean isValidAsset = assetValidator.isValidDNAAsset(DNA_VALID_ASSET, validAssets);
		assertTrue(isValidAsset);
	}
	
	@Test
	public void falseDnaAssetValidation() {
		boolean isValidAsset = assetValidator.isValidDNAAsset(DNA_NOT_VALID_ASSET, validAssets);
		assertFalse(isValidAsset);
	}
	
}
