import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class prueba_6 {

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

        // Buscar campos de usuario y contraseña
        List<WebElement> inputs =
                driver.findElements(By.tagName("input"));

        // Ingresar credenciales correctas de prueba
        inputs.get(0).sendKeys("amy yineth");
        inputs.get(1).sendKeys("Yei20066.");

        // Buscar botón Iniciar sesión
        WebElement botonLogin = driver.findElement(
                By.xpath("//*[contains(text(),'Iniciar sesión')]")
        );

        // Hacer clic
        botonLogin.click();

        // Esperar hasta que la URL sea /home
        boolean redireccionCorrecta = wait.until(
                d -> d.getCurrentUrl()
                        .equals("http://localhost:4200/home")
        );

        // Verificar resultado
        if (redireccionCorrecta) {

            System.out.println(
                    "CP006 EXITOSO: El usuario fue redirigido correctamente al Home."
            );

        } else {

            System.out.println(
                    "CP006 FALLIDO: No se realizó la redirección esperada."
            );
        }

        // Mantener navegador abierto para visualizar el Home
        Thread.sleep(5000);

        // driver.quit();
    }
}