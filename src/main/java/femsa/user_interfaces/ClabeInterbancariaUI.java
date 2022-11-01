package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ClabeInterbancariaUI {
    public static final Target NOMBRE_TITULAR = Target.the("campo Nombre del titular")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

        public static final Target CONTRASENIA = Target.the("campo contrasenia")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CLABE_INTERBANCARIA = Target.the("campo Clabe interbancaria")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target INGRESAR = Target.the("boton Ingresar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Ingresar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target EDITAR = Target.the("boton Editar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Editar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONFIRMA_TU_CONTRASENIA = Target.the("titulo Confirma tu contrasenia")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Confirma tu contrase\u00f1a']"))
            .locatedForIOS(By.xpath("//android.widget.TextView[@text='Ingresar']"));

    public static final Target CANCELAR = Target.the("boton Cancelar del modal Confirma tu contrasenia")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTINUAR = Target.the("boton Continuar del modal Confirma tu contrasenia")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CANCELAR_EDICION = Target.the("boton Cancelar edicion")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[2]"))
            .locatedForIOS(By.xpath(""));

     public static final Target GUARDAR = Target.the("boton Guardar edicion")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[1]"))
            .locatedForIOS(By.xpath(""));

     public static final Target ACEPTAR_MODAL_SALIR = Target.the("boton Aceptar del modal Deseas salir?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Aceptar']"))
            .locatedForIOS(By.xpath(""));

     public static final Target CANCELAR_MODAL_SALIR = Target.the("boton Cancelar del modal Deseas salir?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cancelar']"))
            .locatedForIOS(By.xpath(""));

     public static final Target ACEPTAR_MODAL_DATOS_CORRECTOS = Target.the("boton Aceptar del modal Deseas salir?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Aceptar']"))
            .locatedForIOS(By.xpath(""));

     public static final Target CANCELAR_MODAL_DATOS_CORRECTOS = Target.the("boton Cancelar del modal Deseas salir?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cancelar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target MENSAJE_GUARDADO_EXITOSO = Target.the("mensaje Actualizaste tus datos")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Actualizaste tus datos']"))
            .locatedForIOS(By.xpath(""));






}
