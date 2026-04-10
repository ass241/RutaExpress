package org.example.rutaexpress.Controller;
import org.example.rutaexpress.Domain.Model.Envio;
import org.example.rutaexpress.application.Services.Cliente.ClienteService;
import org.example.rutaexpress.application.Services.Envio.EnvioService;
import org.example.rutaexpress.application.Services.Transportista.TransportistaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;
    private final ClienteService clienteService;
    private final TransportistaService transportistaService;

    // Inyectamos los tres servicios necesarios
    public EnvioController(EnvioService envioService,
                           ClienteService clienteService,
                           TransportistaService transportistaService) {
        this.envioService = envioService;
        this.clienteService = clienteService;
        this.transportistaService = transportistaService;
    }

    @GetMapping
    public String listarEnvios(Model model) {
        model.addAttribute("envios", envioService.obtenerTodos());
        return "envios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("envio", new Envio());

        // Pasamos clientes y transportistas para llenar los <select> de HTML
        model.addAttribute("listaClientes", clienteService.obtenerTodos());
        model.addAttribute("listaTransportistas", transportistaService.obtenerTodos());

        return "envios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEnvio(@ModelAttribute Envio envio) {
        if (envio.getId() == null) {
            envioService.crear(envio);
        } else {
            envioService.actualizar(envio.getId(), envio);
        }
        return "redirect:/envios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Envio envio = envioService.obtenerPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de envío inválido:" + id));

        model.addAttribute("envio", envio);

        // Pasamos también las listas para que se puedan reasignar en la vista de edición
        model.addAttribute("listaClientes", clienteService.obtenerTodos());
        model.addAttribute("listaTransportistas", transportistaService.obtenerTodos());

        return "envios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEnvio(@PathVariable Long id) {
        envioService.eliminar(id);
        return "redirect:/envios";
    }
}