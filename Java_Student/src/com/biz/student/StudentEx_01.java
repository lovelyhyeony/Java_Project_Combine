package com.biz.student;

import com.biz.student.service.StudentService;
import com.biz.student.service.StudentServiceImplV1;

public class StudentEx_01 {
	public static void main(String[] args) {

		StudentService student = new StudentServiceImplV1();

		while (true) {
			if (!student.inputStudent()) {
				break;
			}
		}

		student.studentList();
	}
}
