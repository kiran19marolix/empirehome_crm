package com.reports;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReporterNG implements IReporter {
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports();

        // Specify the HTML reporter and attach it to the extent report
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(outputDirectory + File.separator + "ExtentReport.html");
        extent.attachReporter(htmlReporter);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> results = suite.getResults();
            for (ISuiteResult result : results.values()) {
                ITestContext context = result.getTestContext();

                buildTestNodes(context.getPassedTests().getAllResults(), Status.PASS);
                buildTestNodes(context.getFailedTests().getAllResults(), Status.FAIL);
                buildTestNodes(context.getSkippedTests().getAllResults(), Status.SKIP);
            }
        }

        extent.flush();
    }

    private void buildTestNodes(Set<ITestResult> testResults, Status status) {
        ExtentTest test;

        for (ITestResult result : testResults) {
            test = extent.createTest(result.getMethod().getMethodName());

            for (String group : result.getMethod().getGroups()) {
                test.assignCategory(group);
            }

            if (result.getThrowable() != null) {
                test.log(status, result.getThrowable());
            } else {
                test.log(status, "Test " + status.toString().toLowerCase() + "ed");
            }
        }
    }
}
