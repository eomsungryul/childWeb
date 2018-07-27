package kr.co.dwebss.child.service;
import kr.co.dwebss.child.model.ChildQrCode;

import java.util.List;

import kr.co.dwebss.child.core.Service;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
public interface ChildQrCodeService extends Service<ChildQrCode> {

	List<ChildQrCode> selectQrcode(ChildQrCode vo);

	List<ChildQrCode> selectQrcodeArray(ChildQrCode vo);

}
