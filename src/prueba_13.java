import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class prueba_13 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar ventana
        driver.manage().window().maximize();

        // Configurar espera inteligente
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Intentar acceder directamente a Barberos sin iniciar sesión
        driver.get("http://localhost:4200/barberos");

        System.out.println(
                "Intentando acceder a /barberos sin iniciar sesión..."
        );

        // Esperar la redirección al Login
        boolean redireccionCorrecta = wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/login"
                )
        );

        // Verificar resultado
        if (redireccionCorrecta) {

            System.out.println(
                    "CP013 EXITOSO: El acceso a Barberos fue bloqueado correctamente."
            );

            System.out.println(
                    "El usuario fue redirigido al Login."
            );
        }

        // Mantener navegador abierto
        Thread.sleep(5000);

        // driver.quit();
    }
}