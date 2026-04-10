package org.example.rutaexpress.Controller;
import org.example.rutaexpress.Domain.Model.Trabajador;
import org.example.rutaexpress.application.Services.Trabajador.TrabajadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public String listarTrabajadores(Model model) {
        model.addAttribute("trabajadores", trabajadorService.obtenerTodos());
        return "trabajadores/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "trabajadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardarTrabajador(@ModelAttribute Trabajador trabajador) {
        if (trabajador.getId() == null) {
            trabajadorService.crear(trabajador);
        } else {
            trabajadorService.actualizar(trabajador.getId(), trabajador);
        }
        return "redirect:/trabajadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Trabajador trabajador = trabajadorService.obtenerPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("trabajador", trabajador);
        return "trabajadores/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTrabajador(@PathVariable Long id) {
        trabajadorService.eliminar(id);
        return "redirect:/trabajadores";
    }
}