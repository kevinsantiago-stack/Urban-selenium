import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class prueba_4{

    public static void main(String[] args) throws InterruptedException {

        // Abrir Google Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar ventana
        driver.manage().window().maximize();

        // Abrir Urban Studio
        driver.get("http://localhost:4200/");

        // Esperar que cargue la página
        Thread.sleep(3000);

        // Buscar los campos input
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        // Ingresar usuario incorrecto
        inputs.get(0).sendKeys("usuario_incorrecto");

        // Ingresar contraseña incorrecta
        inputs.get(1).sendKeys("password_incorrecta");

        // Buscar botón Iniciar sesión
        WebElement botonLogin = driver.findElement(
                By.xpath("//*[contains(text(),'Iniciar sesión')]")
        );

        // Hacer clic
        botonLogin.click();

        // Esperar respuesta del sistema
        Thread.sleep(3000);

        // Mensaje esperado
        String mensajeEsperado = "Usuario o contraseña incorrectos";

        // Verificar si aparece el mensaje
        boolean mensajeEncontrado = driver.getPageSource()
                .contains(mensajeEsperado);

        if (mensajeEncontrado) {
            System.out.println(
                    "CP004 EXITOSO: Se mostró correctamente el mensaje de credenciales incorrectas."
            );
        } else {
            System.out.println(
                    "CP004 FALLIDO: No apareció el mensaje esperado."
            );
        }

        // Esperar para ver el resultado
        Thread.sleep(3000);

        // Cerrar navegador
        // driver.quit();
    }
}