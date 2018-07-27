package kr.co.dwebss.child.dao;

import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.ChildQrCode;

public interface ChildQrCodeMapper extends Mapper<ChildQrCode> {

	List<ChildQrCode> selectQrcode(ChildQrCode vo);

	List<ChildQrCode> selectQrcodeArray(ChildQrCode vo);
}