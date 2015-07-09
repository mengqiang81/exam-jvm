package com.garyhj.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.garyhj.entity.TransRecord;

public class TransRecordDAO {
	//Ĭ�ϵĽ��׼�¼�ļ�
	static String filename = "Trans_Records.xls";

	/**
	 * ����һ�����׼�¼����һ������д�뵽excel��
	 * @param transRecord ����Ľ��׼�¼
	 * @throws IOException
	 */
	public void saveTransRecords(TransRecord transRecord)throws IOException {
		//�����ļ������ڣ������ļ�
		File file = new File("Trans_Records.xls");
		if (!file.exists()) {
			createNewSheet();
		}
		try {
			//�½�������
			HSSFWorkbook workbook = new HSSFWorkbook(
					FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			int rowcount = sheet.getLastRowNum();
			//��һ�����׼�¼���뵽һ����
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
			//������д�뵽�ļ���
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

	/**
	 * ��ѯȫ������	��ȡ�ļ����ݣ������ݷ���list��
	 * @return
	 * @throws IOException
	 */
	public ArrayList<TransRecord> findAll() throws IOException {
		File file = new File("Trans_Records.xls");
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);

			ArrayList<TransRecord> list = new ArrayList<TransRecord>();
			//�ӵڶ��п�ʼ����һ��Ϊ����
			int firstRowNum = 1;
			int lastRowNum = sheet.getLastRowNum();//���һ�е�λ�ã���0��ʼ

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

	/**
	 * ���ս���״̬��������
	 * @param type
	 * @return
	 */
	public ArrayList<TransRecord> findByType(String type){
		File file = new File("Trans_Records.xls");
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);

			ArrayList<TransRecord> list = new ArrayList<TransRecord>();
			//�ӵڶ��п�ʼ����һ��Ϊ����
			int firstRowNum = 1;
			int lastRowNum = sheet.getLastRowNum();//���һ�е�λ�ã���0��ʼ

			for (int i = firstRowNum; i <= lastRowNum; i++) {

				TransRecord transRecord = new TransRecord();
				HSSFRow row = sheet.getRow(i);
				
				HSSFCell cell = row.getCell(0);
				transRecord.setTrans_id(cell.getStringCellValue());
				HSSFCell cell1 = row.getCell(1);
				transRecord.setCreate_time(cell1.getStringCellValue());
				//ɸѡ����
				HSSFCell cell2 = row.getCell(2);
				if (!cell2.getStringCellValue().equals(type)) {
					continue;
				}
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
		case HSSFCell.CELL_TYPE_STRING:// �ַ�������
			cellValue = cell.getStringCellValue();
			if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
				cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_NUMERIC: // ��ֵ����
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_FORMULA: // ��ʽ
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
		//����������
		HSSFWorkbook workbook = new HSSFWorkbook();
		//����sheet
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
		System.out.println("*************��ʼ��������********************");
	}


}
