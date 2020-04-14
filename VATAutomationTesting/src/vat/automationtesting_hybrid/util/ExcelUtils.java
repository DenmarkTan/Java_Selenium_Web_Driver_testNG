package vat.automationtesting_hybrid.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import static vat.automationtesting_hybrid.ExecutionScript.OR;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import vat.automationtesting_hybrid.ExecutionScript;
public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
   // private static org.apache.poi.ss.usermodel.Cell Cell;
    private static XSSFRow Row;
    private static XSSFCellStyle Style;
    private static Cell Cell;

public static void setExcelFile(String Path) throws Exception {
	try {
        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
	} catch (Exception e){
		Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
		ExecutionScript.bResult = false;
    }
}

public static String renameExcelFile() throws Exception {
	try {
		
		String newfileName = OR.getProperty("Path_Result") +
						 "[RESULT]" +
						 OR.getProperty("filename_testdata") +
						// Constants.File_TestData +
						 "_" +
						 Datetime.dateTime() +
						 Constants.File_XLSX;
		File oldName = new File(OR.getProperty("Path_Result") +
				OR.getProperty("filename_testdata") +
				//Constants.Path_Result +
				  // Constants.File_TestData +
				   Constants.File_XLSX);
	
		File newName = new File(newfileName);
		if(oldName.renameTo(newName)){
			//successfully renamed
		}
		return newfileName;
	}catch (Exception e){
		Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
		ExecutionScript.bResult = false;
		return null;
	}
}

public static void createresultSheet(String sheetName,
									 int[] iResult)throws Exception {
	try {
		Style = ExcelWBook.createCellStyle();
        ExcelWSheet = ExcelWBook.createSheet(sheetName);
		Row = ExcelWSheet.createRow(2);
		for(int j = 0; j < 5; j++){
			Cell = Row.createCell(j);
			Cell.setCellValue(Constants.resultTitle[j]);
			Style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		 	Style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		 	Style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		 	Style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		 	Style.setFillPattern(CellStyle.LEAST_DOTS);
		 	Style.setFillBackgroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		 	Cell.setCellStyle(Style);
		}
		Style = ExcelWBook.createCellStyle();
		Row = ExcelWSheet.createRow(3);
		for(int k = 0; k < 5; k++){
			Cell = Row.createCell(k);
			Cell.setCellValue(iResult[k]);
			Style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		 	Style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		 	Style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		 	Style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		 	Style.setFillPattern(CellStyle.NO_FILL);
		 	Cell.setCellStyle(Style);
		}

        FileOutputStream fileOut = new FileOutputStream(OR.getProperty("Path_Result") +
        		OR.getProperty("filename_testdata") +
        		//Constants.Path_Result +
				  // Constants.File_TestData +
				   Constants.File_XLSX);

        ExcelWBook.write(fileOut);
        fileOut.close();
	} catch (Exception e){
		Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
		ExecutionScript.bResult = false;
    }
}

public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
    try{
    	ExcelWSheet = ExcelWBook.getSheet(SheetName);
       	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        String CellData = Cell.getStringCellValue();
        return CellData;
     }catch (Exception e){
    	 if(e.getMessage() != null){
    		 Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
    	 }
         ExecutionScript.bResult = false;
         return"";
         }
     }

public static int getRowCount(String SheetName){
	int iNumber=0;
	try {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		iNumber=ExcelWSheet.getLastRowNum()+1;
	} catch (Exception e){
		Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
		ExecutionScript.bResult = false;
		}
	return iNumber;
	}

public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
	int iRowNum=0;	
	try {
	    ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int rowCount = ExcelUtils.getRowCount(SheetName);
		for (; iRowNum<rowCount; iRowNum++){
			if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
				break;
			}
		}       			
	} catch (Exception e){
		Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
		ExecutionScript.bResult = false;
		}
	return iRowNum;
	}

public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
	try {
		for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
			if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestScriptID, SheetName))){
				int number = i;
				return number;      				
				}
			}
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number=ExcelWSheet.getLastRowNum()+1;
		return number;
	} catch (Exception e){
		Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
		ExecutionScript.bResult = false;
		return 0;
    }
}

@SuppressWarnings("static-access")
public static void setCellData(String cellValue,  int RowNum, int ColNum, String SheetName) throws Exception    {
       try{
    	   Style = ExcelWBook.createCellStyle();
    	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
           Row  = ExcelWSheet.getRow(RowNum);
           Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
           if (Cell == null) {
        	   Cell = Row.createCell(ColNum);
        	   Cell.setCellValue(cellValue);
            } else {
                Cell.setCellValue(cellValue);
            }
          
           if (cellValue.equalsIgnoreCase(Constants.KEYWORD_PASSED)){
        	   Style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
           } else if (cellValue.equalsIgnoreCase(Constants.KEYWORD_FAILED)){
        	   Style.setFillBackgroundColor(IndexedColors.RED.getIndex());
           } else {
        	   Style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
           }
       	   Style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
    	   Style.setBorderTop(XSSFCellStyle.BORDER_THIN);
    	   Style.setBorderRight(XSSFCellStyle.BORDER_THIN);
    	   Style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
    	   Style.setFillPattern(CellStyle.LEAST_DOTS);
    	   Cell.setCellStyle(Style);
             FileOutputStream fileOut = new FileOutputStream(OR.getProperty("Path_Result") +
             		OR.getProperty("filename_testdata") +
            		 //Constants.Path_Result +
					   //Constants.File_TestData +
					   Constants.File_XLSX);
             ExcelWBook.write(fileOut);
             //fileOut.flush();
             fileOut.close();
             ExcelWBook = new XSSFWorkbook(new FileInputStream(
            		 OR.getProperty("Path_Result") +
             		OR.getProperty("filename_testdata") +
            		 //Constants.Path_Result +
					   //Constants.File_TestData +
					   Constants.File_XLSX));
         }catch(Exception e){
        	 ExecutionScript.bResult = false;
  
         }
    }
}
