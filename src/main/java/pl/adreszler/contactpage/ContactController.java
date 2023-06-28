package pl.adreszler.contactpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("home", true);
        return "index";
    }

    @GetMapping("/kontakt")
    String contactForm(Model model) {
        model.addAttribute("emailDto", new EmailDto());
        return "contact";
    }

    @PostMapping("/kontakt")
    String contact(EmailDto emailDto, Model model) {
        Email application = EmailBuilder.buildApplicationEmail(emailDto);
        Email confirmation = EmailBuilder.buildConfirmationEmail(emailDto);
        boolean wasApplicationSent = emailService.sendEmail(application);
        if (wasApplicationSent) {
            boolean wasConfirmationSent = emailService.sendEmail(confirmation);
            if (wasConfirmationSent) {
                return "redirect:/success";
            } else {
                model.addAttribute("errorMessage", "Udało się wysłać zgłoszenie, ale wystąpił" +
                        " błąd przy wysyłaniu potwierdzenia");
                return "redirect:/error";
            }
        }

        model.addAttribute("errorMessage", "Wystąpił błąd przy wysyłaniu zgłoszenia");
        return "redirect:/error";
    }

    @GetMapping("/error")
    String error() {
        return "failure";
    }

    @GetMapping("/success")
    String success() {
        return "success";
    }
}
