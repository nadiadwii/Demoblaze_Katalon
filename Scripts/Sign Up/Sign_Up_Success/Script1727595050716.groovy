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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

WebUI.openBrowser('')

// Membuka website
WebUI.navigateToUrl('https://www.demoblaze.com/index.html')

// Klik button Sign up pada navigation bar
WebUI.click(findTestObject('Object Repository/Page_STORE/a_Sign up'))

// Menginputkan Username. Catatan: digunakan string acak agar dapat dijalankan berkali-kali.
WebUI.setText(findTestObject('Object Repository/Page_STORE/input_Username_sign-username'), RandomStringUtils.randomAlphanumeric(9))

// Menginputkan Password. Catatan : mmenggunakan password yang sama yaitu "testing1"
WebUI.setEncryptedText(findTestObject('Object Repository/Page_STORE/input_Password_sign-password'), 'fzqqY0qJjYRVrxTAfQ5f7A==')

// Menambahkan jeda 2 detik
WebUI.delay(2)

// Klik button Sign up, ini akan memicu alert
WebUI.click(findTestObject('Object Repository/Page_STORE/button_Sign up'))

// Tunggu hingga alert muncul kemuidan mencetak pesan alert
if (WebUI.waitForAlert(3)) {
	String alertText = WebUI.getAlertText()
	println("Alert Text: " + alertText)
	WebUI.acceptAlert()
}


