package com.iCM.util;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;












import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.iCM.pagehelper.EChartHelper;
import com.iCM.pagehelper.EMRHelper;
import com.iCM.pagehelper.LoginHelper;
import com.iCM.pagehelper.PRNHelper;
import com.iCM.pagehelper.ResidentHelper;
import com.iCM.pagehelper.TaskHelper;


public abstract class DriverTestCase 
{

	enum DriverType 
	{ Firefox, IE, Chrome }

	//Define objects
	private WebDriver driver;
	protected LoginHelper loginHelper;
	protected ResidentHelper residentHelper;
	protected EChartHelper echartHelper;
	protected EMRHelper eMRHelper;
	protected TaskHelper taskHelper;
	protected PRNHelper prnHelper;
    

	//Initialize objects
	protected PropertyReader propertyReader = new PropertyReader();

	//Define variables
	protected String application_url = propertyReader.readApplicationFile("URL");
	protected String pswd = propertyReader.readApplicationFile("pswd");
	protected String username = propertyReader.readApplicationFile("username");
	protected String baseUrl = propertyReader.readApplicationFile("base_url");
	

	@BeforeSuite
	public void setUp() 
	{  
		String driverType = propertyReader.readApplicationFile("BROWSER");  

		if (DriverType.Firefox.toString().equals(driverType)) 
		{ 
			driver = new FirefoxDriver();   
		}   

		else if (DriverType.IE.toString().equals(driverType)) 
		{ 
			String path1 = getPath();
			File file = new File(path1+"//IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);   
			driver = new InternetExplorerDriver(capabilities); 
			//driver = new InternetExplorerDriver();
		}
		else if (DriverType.Chrome.toString().equals(driverType)) 
		{ 
			String path1 = getPath();
			String chromeDriverPath= path1+"\\chromedriver.exe";

			//Set the required properties to instantiate Chrome driver. Place any latest Chromedriver.exe files under Drivers folder
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options); } 
		else 
		{ driver = new FirefoxDriver(); }   

		//Maximize window
		driver.manage().window().maximize();

		//Delete cookies
		driver.manage().deleteAllCookies();   
		
	} 

	@AfterSuite
	public void afterMainMethod() 
	{  
		driver.quit();
	}

	
	
	
	

	public WebDriver getWebDriver()
	{
		return driver;
	}


	//Open application URL
	public void openUrl(String url){
		getWebDriver().navigate().to(url);
	}
	
	//Visit URL
	public void visit(String url)
	{
		String final_url=baseUrl+url;
		getWebDriver().navigate().to(final_url);
	}
	
	//Handle child windows
	public String switchPreviewWindow()
	{
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();		
		String parent = iter.next();
		getWebDriver().switchTo().window(iter.next());
		return parent;
	}

	//Get random integer
	public int getRandomInteger(int aStart, int aEnd){
		Random aRandom = new  Random();
		if ( aStart > aEnd ) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		//get the range, casting to long to avoid overflow problems
		long range = (long)aEnd - (long)aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long)(range * aRandom.nextDouble());
		int randomNumber =  (int)(fraction + aStart);    
		return randomNumber;
	}

	//Get random string
	public String randomString( int len ) 
	{
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

	//Get absolute path
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");		
		return path;
	}

	//Get absolute path
	public String getPathUpload()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");		
		return path;
	}


	//Switch frame
	public void switchFrame(String[] arr){
		for (int i = 0; i < arr.length; i++)
		{			
			getWebDriver().switchTo().frame(arr[i]);
		}
	}


	//capturing screenshot 
	public void captureScreenshot(String fileName) {
		try {
			String screenshotName = this.getFileName(fileName);
			FileOutputStream out = new FileOutputStream("screenshots//" + screenshotName + ".jpg");
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			String path = getPath();
			String  screen = "file://"+path+"/screenshots/"+screenshotName + ".jpg";
			Reporter.log("<a href= '"+screen+  "'target='_blank' >" + screenshotName + "</a>");
		} catch (Exception e) {

		}
	}

	//Creating file name
	public  String getFileName(String file){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();		 
		String fileName = file+dateFormat.format(cal.getTime());
		return fileName;
	}
	
	
	//Login into application PROD
	public void LoginLive()
	{
		loginHelper = new LoginHelper(getWebDriver());
		
		//Verify page title
		ExecutionLog.Log("Verify Page title");
		loginHelper.verifyTitle("iCM - Login");
		ExecutionLog.Log("Pass");
		
		//Enter User name
		ExecutionLog.Log("Enter User name at login page.");
		loginHelper.enterUserID(username);
		ExecutionLog.Log("Pass");
		
		//Enter password
		ExecutionLog.Log("Enter password at login page.");
		loginHelper.enterPassword(pswd);
		ExecutionLog.Log("Pass");
		
		//Click on Sign In
		ExecutionLog.Log("Click on Sign In button");
		loginHelper.clickLogin();
		ExecutionLog.Log("Pass");
		
		//Verify User redirect at home page
		ExecutionLog.Log("Verify home page title");
		loginHelper.verifyTitle("iCM - Home");
		ExecutionLog.Log("Pass");
	}
	
	//Send Email through email
	public void SendGmail()
	{
		  final String username = "qa.aman.khan@gmail.com";
		    final String password = "eivor@eivor";
		   
		    PropertyReader property = new PropertyReader();
		    String path = property.getFilePath();
		    ExecutionLog executionLog = new ExecutionLog();
		    String Name = executionLog.getFileName();
		    Properties props = new Properties();
		    props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");

		    Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });

		    try {

		        Message message = new MimeMessage(session);
		        
		        message.setFrom(new InternetAddress("jaeyun@gmail.com"));

		        message.setFrom(new InternetAddress("jaeyun@gmail.com"));
		        message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse("jaeyun@gmail.com"));
		        message.setSubject("Testing Subject");
		        message.setText("PFA");

		        MimeBodyPart messageBodyPart = new MimeBodyPart();

		        Multipart multipart = new MimeMultipart();

		        messageBodyPart = new MimeBodyPart();
		        String file = path + "//ExecutionLog//" + Name + ".txt";
		        String fileName = "attachmentName";
		        DataSource source = new FileDataSource(file);
		        messageBodyPart.setDataHandler(new DataHandler(source));
		        messageBodyPart.setFileName(fileName);
		        multipart.addBodyPart(messageBodyPart);

		        message.setContent(multipart);

		        System.out.println("Sending");

		        Transport.send(message);

		        System.out.println("Done");

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
	}
	
	
	}

	

