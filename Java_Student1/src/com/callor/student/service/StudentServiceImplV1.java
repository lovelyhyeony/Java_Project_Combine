package com.callor.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.config.Lines;
import com.callor.student.domain.StudentVO;

public class StudentServiceImplV1 implements StudentService {

	private List<StudentVO> stdList;

	public StudentServiceImplV1() {
		stdList = new ArrayList<StudentVO>();
	}

	@Override
	public boolean inputStudent() {
		Scanner scan = new Scanner(System.in);
		StudentVO stdVO = new StudentVO();

		// 학번
		System.out.print("학번 (END 종료) : ");
		String stdNum = scan.nextLine();

		if (stdNum.equals("END")) {
			return false;
		}

		stdVO.setNum(stdNum);

		// 이름
		System.out.print("이름 (END 종료) : ");
		String stdName = scan.nextLine();

		if (stdName.equals("END")) {
			return false;
		}

		stdVO.setName(stdName);

		// 전공
		System.out.print("전공 (END 종료) : ");
		String stdDept= scan.nextLine();

		if (stdDept.equals("END")) {
			return false;
		}

		stdVO.setDept(stdDept);
		
		// 학년
		System.out.print("학년 (END 종료) : ");
		String stdGrade= scan.nextLine();

		if (stdGrade.equals("END")) {
			return false;
		}

		int intGrade = 0;
		try {
			intGrade = Integer.valueOf(stdGrade);
		} catch (Exception e) {
			System.out.println("학년은 숫자만 가능 :("
					+ "다시 입력해주세요 :)");
			return true;
		}
		
		stdVO.setGrade(intGrade);
		
		// 전화번호
		System.out.print("전화번호 (END 종료) : ");
		String stdTel= scan.nextLine();

		if (stdTel.equals("END")) {
			return false;
		}

		stdVO.setTel(stdTel);
		
		stdList.add(stdVO);
		return true;
	}

	// 리스트 출력
	@Override
	public void studentList() {

		System.out.println(Lines.dLine);
		System.out.println("학생명부");
		System.out.println(Lines.dLine);
		System.out.println("학번\t이름\t전공\t학년\t전화번호");
		System.out.println(Lines.sLine);
		
		for(StudentVO stdVO : stdList) {
			
			System.out.print(stdVO.getNum() +"\t");
			System.out.print(stdVO.getName() +"\t");
			System.out.print(stdVO.getDept() +"\t");
			System.out.print(stdVO.getGrade() +"\t");
			System.out.println(stdVO.getTel());
			
		}
		System.out.println(Lines.dLine);
	}
}
