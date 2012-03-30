package com.skycargo.util;

public class GeneralUtil {
	public static final String SPACE_CHAR=" ";
	
	public static String createJavaVarName(String paramName){

		StringBuffer sbuff=new StringBuffer(paramName.trim().toLowerCase());

		//make first character lower
		char chFirst=sbuff.charAt(0);
		if(Character.isUpperCase(chFirst)){
			chFirst=Character.toLowerCase(chFirst);
			sbuff.replace(0, 1, String.valueOf(chFirst));
		}

		int i=sbuff.indexOf(SPACE_CHAR);
		while(i!=-1){
			sbuff.delete(i, i+1);
			char ch=sbuff.charAt(i);

			if(!Character.isSpaceChar(ch)){
				if(i==0 && Character.isUpperCase(ch)){
					ch=Character.toLowerCase(ch);
					sbuff.replace(i, i+1, String.valueOf(ch));
				}else if(!Character.isUpperCase(ch)){
					ch=Character.toUpperCase(ch);
					sbuff.replace(i, i+1, String.valueOf(ch));
				}
			}
			i=sbuff.indexOf(SPACE_CHAR);
		}
		return sbuff.toString();
	}
	

	
}
