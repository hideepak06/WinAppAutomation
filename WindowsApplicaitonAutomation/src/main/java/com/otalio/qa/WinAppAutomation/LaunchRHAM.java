package com.otalio.qa.WinAppAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class LaunchRHAM {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		HashMap<String, String> Map=GetRHAMDetails();
		for (Entry<String, String> set : Map.entrySet()) {
		    System.out.println(set.getKey() + " = " + set.getValue());
		}
		
	}
//This method is used to get the details of RHAM GUI .
	public static HashMap<String, String> GetRHAMDetails() throws InterruptedException, MalformedURLException
	{
		// TODO Auto-generated method stub
				String connectionId;
				String RfidUidVal;
				String Track2Val;
				String barcodeVal;
				String Mrz1Val;
				String Mrz2Val;
				DesktopOptions option = new DesktopOptions();
				
				option.setApplicationPath("C:\\Program Files (x86)\\Otalio GmbH\\Remote Hardward Access Module\\Remote Hardware Access Module.exe");

				Thread.sleep(5000);
				
				WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);

				Thread.sleep(5000);


				driver.findElement(By.id("RestarWebSocket")).click();
				//driver.findElement(By.name("Restart Web Socket Client")).click();
				
				Thread.sleep(5000);
				//driver.close();
				
				connectionId=driver.findElement(By.id("txtConnectionId")).getText().toString();
				RfidUidVal=driver.findElement(By.id("txtRfidUid")).getText().toString();
				Track2Val=driver.findElement(By.id("txtTrack2")).getText().toString();
				barcodeVal=driver.findElement(By.id("barcode")).getText().toString();
				Mrz1Val=driver.findElement(By.id("txtMrz1")).getText().toString();
				Mrz2Val=driver.findElement(By.id("txtMrz2")).getText().toString();
				//System.out.println("Connectionid is "+ connectionId +""+ "RfidUidVal is" +RfidUidVal);
				//List<String,String> al = new ArrayList<>(); 
				HashMap<String,String> hm=new HashMap<String,String>();
				hm.put("ConnectionId Value :" , connectionId);
				hm.put("RfidUid Value :" , RfidUidVal);
				hm.put("Track2 Value :" , Track2Val);
				hm.put("barcode Value :" , barcodeVal);
				hm.put("Mrz1 Value :" , Mrz1Val);
				hm.put("Mrz2 Value :" , Mrz2Val);
				//driver.findElement(By.id("barcodeScan")).click();;
				Thread.sleep(15000);
				
				
				driver.quit();
				// TODO Auto-generated method stub

				
				return hm;
	}
}
