import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class prueba1 {

    public static void main(String[] args) {

        // Abrir Google Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar la ventana
        driver.manage().window().maximize();

        // Abrir Urban Studio
        driver.get("http://localhost:4200/");

        // Esperar 5 segundos para ver la página
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cerrar navegador
        // driver.quit();
    }
}