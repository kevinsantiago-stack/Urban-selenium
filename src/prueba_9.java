import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class prueba_9 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Google Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar ventana
        driver.manage().window().maximize();

        // Abrir Urban Studio
        driver.get("http://localhost:4200/");

        // Configurar espera inteligente
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));


        // ==============================
        // INICIAR SESIÓN
        // ==============================

        // Esperar los campos de login
        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.tagName("input")
                )
        );

        // Buscar los campos
        List<WebElement> inputs =
                driver.findElements(By.tagName("input"));

        // Ingresar credenciales de prueba
        inputs.get(0).sendKeys("amy yineth");
        inputs.get(1).sendKeys("Yei20066.");

        // Buscar botón Iniciar sesión
        WebElement botonLogin = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'Iniciar sesión')]")
                )
        );

        // Iniciar sesión
        botonLogin.click();


        // ==============================
        // ESPERAR HOME
        // ==============================

        wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/home"
                )
        );

        System.out.println("Login exitoso. Estamos en Home.");


        // ==============================
        // NAVEGAR A CITAS
        // ==============================

        WebElement botonCitas = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'citas')] | " +
                                        "//button[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'citas')]"
                        )
                )
        );

        // Clic en CITAS
        botonCitas.click();


        // ==============================
        // VERIFICAR REDIRECCIÓN
        // ==============================

        boolean navegacionCorrecta = wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/citas"
                )
        );

        if (navegacionCorrecta) {

            System.out.println(
                    "CP009 EXITOSO: Navegación correcta a la página de Citas."
            );

        }


        // Mantener navegador abierto
        Thread.sleep(5000);

        // driver.quit();
    }
}