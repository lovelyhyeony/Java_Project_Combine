package com.callor.address.exec;

import com.callor.address.service.AddrService;
import com.callor.address.service.AddrServiceImplV1;

public class AddrEx_01 {

	public static void main(String[] args) {
		
		AddrService aS = new AddrServiceImplV1();
		
		while(true) {
			if(!aS.inputAddr()) {
				break;
			}
		}
		
		aS.addrList();
		
	}
}
