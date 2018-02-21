package com.ahpu.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;

import com.ahpu.entity.QuestionList;
import com.ahpu.entity.Questionnaire;
import com.ahpu.entity.TChoose;
import com.ahpu.entity.TGetquestion;

public class OUtPutStreamUtil {

	public static void exportExcel(HttpServletResponse response, Questionnaire questionnaire) {
		
		Map<Integer,Integer> sum_map = new HashMap<Integer,Integer>();
		
		String filename = "Questionnaire-"+UUID.randomUUID();// 文件名
		response.setHeader("Content-Disposition", "attachment;filename=" + filename + ".xls");
		
		try {
			
			//创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//指定工作表名
			HSSFSheet sheet = workbook.createSheet("调查问卷");
			//设置字体
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short)18);
			font.setFontName("宋体");
			//创建单元格样式
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
			
			HSSFCellStyle style1 = workbook.createCellStyle();
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			
			//**********************第一行**********************//
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 14));//起始行 结束行  起始列 结束列
			HSSFRow row1 = sheet.createRow(0);
			row1.setHeightInPoints(28);
			HSSFCell cell1 = row1.createCell(0);
			cell1.setCellStyle(style);
			cell1.setCellValue(questionnaire.getTitle());
			
			//**********************第二行question**********************//
			
			HSSFRow row2 = sheet.createRow(1);
			HSSFCell cell2 = null;
			//合并单元格
			int a = 1;//起始行
			int b = 1;//结束行
			int c = 1;//起始列   空一格
			int d = 0;//结束列
			int cell_Num = 1;//问题序号
			
			//**********************第三行choose**********************//
			HSSFRow row3 = sheet.createRow(2);
			HSSFCell cell3 = null;
			int row_Cell = 1;//该行当前的单元格
			cell3 = row3.createCell(0);
			cell3.setCellStyle(style1);//***************************************************************
			cell3.setCellValue("序号");
			
			//**********************第四行-第N行**********************//
			
			int row_N = 3;//创建的初始行号
			int defaultCellValue = 1;
			HSSFRow row_n = null;
			HSSFCell cell_n = null;
			
			//**********************开始遍历-提交问卷题干**********************//
			
			for (QuestionList questionList : questionnaire.getQuestionListList()) {
				d += questionList.getChooseList().size();//1 1 1 2
				
				sheet.addMergedRegion(new CellRangeAddress(a,b,c,d));
				cell2 = row2.createCell(c);
				cell2.setCellValue(cell_Num+"、"+questionList.getQuestion());
				cell2.setCellStyle(style1);
				cell_Num++;
				c += questionList.getChooseList().size();
				
				for (TChoose choose : questionList.getChooseList()) {
					cell3 = row3.createCell(row_Cell);
					cell3.setCellValue(choose.getOptioncontent());
					cell3.setCellStyle(style1);
					row_Cell++;
				}
			}
			
			//**********************开始遍历-提交问卷选项**********************//
			
			for (List<TGetquestion> getQuestionList : questionnaire.getGetQuestionListList()) {
				
				int cell_x = 0;
				row_n = sheet.createRow(row_N);//创建第N行
				cell_n = row_n.createCell(0);
				cell_n.setCellValue(row_N-2);
				cell_n.setCellStyle(style1);
				int next_question_count = 1;
				int this_cell = 0;
				
				for (TGetquestion getQuestion : getQuestionList) {
					this_cell = Integer.parseInt(getQuestion.getChoose()) + cell_x;
					
					//从map里面获取该选项的列，如果没有就设置为1，有就+1
					if(sum_map.get(this_cell) == null){
						sum_map.put(this_cell, 1);
					}else{
						sum_map.put(this_cell, sum_map.get(this_cell) + 1);
					}
					
					cell_n = row_n.createCell(this_cell);//第N行的第N个单元格
					cell_n.setCellValue(defaultCellValue);
					cell_n.setCellStyle(style1);
					//Ismultiple 表示该问题被提交了多个选项  值为选项的数量
					//判断是否为多选并且提交了多个数据 cell_x=  2
					
					if(getQuestion.getIsmultiple() != null){
						
						if(next_question_count < getQuestion.getIsmultiple()){
							next_question_count++;
						}else{
							cell_x += getQuestion.getChoosenum();
							next_question_count = 1;//下一个问题，将next_question_count重置为1
						}
					}else{
						//推向下一个问题
						cell_x += getQuestion.getChoosenum();
					}
				}
				row_N++;
			}
			
			//数据统计
			row_n = sheet.createRow(row_N);//创建第最后一行
			cell_n = row_n.createCell(0);
			cell_n.setCellValue("统计");
			cell_n.setCellStyle(style1);
			for(int i = 1;i < sum_map.size() + 1;i++){
				cell_n = row_n.createCell(i);
				cell_n.setCellValue(sum_map.get(i));
				cell_n.setCellStyle(style1);
			}
			
			
			
			
			
			
			
			
			
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
