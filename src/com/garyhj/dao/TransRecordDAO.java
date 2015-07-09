package com.garyhj.dao;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.garyhj.entity.CustInfo;
import com.garyhj.entity.TransRecord;

public class TransRecordDAO {
	// 文件名可随意指定，你可以用文本编辑器打开这个文件（注意，记事本无法处理换行）
	static String filename = "Trans_Records.xls";

	public void saveTransRecords(TransRecord transRecord)
			throws IOException {
		File file = new File("Trans_Records.xls");
		if (!file.exists()) {
			createNewSheet();
		}
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(
					FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			int rowcount = sheet.getLastRowNum();

			HSSFRow nextrRow = sheet.createRow(rowcount + 1);
			HSSFCell cell = nextrRow.createCell(0);
			cell.setCellValue(transRecord.getTrans_id());
			HSSFCell cell1 = nextrRow.createCell(1);
			cell1.setCellValue(transRecord.getCreate_time());
			HSSFCell cell2 = nextrRow.createCell(2);
			cell2.setCellValue(transRecord.getTrans_status());
			HSSFCell cell3 = nextrRow.createCell(3);
			cell3.setCellValue(transRecord.getTrans_type());
			HSSFCell cell4 = nextrRow.createCell(4);
			cell4.setCellValue(transRecord.getTrans_amount());
			HSSFCell cell5 = nextrRow.createCell(5);
			cell5.setCellValue(transRecord.getTrans_currency());
			HSSFCell cell6 = nextrRow.createCell(6);
			cell6.setCellValue(transRecord.getCust_info().toString());
			
			

			FileOutputStream fileOutputStream = FileUtils
					.openOutputStream(file);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 读取并显示 Person 对象
	public ArrayList<TransRecord> readAndShow() throws IOException {
		File file = new File("Trans_Records.xls");
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(
					FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);

			ArrayList<TransRecord> list = new ArrayList<TransRecord>();

			int firstRowNum = 1;
			int lastRowNum = sheet.getLastRowNum();

			for (int i = firstRowNum; i <= lastRowNum; i++) {

				TransRecord transRecord = new TransRecord();
				HSSFRow row = sheet.getRow(i);

				HSSFCell cell = row.getCell(0);
				transRecord.setTrans_id(cell.getStringCellValue());
				HSSFCell cell1 = row.getCell(1);
				transRecord.setCreate_time(cell1.getStringCellValue());
				HSSFCell cell2 = row.getCell(2);
				transRecord.setTrans_status(cell2.getStringCellValue());
				HSSFCell cell3 = row.getCell(3);
				transRecord.setTrans_type(cell3.getStringCellValue());
				HSSFCell cell4 = row.getCell(4);
				transRecord.setTrans_amount(cell4.getStringCellValue());
				HSSFCell cell5 = row.getCell(5);
				transRecord.setTrans_currency((cell5.getStringCellValue()));
				HSSFCell cell6 = row.getCell(6);
				transRecord.setCust_info(cell6.getStringCellValue());
				list.add(transRecord);

//				int lastCellNum = row.getLastCellNum();
//				for (int j = 0; j < lastCellNum; j++) {
//					HSSFCell cell = row.getCell(j);
//					String value = getCellStringValue(cell);
//
//					System.out.print(value + "\t");
//				}

				System.out.println();
			}
			
			workbook.close();
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getCellStringValue(HSSFCell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:// 字符串类型
			cellValue = cell.getStringCellValue();
			if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
				cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_NUMERIC: // 数值类型
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_FORMULA: // 公式
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}
		return cellValue;
	}

	
	public void createNewSheet(){
		String[] title = {"trans_id","create_time","trans_status","trans_type","trans_amount","trans_currency","cust_info"};
		//创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建sheet
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell =null;
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		File file = new File("Trans_Records.xls");
		try {
			file.createNewFile();
			FileOutputStream fileOutputStream = FileUtils.openOutputStream(file);
			workbook.write(fileOutputStream);
			fileOutputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("*******************************************");
	}


}
