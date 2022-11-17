package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ClabeInterbancariaUI {
    public static final Target NOMBRE_TITULAR = Target.the("campo Nombre del titular")
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


    public static final Target CANCELAR = Target.the("boton Cancelar del modal Confirma tu contrasenia")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[1]"))
            .locatedForIOS(By.xpath(""));


    public static final Target CANCELAR_EDICION = Target.the("boton Cancelar edicion")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[2]"))
            .locatedForIOS(By.xpath(""));

     public static final Target GUARDAR = Target.the("boton Guardar edicion")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[1]"))
            .locatedForIOS(By.xpath(""));

     public static final Target SEGUIR_EDITANDO = Target.the("boton seguir editando del modal Deseas salir?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SEGUIR EDITANDO']"))
            .locatedForIOS(By.xpath(""));

     public static final Target SALIR_SIN_GUARDAR= Target.the("boton Salir sin guardar del modal Deseas salir?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SALIR SIN GUARDAR']"))
            .locatedForIOS(By.xpath(""));


     public static final Target CONFIRMAR = Target.the("boton Confirmar ")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CONFIRMAR']"))
            .locatedForIOS(By.xpath(""));

     public static final Target CANCELAR_DATOS_CORRECTOS = Target.the("boton Cancelar del modal Tus datos son correctos")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target MENSAJE_GUARDADO_EXITOSO = Target.the("mensaje Actualizaste tus datos")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Actualizaste tus datos']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTRASENIA_INCORRECTA = Target.the("mensaje Contrasenia incorrecta")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_MESSAGE_VALIDATION']"))
            .locatedForIOS(By.xpath(""));






}
