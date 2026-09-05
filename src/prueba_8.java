import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class prueba_8 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar ventana
        driver.manage().window().maximize();

        // Abrir Urban Studio
        driver.get("http://localhost:4200/");

        // Espera inteligente
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar a que aparezcan los inputs
        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.tagName("input")
                )
        );

        // Buscar campos de login
        List<WebElement> inputs =
                driver.findElements(By.tagName("input"));

        // Credenciales de prueba
        inputs.get(0).sendKeys("amy yineth");
        inputs.get(1).sendKeys("Yei20066.");

        // Botón iniciar sesión
        WebElement botonLogin = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'Iniciar sesión')]")
                )
        );

        botonLogin.click();

        // Esperar hasta llegar al Home
        wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/home"
                )
        );

        System.out.println("Login exitoso. Estamos en Home.");

        // Esperar y buscar específicamente un enlace o botón visible
        WebElement botonServicios = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'servicios')] | " +
                                        "//button[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'servicios')]"
                        )
                )
        );

        // Clic en Servicios
        botonServicios.click();

        // Esperar redirección
        boolean navegacionCorrecta = wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/servicios"
                )
        );

        // Resultado
        if (navegacionCorrecta) {

            System.out.println(
                    "CP008 EXITOSO: Navegación correcta a Servicios."
            );

        }

        // Mantener navegador abierto
        Thread.sleep(5000);

        // driver.quit();
    }
}