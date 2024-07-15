//package generalstore.utils;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//
//import java.io.File;
//import java.time.Duration;
//
//import static generalstore.utils.ConfigReader.getProperty;
//
//public class Driver {
//    public static AndroidDriver driver;
//    public static AppiumDriverLocalService service;
//
//    public static AndroidDriver getDriver() {
//        if (driver == null) {
//            String appUrl = System.getProperty(("user.dir"))
//                    + File.separator + "src"
//                    + File.separator + "test"
//                    + File.separator + "resources"
//                    + File.separator + "apps"
//                    + File.separator + getProperty("apkName");
//
//            UiAutomator2Options options = new UiAutomator2Options()
//                    .setUiautomator2ServerInstallTimeout(Duration.ofSeconds(30))
//                    .setApp(appUrl);
////                    .setDeviceName("emulator-5554")
////                    .setPlatformName("Android");
//
////            URL url = null;
////            try {
////                url = new URL("http://0.0.0.0:4723");
////            } catch (MalformedURLException e) {
////                throw new RuntimeException(e);
////            }
//
////            driver = new AndroidDriver(url, options);
//            driver = new AndroidDriver(service.getUrl(), options);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        }
//        return driver;
//    }
//
//    public static void serverBaslat(String ipAdres, int port) {
//        service = new AppiumServiceBuilder()
//                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
//                .withIPAddress(ipAdres)
//                .usingPort(port)
//                .build();
//        service.start();
//
//    }
//
//    public static void uygulamayiKapat() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//
//    public static void serverKapat() {
//        service.stop();
//    }
//
//
//}





package generalstore.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.time.Duration;

import static generalstore.utils.ConfigReader.getProperty;

public class Driver {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            String appUrl = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "test"
                    + File.separator + "resources"
                    + File.separator + "apps"
                    + File.separator + getProperty("apkName");

            UiAutomator2Options options = new UiAutomator2Options()
                    .setUiautomator2ServerInstallTimeout(Duration.ofSeconds(40))
                    .setApp(appUrl);

            driver = new AndroidDriver(service.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void serverBaslat(String ipAdres, int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                // Burada server'i otomatik baslatabilmemiz icin terminalde where appium yazarak calistirmamiz lazim.
                // Sonrasinda terminalin bize verdigi yolu /opt/homebrew/bin/appium  homebrew'dan sonrasini silip bilgisayarimizda aratmamiz lazim.
                // Bu kismi mac'te bulabilmek icin finder'a tiklayip ekranda yukarida acilan go secenegine tiklayip
                // go to folder'a basip arama bolumune yapistirip aratirsak appium'un oldugu kisma geliriz.
                // Burada sirasiyla bin/lib/node_modules/appium/lib klasorlerinin icerisine girip main.js dosyasini bulup
                // yolunu alabilmek icin yeni terminal acip onun icerisine yapistirip terminalin bize verdigi yolu
                // Burada yukaridaki path degisken kismina eklemeliyiz. Bu yol windows ve macos ta degisik olacagindan burayi projelerde
                // dinamik bir sekilde kullanacak sekilde yapmak gerekiyor.
                .withIPAddress(ipAdres)
                .usingPort(port)
                .build();
        service.start();
    }

    public static void uygulamayiKapat() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void serverKapat(){
        service.stop();
    }


}



