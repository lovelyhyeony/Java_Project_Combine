package com.biz.student.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.biz.student.domain.Student;

/*
 * student.txt파일을 읽어서 studentList에 저장하고
 * student_list.txt 파일에 학생명부 출력
 * 
 * inputStudent method를 변경하여
 * 전공이 컴퓨터공학인 학생들만 리스트를 추출하시오 
 */
public class StudentServiceImplV5 extends StudentServiceImplV2 {

	public StudentServiceImplV5() {
		outPut = System.out;
	}

	@Override
	public boolean inputStudent() {
		
		String studentFile = "src/com/biz/student/exec/student.txt";
		
		FileReader fileReader = null;
		
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(studentFile);
			buffer = new BufferedReader(fileReader);

			String reader = "";

			while(true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}
				
				String[] students = reader.split(":");
				
				Student std = new Student();
				
				std.setNum(students[0]);
				std.setName(students[1]);
				std.setGrade(Integer.valueOf(students[2]));
				std.setDept(students[4]);
				
				if(std.getDept().equals("컴퓨터공학")) {	
					studentList.add(std);
				}
			}
			
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}