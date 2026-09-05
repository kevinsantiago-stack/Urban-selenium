import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class prueba_2 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Google Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar la ventana
        driver.manage().window().maximize();

        // Abrir Urban Studio
        driver.get("http://localhost:4200/");

        // Esperar que cargue la página
        Thread.sleep(3000);

        // Buscar los campos input
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        System.out.println("Cantidad de inputs encontrados: " + inputs.size());

        // Ingresar usuario
        inputs.get(0).sendKeys("amy yineth");

        // Ingresar contraseña
        inputs.get(1).sendKeys("Yei20066.");

        // Esperar un momento
        Thread.sleep(1000);

        // Buscar el botón "Iniciar sesión"
        WebElement botonLogin = driver.findElement(
                By.xpath("//*[contains(text(),'Iniciar sesión')]")
        );

        // Hacer clic
        botonLogin.click();

        // Esperar la respuesta del sistema
        Thread.sleep(5000);

        System.out.println("Prueba CP001 ejecutada correctamente.");

        // Cerrar navegador al finalizar
        // driver.quit();
    }
}
