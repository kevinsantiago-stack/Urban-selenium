import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prueba_3 {

    public static void main(String[] args) throws InterruptedException {

        // Abrir Google Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar ventana
        driver.manage().window().maximize();

        // Abrir Urban Studio
        driver.get("http://localhost:4200/");

        // Esperar que cargue la página
        Thread.sleep(3000);

        // Buscar botón Iniciar sesión
        WebElement botonLogin = driver.findElement(
                By.xpath("//*[contains(text(),'Iniciar sesión')]")
        );

        // Hacer clic sin llenar los campos
        botonLogin.click();

        // Esperar a que aparezca el mensaje
        Thread.sleep(2000);

        // Buscar el mensaje de validación
        String mensajeEsperado = "Debes completar todos los campos.";

        boolean mensajeEncontrado = driver.getPageSource()
                .contains(mensajeEsperado);

        // Verificar resultado
        if (mensajeEncontrado) {
            System.out.println("CP003 EXITOSO: El mensaje de validación apareció correctamente.");
        } else {
            System.out.println("CP003 FALLIDO: No apareció el mensaje esperado.");
        }

        // Esperar para visualizar el resultado
        Thread.sleep(3000);

        // Cerrar navegador
        // driver.quit();
    }
}