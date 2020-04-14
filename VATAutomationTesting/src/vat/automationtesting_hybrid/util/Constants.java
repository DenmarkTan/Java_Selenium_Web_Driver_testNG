package vat.automationtesting_hybrid.util;

public class Constants {
		//System Variables
		//public static final String Path_TestData = System.getProperty("user.home") + "/Desktop/TestFile/";
				//"C:/Users/VAT036/Desktop/VATAutomationTesting/src/vat/automationtesting_hybrid/files/TestFile.xlsx";
		public static final String Path_OR = System.getProperty("user.home") + "/Desktop/TestFile/OR.txt";
				//"C:/Users/VAT036/Desktop/VATAutomationTesting/src/vat/automationtesting_hybrid/util/OR.txt";
		//public static final String File_TestData = "TestFile";
		public static final String File_XLSX = ".xlsx";
		//public static final String Path_Screenshot = System.getProperty("user.home") + "/Desktop/TestFile/Result/Screenshot/";
		//public static final String Path_Result = System.getProperty("user.home") + "/Desktop/TestFile/Result/";
				//"C:/Users/VAT036/Desktop/VATAutomationTesting/Screenshot/";
		public static final String KEYWORD_FAILED = "FAILED";
		public static final String KEYWORD_PASSED = "PASSED";
		public static final String KEYWORD_OK = "OK";
		public static final String KEYWORD_CANCEL = "CANCEL";
		public static final String Path_Firefox = System.getProperty("user.dir") + "/other files/geckodriver.exe";
		public static final String Path_ChromeDriver = System.getProperty("user.dir") + "/other files/chromedriver.exe";
		public static final String Path_IEDriver = System.getProperty("user.dir") + "/other files/IEDriverServer.exe";
		public static final String Path_log4jconfig = System.getProperty("user.dir") + "/log4j.properties";

		//Data Sheet Column Numbers
		public static final int Col_TestScriptID = 0;	
		public static final int Col_TestStepsID =1 ;
		public static final int Col_RunMode =5 ;
		public static final int Col_Result =6 ;

		public static final int Col_PageObject =4 ;
		public static final int Col_PageObjectType =5 ;
		public static final int Col_ActionKeyword =6 ;
		public static final int Col_DataSet =7 ;
		public static final int Col_TestStepResult =8 ;
		public static final int Col_TSResultRemarks =9 ;	
		
		//Result metrics column numbers
		public static final int Col_TCPlanned = 2;
		public static final int Col_TCExecuted = 3;
		public static final int Col_TCNotexe = 4;
		public static final int Col_TCPassed = 5;
		public static final int Col_TCFailed = 6;
		
		//result metrics title column
		public static final String[] resultTitle = new String[] {"Test Cases Planned",
																 "Test Cases Executed",
																 "Test Cases Not Executed",
																 "Test Cases Passed",
																 "Test Cases Failed"};
		
		//Result metrics row numbers;
		public static final int Row_ResultTitle = 2;
		public static final int Row_ResultTotal = 3;

		// Data Engine Excel sheets
		public static final String Sheet_TestSteps = "Test Steps";
		public static final String Sheet_TestScript = "Test Script";
		public static final String Sheet_ResultRatio = "Result";

		//Others
		public static final String Screenshot_JPEG = ".jpeg";
		public static final long waitTime = 30;
		public static final long explicitWaitTime = 60;
		public static final long pagewaitTime = 60;
		public static final int pollingTime = 5;

}
