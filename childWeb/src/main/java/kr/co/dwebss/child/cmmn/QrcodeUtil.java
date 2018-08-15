package kr.co.dwebss.child.cmmn;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Component("qrcodeUtil")
public class QrcodeUtil { 

    @Value("${qrcodePath}") 
	String qrcodePath;
    
    @Value("${qrcodeUrl}") 
    String qrcodeUrl;

	private static final Logger LOGGER = LoggerFactory.getLogger(QrcodeUtil.class);

	/**
	 * QR코드를 저장한다.
	 *
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public String generateQrCode(String uuid) throws Exception {

        //TODO 추후 추가해야함 base64
        String res="res";
        
		try {
            File file = null;
            // 큐알이미지를 저장할 디렉토리 지정
            file = new File(qrcodePath);
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소
            // 큐알코드 바코드 생상값
            int qrcodeColor =   0xFF2e4e96;
            // 큐알코드 배경색상값
            int backgroundColor = 0xFFFFFFFF;
             
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            
            //TODO QR버젼 1로 바꿔야함 
//            Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
//            hints.put(EncodeHintType.QR_VERSION, 1);
//            BitMatrix bitMatrix = qrCodeWriter.encode(qrcodeUrl+uuid, BarcodeFormat.QR_CODE,200, 200, hints);

            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(qrcodeUrl+uuid, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            

            
            

            File qrFile = new File(qrcodePath+uuid+".png");
            // ImageIO를 사용한 바코드 파일쓰기
            ImageIO.write(bufferedImage, "png", qrFile);
            res = qrcodePath+uuid+".png";
//            res = encodeFileToBase64Binary(qrFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return res;  
	}
	

    private static String encodeFileToBase64Binary(File file){
         String encodedfile = null;
         try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

         return encodedfile;
     }
}
