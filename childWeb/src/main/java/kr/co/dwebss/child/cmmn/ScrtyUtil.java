package kr.co.dwebss.child.cmmn;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component("scrtyUtil")
public class ScrtyUtil {
	

	/**
	 * api키와 id를 암호화하는 기능
	 *
	 * @param apikey 암호화될 패스워드
	 * @param id salt로 사용될 사용자 ID 지정
	 * @return
	 * @throws Exception
	 */
	public static String encryptApi(String apikey, String id) throws Exception {
		 StringBuffer sbuf = new StringBuffer();
	     
		    MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		    mDigest.update(id.getBytes());
		    byte[] msgStr = mDigest.digest(apikey.getBytes()) ;
		     
		    for(int i=0; i < msgStr.length; i++){
		        byte tmpStrByte = msgStr[i];
		        String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
		         
		        sbuf.append(tmpEncTxt) ;
		    }
		return sbuf.toString();
	}
	
	public static String LockPassword(String password) throws Exception {
	     try {
	         MessageDigest digest = MessageDigest.getInstance("SHA-256");
	         byte[] hash = digest.digest(password.getBytes("UTF-8"));
	         StringBuffer hexString = new StringBuffer();
	
	         for (int i = 0; i < hash.length; i++) {
	             String hex = Integer.toHexString(0xff & hash[i]);
	             if (hex.length() == 1)
	                 hexString.append('0');
	             hexString.append(hex);
	         }
	         // 출력
	         System.out.println(hexString.toString());
			return hexString.toString();
			
	     } catch (Exception ex) {
	         throw new RuntimeException(ex);
	     }

	 }


}
