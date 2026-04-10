package org.example.rutaexpress.Controller;
import org.example.rutaexpress.Domain.Model.Transportista;
import org.example.rutaexpress.application.Services.Transportista.TransportistaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transportistas")
public class TransportistaController {

    private final TransportistaService transportistaService;

    public TransportistaController(TransportistaService transportistaService) {
        this.transportistaService = transportistaService;
    }

    @GetMapping
    public String listarTransportistas(Model model) {
        model.addAttribute("transportistas", transportistaService.obtenerTodos());
        return "transportistas/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("transportista", new Transportista());
        return "transportistas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarTransportista(@ModelAttribute Transportista transportista) {
        if (transportista.getId() == null) {
            transportistaService.crear(transportista);
        } else {
            transportistaService.actualizar(transportista.getId(), transportista);
        }
        return "redirect:/transportistas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Transportista transportista = transportistaService.obtenerPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("transportista", transportista);
        return "transportistas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTransportista(@PathVariable Long id) {
        transportistaService.eliminar(id);
        return "redirect:/transportistas";
    }
}