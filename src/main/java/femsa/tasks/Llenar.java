package femsa.tasks;

import femsa.interactions.Digitar;
import femsa.interactions.Hide;
import femsa.user_interfaces.CobroUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import static femsa.user_interfaces.CobroUI.*;
import static femsa.user_interfaces.LoginUI.CONTRASENIA;
import static femsa.user_interfaces.LoginUI.EMAIL_O_NUMERO;

public class Llenar {
    public static Performable elFormularioInicioDeSesion(String usuario, String contrasenia) {
        return Task.where("{0} llena el formulario de inicio de sesion con sus credenciales",
                Enter.theValue(usuario).into(EMAIL_O_NUMERO),
                Enter.theValue(contrasenia).into(CONTRASENIA),
                Hide.theKeyboard()
        );

    }

    public static Performable elFormularioDeCobros(String monto, String concepto) {
        return Task.where("{0} llena el formulario de cobro con el monto: " + monto + " y el concepto: " + concepto,
                Check.whether(
                        Validate.isIOS()
                ).andIfSo(Digitar.conTecladoNativo(monto),
                        Check.whether(concepto != "" || concepto != null)
                                .andIfSo(
                                        Click.on(ESCRIBE_EL_CONCEPTO),
                                        Enter.theValue(concepto).into(CONCEPTO_VENTA),
                                        Click.on(GUARDAR)
                                )
                )
        );
    }
}
