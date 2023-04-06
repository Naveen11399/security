package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import PageObjects.AdminLoginOBJ;
import Utils.ReadConfig;

public class BaseClass {
	ReadConfig rc = new ReadConfig();
	String adminURL = rc.getAdminUrl();
	String adminUname = rc.getAdminUname();
	String adminPword = rc.getAdminPword();
	String ZAP_PROXY_ADDRESS = "localhost";
	int ZAP_PROXY_PORT = 8080;
	String ZAP_PROXY_KEY = "keqs5dgvi8jbnlgci0sstt9s0s";
	private ClientApi api;
	RemoteWebDriver driver;
	public AdminLoginOBJ al;

	@BeforeMethod
	public void setup() {
		String ProxyServerUrl = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(ProxyServerUrl);
		proxy.setSslProxy(ProxyServerUrl);

		EdgeOptions eo = new EdgeOptions();
		eo.setAcceptInsecureCerts(true);
		eo.setProxy(proxy);

		driver = new EdgeDriver(eo);
		api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_PROXY_KEY);
		driver.get(adminURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void teardown() {
		if (api != null) {
			String title = "Spurt Admin Security Test";
			String template = "traditional-html";
			String describtion = "spurt admin  security test";
			String reportname = "spurtAdmin-zap-report.html";
			String tagerfolder = System.getProperty("user.dir");
			try {
				ApiResponse response = api.reports.generate(title, template, null, describtion, null, null, null, null,
						null, reportname, null, tagerfolder, null);
				System.out.println("zap report generated" + response.toString());

			} catch (ClientApiException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
