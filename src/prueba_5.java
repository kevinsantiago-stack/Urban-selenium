import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class prueba_5 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Chrome UNA SOLA VEZ
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://localhost:4200/");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Buscar los campos
        List<WebElement> inputs =
                driver.findElements(By.tagName("input"));

        // Credenciales de prueba
        inputs.get(0).sendKeys("amy yineth");
        inputs.get(1).sendKeys("Yei20066.");

        // Buscar botón
        WebElement botonLogin = driver.findElement(
                By.xpath("//*[contains(text(),'Iniciar sesión')]")
        );

        // Iniciar sesión
        botonLogin.click();

        // Esperar a detectar el mensaje
        boolean accesoCorrecto = wait.until(
                d -> d.getPageSource().contains("Acceso correcto")
        );

        if (accesoCorrecto) {
            System.out.println(
                    "CP005 EXITOSO: Acceso correcto detectado."
            );
        }

        // Mantener Chrome abierto unos segundos
        Thread.sleep(5000);

        // driver.quit();
    }
}