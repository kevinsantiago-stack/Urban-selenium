import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class prueba_10 {

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

        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.tagName("input")
                )
        );

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
        // NAVEGAR A IA ESTILO
        // ==============================

        WebElement botonIA = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'ia estilo')] | " +
                                        "//button[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'ia estilo')]"
                        )
                )
        );

        // Clic en IA Estilo
        botonIA.click();


        // ==============================
        // VERIFICAR REDIRECCIÓN
        // ==============================

        boolean navegacionCorrecta = wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/gemini"
                )
        );

        if (navegacionCorrecta) {

            System.out.println(
                    "CP010 EXITOSO: Navegación correcta a IA Estilo."
            );
        }


        // Mantener navegador abierto
        Thread.sleep(5000);

        // driver.quit();
    }
}