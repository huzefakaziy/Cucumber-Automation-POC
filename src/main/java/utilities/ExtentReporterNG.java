package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {				

		public static ExtentReports getExtentReportObj() {
			String path = System.getProperty("user.dir") + "\\ExtentReports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Test Results");
			reporter.config().setDocumentTitle("R2 POC");

			ExtentReports extentReport = new ExtentReports();
			extentReport.attachReporter(reporter);
			extentReport.setSystemInfo("Tester", "Huzefa Kazi");

			return extentReport;
		}

	}

