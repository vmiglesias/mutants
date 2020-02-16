package org.evil.mutants.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("assetValidator")
public class AssetValidatorImpl implements AssetValidator {

	@Override
	public boolean isValidDNAAsset(String asset, String validAssets) {
		boolean isValidAsset = true;
		char[] validAssetsArray = validAssets.toCharArray();
		char[] assetArray = asset.toCharArray();
		int founded = 0;
		for (int i = 0; i < assetArray.length; i++) {
			for (int j = 0; j < validAssetsArray.length; j++) {
				if(assetArray[i]==validAssetsArray[j]) {
					founded = founded+1;
				}
			}
			if (founded==0) {
				isValidAsset = false;
				break;
			}else {
				founded=0;
			}
				
		}
		return isValidAsset;
	}

}
