import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class prueba_7 {

    public static void main(String[] args) throws InterruptedException {

        // ==============================
        // ABRIR GOOGLE CHROME
        // ==============================

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        // ==============================
        // ABRIR URBAN STUDIO
        // ==============================

        driver.get("http://localhost:4200/");


        // ==============================
        // CONFIGURAR ESPERA INTELIGENTE
        // ==============================

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));


        // ==============================
        // BUSCAR CAMPOS DEL LOGIN
        // ==============================

        Thread.sleep(2000);

        List<WebElement> inputs =
                driver.findElements(By.tagName("input"));


        // ==============================
        // INGRESAR CREDENCIALES
        // ==============================

        inputs.get(0).sendKeys("amy yineth");

        inputs.get(1).sendKeys("Yei20066.");


        // ==============================
        // BUSCAR BOTÓN INICIAR SESIÓN
        // ==============================

        WebElement botonLogin = driver.findElement(
                By.xpath("//*[contains(text(),'Iniciar sesión')]")
        );


        // ==============================
        // HACER CLIC EN INICIAR SESIÓN
        // ==============================

        botonLogin.click();


        // ==============================
        // ESPERAR A LLEGAR AL HOME
        // ==============================

        wait.until(
                d -> d.getCurrentUrl()
                        .equals("http://localhost:4200/home")
        );

        System.out.println(
                "Login exitoso. Estamos en Home."
        );


        // ==============================
        // BUSCAR BOTÓN BARBEROS
        // ==============================

        WebElement botonBarberos = wait.until(
                d -> d.findElement(
                        By.xpath(
                                "//*[contains(translate(text()," +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                                        "'abcdefghijklmnopqrstuvwxyz')," +
                                        "'barberos')]"
                        )
                )
        );


        // ==============================
        // CLIC EN BARBEROS
        // ==============================

        botonBarberos.click();


        // ==============================
        // ESPERAR REDIRECCIÓN A BARBEROS
        // ==============================

        boolean navegacionCorrecta = wait.until(
                d -> d.getCurrentUrl()
                        .equals("http://localhost:4200/barberos")
        );


        // ==============================
        // VERIFICAR RESULTADO
        // ==============================

        if (navegacionCorrecta) {

            System.out.println(
                    "CP007 EXITOSO: Navegación correcta a la página de Barberos."
            );

        } else {

            System.out.println(
                    "CP007 FALLIDO: No se pudo navegar a Barberos."
            );

        }


        // ==============================
        // MANTENER EL NAVEGADOR ABIERTO
        // ==============================

        Thread.sleep(5000);


        // ==============================
        // CERRAR NAVEGADOR
        // ==============================

        // driver.quit();

    }

}