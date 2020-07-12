package com.callor.address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.address.config.Lines;
import com.callor.address.model.AddrVO;

public class AddrServiceImplV1 implements AddrService {

	List<AddrVO> addressList;
	
	public AddrServiceImplV1() {
		addressList = new ArrayList<AddrVO>();
	}
	
	@Override
	public boolean inputAddr() {
		
		Scanner scan = new Scanner(System.in);
		AddrVO aVO = new AddrVO();
		
		// 이름
		System.out.print("이름 (END : ) : ");
		String strName = scan.nextLine();
		
		if(strName.equals("END")) {
			return false;
		}
		
		aVO.setName(strName);
		
		// 주소
		System.out.print("주소 (END : ) : ");
		String strAddr= scan.nextLine();
		
		if(strAddr.equals("END")) {
			return false;
		}
		
		aVO.setAddr(strAddr);
		
		// 전화번호
		System.out.print("번호 (END : ) : ");
		String strTel= scan.nextLine();
		
		if(strTel.equals("END")) {
			return false;
		}
		
		aVO.setTel(strTel);
		
		// 나이
		System.out.print("나이 (END : ) : ");
		String strAge= scan.nextLine();
		
		if(strAge.equals("END")) {
			return false;
		}
		
		int intAge = 0;
		try {
			intAge = Integer.valueOf(strAge);
		} catch (Exception e) {
			
		}
		
		aVO.setAge(intAge);
		
		// 관계
		System.out.print("관계 (END : ) : ");
		String strNet = scan.nextLine();
		
		if(strNet.equals("END")) {
			return false;
		}
		
		aVO.setNet(strNet);
		
		addressList.add(aVO);
		return true;
	} // >>>>> inputAddr() method 종료 :)

	@Override
	public void addrList() {

		System.out.println(Lines.dLine);
		System.out.println("주소록");
		System.out.println(Lines.dLine);
		System.out.println("이름\t전화번호\t주소\t나이\t관계");
		System.out.println(Lines.sLine);
		
		for(AddrVO aVO : addressList) {
			System.out.print(aVO.getName() + "\t");
			System.out.print(aVO.getTel() + "\t\t");
			System.out.print(aVO.getAddr() + "\t");
			System.out.print(aVO.getAge() + "\t");
			System.out.println(aVO.getNet());
			
		}
		System.out.println(Lines.dLine);
	}

}
