import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class prueba_12 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar ventana
        driver.manage().window().maximize();

        // Configurar espera
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));


        // Intentar acceder directamente al Home
        driver.get("http://localhost:4200/home");

        System.out.println(
                "Intentando acceder directamente a /home sin iniciar sesión..."
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
                    "CP012 EXITOSO: El acceso al Home fue bloqueado correctamente."
            );

            System.out.println(
                    "El usuario fue redirigido al Login."
            );

        } else {

            System.out.println(
                    "CP012 FALLIDO: El usuario pudo acceder al Home sin autenticación."
            );
        }


        // Mantener navegador abierto
        Thread.sleep(5000);

        // driver.quit();
    }
}
