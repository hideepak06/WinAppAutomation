package com.otalio.qa.WinAppAutomation;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class startWinium {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Process process;
		
		String connectionId;
		
		WiniumDriverService service = null;
		try {
			process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
			process.waitFor();
			//if(process.isAlive()) {
			process.destroy();
			//}
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebDriver driver = null;

		String RHAMApplicationPath = "C:\\Program Files (x86)\\Otalio GmbH\\Remote Hardward Access Module\\Remote Hardware Access Module.exe";

		// Initiate Winium Desktop Options
		DesktopOptions options = new DesktopOptions();
		// Set notepad application path
		options.setApplicationPath(RHAMApplicationPath);

		
		File driverPath = new File("C:\\Users\\Abj1240\\Downloads\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe");
		System.setProperty("webdriver.winium.desktop.driver","C:\\Users\\Abj1240\\Downloads\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		try {
		service.start();
		//if(RA.isSuperUser())
		
		driver = new WiniumDriver(service,options);
		} catch (IOException e) {
		System.out.println("Exception while starting WINIUM server");
		e.printStackTrace();
		}

		Thread.sleep(5000);
		System.out.println("Started....................");

 //      driver.findElement(By.id("RestarWebSocket")).click();
//		
//		
//		Thread.sleep(5000);
//		//driver.close();
//		connectionId=driver.findElement(By.name("txtConnectionId")).getText().toString();
//		
//		System.out.println("Connectionid is "+ connectionId);

		//service.stop();

//		try {
//			process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
//			process.waitFor();
//			process.destroy();
//		} catch (IOException  e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Terminated....................");
	}

}
