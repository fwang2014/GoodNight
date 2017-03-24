package com.nutz.pip.common.excel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;

import org.nutz.lang.Lang;

import com.nutz.pip.Constants;
import com.nutz.pip.common.MyUtil;
import com.nutz.pip.dao.data.DataimportInfoDao;
import com.nutz.pip.model.data.DataimportContent;
import com.nutz.pip.model.data.DataimportPart;

/**
 * excel工具类
 * 
 * @author Administrator create by fwang 2013.10.26
 * 
 */
public class ExcelUtil {

	private Sheet sheets[];
	private Workbook wb;
	private static final int MAX_ROWS = 5000;//最大行数
	private static final int MAX_COLS = 100;//最大列数

	public ExcelUtil(InputStream is) throws ExelException{
		try {
			wb = Workbook.getWorkbook(is);
			sheets = wb.getSheets();
		} catch (BiffException e) {
			//e.printStackTrace();
			throw Lang.wrapThrow(e,ExelException.class);
		} catch (IOException e) {
			//e.printStackTrace();
			throw Lang.wrapThrow(e, ExelException.class);
		}
	}

	public ExcelUtil(File file) throws ExelException {
		try {
			wb = Workbook.getWorkbook(file);
			sheets = wb.getSheets();
		} catch (BiffException e) {
			//e.printStackTrace();
			throw Lang.wrapThrow(e,ExelException.class);
		} catch (IOException e) {
			//e.printStackTrace();
			throw Lang.wrapThrow(e, ExelException.class);
		}
	}
	
	public void readSheet(int index){
		Sheet sheet = sheets[index];
		System.out.println(sheet.getName());
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		if(rows > MAX_ROWS | cols > MAX_COLS){
			Lang.wrapThrow(new Exception("ERROR INFO:MAX ROWS:5000;MAX COLOMNS:100"), ExelException.class);
		}
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				Cell cell = sheet.getCell(j, i);
				/*CellFormat cf = cell.getCellFormat();
				String cfs = (cf == null?"":cf.toString());
				CellType ct = cell.getType();
				String cts = (ct==null?"":ct.toString());*/
				String content = cell.getContents();
				//System.out.print("i:"+i+" j:"+j+" cf:"+cfs+" ct:"+cts+" content:"+content+"\t");
				System.out.print(content+"\t\t");
			}
			System.out.println();
		}
	}
	
	public Sheet[] getSheets(){
		return this.sheets;
	}
	
	/**
	 * 保存当前页数据
	 * @param dao
	 * @param sheet
	 */
	public void saveSheet(DataimportInfoDao dao,Sheet sheet,long import_id){
		if(Lang.isEmpty(dao) || Lang.isEmpty(sheet)){
			Lang.wrapThrow(new Exception("ERROR:dao or sheet object is empty"), ExelException.class);
		}
		
		DataimportPart part = new DataimportPart();
		part.setCode(System.currentTimeMillis()+"");
		part.setName(sheet.getName());
		part.setCreate_by(Constants.VALUE_DEFAULT_CREATE_BY);
		part.setCreate_date(MyUtil.getCreateTime2());
		part.setImport_id(import_id);
		StringBuffer buf = new StringBuffer();
		buf.append("Sheet Name:"+sheet.getName()+";Rows:"+sheet.getRows()+";Columns:"+sheet.getColumns()+";");
		part.setRemark(buf.toString());
		part.setStatus(Constants.VALUE_DEFAULT_STATUS);
		part.setType(Constants.VALUE_DEFAULT_TYPE);
		part.setUpdate_by(Constants.VALUE_DEFAULT_CREATE_BY);
		part.setUpdate_time(MyUtil.getCreateTime2());
		DataimportPart part2 = dao.save(part);
		
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		if(rows ==0 || cols ==0){
			Lang.wrapThrow(new Exception("ERROR INFO:ROWS:0;MAX COLOMNS:0"), ExelException.class);
		}
		if(rows > MAX_ROWS | cols > MAX_COLS){
			Lang.wrapThrow(new Exception("ERROR INFO:MAX ROWS:5000;MAX COLOMNS:100"), ExelException.class);
		}
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				Cell cell = sheet.getCell(j, i);
				CellFormat cf = cell.getCellFormat();
				String cfs = (cf == null?"":cf.toString());
				CellType ct = cell.getType();
				String cts = (ct==null?"":ct.toString());
				String content = cell.getContents();
				//System.out.print("i:"+i+" j:"+j+" cf:"+cfs+" ct:"+cts+" content:"+content+"\t");
				//System.out.print(content+"\t\t");
				DataimportContent pojo = new DataimportContent();
				pojo.setContent(content);
				pojo.setCode(MyUtil.getCreateTime());
				pojo.setCreate_by(Constants.VALUE_DEFAULT_CREATE_BY);
				pojo.setCreate_date(MyUtil.getCreateTime2());
				pojo.setImport_part_id(part2.getId());
				pojo.setName("CELL CONTENT");
				buf.setLength(0);
				buf.append("content:"+content+";CellFormat:"+cfs+";CellType:"+cts);
				pojo.setRemark(buf.toString());
				pojo.setStatus(Constants.VALUE_DEFAULT_STATUS);
				pojo.setType(Constants.VALUE_DEFAULT_TYPE);
				pojo.setUpdate_by(Constants.VALUE_DEFAULT_CREATE_BY);
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				dao.save(pojo);
				
			}
			//System.out.println();
		}
		
	}

	/**
	 * @param args
	 * @throws ExelException 
	 */
	public static void main(String[] args) throws ExelException {
		String fp = "D:\\tem\\test\\work_log.xls";
		File file = new File(fp);
		ExcelUtil util = new ExcelUtil(file);
		util.readSheet(0);

	}

}
