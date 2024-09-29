import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Memanggil Test Cases Login
WebUI.callTestCase(findTestCase('Login/Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

// Mengambil string nama produk di katalog, untuk cek identitas di katalog dan detail sama
String productNameCatalog = WebUI.getText(findTestObject('Object Repository/Page_STORE/a_Samsung galaxy s6'))

// Klik produk
WebUI.click(findTestObject('Object Repository/Page_STORE/a_Samsung galaxy s6'))

// Mengambil string nama produk di detail, untuk cek identitas di katalog dan detail sama
String productNameDetail = WebUI.getText(findTestObject('Object Repository/Page_STORE/h2_Samsung galaxy s6'))
if (productNameCatalog.equals(productNameDetail)) {
	println("Nama Produk di Katalog dan Detail Sama.")
} else {
	println("Nama Produk di Katalog dan Detail Tidak Sama.")
}

// Menambahkan jeda 3 detik
WebUI.delay(1)

// Klik button Add to Cart untuk menambah produk ke keranjang
WebUI.click(findTestObject('Object Repository/Page_STORE/a_Add to cart'))

// Tunggu hingga alert muncul kemuidan mencetak pesan alert
if (WebUI.waitForAlert(3)) {
	String alertText = WebUI.getAlertText()
	println("Alert Text: " + alertText)
	WebUI.acceptAlert()
}

// Klik menu Cart pada navigation bar
WebUI.click(findTestObject('Object Repository/Page_STORE/a_Cart'))

// Verifikasi produk yang ditambahkan ada di keranjang
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_STORE/td_Samsung galaxy s6'), 60)