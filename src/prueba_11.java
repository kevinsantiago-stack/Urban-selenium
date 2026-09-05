import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class prueba_11 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Chrome
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Espera inteligente
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Abrir LOGIN directamente
        driver.get("http://localhost:4200/login");

        System.out.println("Paso 1: Estamos en Login");

        Thread.sleep(2000);


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

        System.out.println("Paso 2: Credenciales ingresadas");

        Thread.sleep(2000);


        // Botón iniciar sesión
        WebElement botonLogin = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'Iniciar sesión')]")
                )
        );

        botonLogin.click();

        System.out.println("Paso 3: Clic en Iniciar sesión");

        // Esperar Home
        wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/home"
                )
        );

        System.out.println("Paso 4: Login exitoso, estamos en Home");

        // Pausa para VER EL HOME
        Thread.sleep(4000);


        // ==============================
        // CERRAR SESIÓN
        // ==============================

        WebElement botonCerrarSesion = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'cerrar sesión')] | " +
                                        "//button[contains(translate(normalize-space(.), " +
                                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                                        "'abcdefghijklmnopqrstuvwxyz'), " +
                                        "'cerrar sesión')]"
                        )
                )
        );

        System.out.println("Paso 5: Botón Cerrar Sesión encontrado");

        Thread.sleep(2000);

        // Clic
        botonCerrarSesion.click();

        System.out.println("Paso 6: Clic en Cerrar Sesión");


        // ==============================
        // VERIFICAR LOGIN
        // ==============================

        wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost:4200/login"
                )
        );

        System.out.println(
                "CP011 EXITOSO: Sesión cerrada correctamente y redirigido al Login."
        );


        // Pausa para ver el Login
        Thread.sleep(5000);

        // driver.quit();
    }
}