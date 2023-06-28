package pl.adreszler.contactpage;

enum EmailTemplate {

    APPLICATION_SUBJECT("Zgłoszenie od %s"),
    CONFIRMATION_SUBJECT("Potwierdzenie zgłoszenia"),
    CONFIRMATION_CONTENT("Witaj %s,\ninformujemy, że otrzymaliśmy twoje zgłoszenie i ktoś wkrótce na nie odpowie.\n" +
            "Z wyrazami szacunku,\nJanusX IT Consulting\n\nJest to wiadomość wygenerowana automatycznie - nie odpowiadaj na nią."),
    APPLICATION_CONTENT("%s\n\nImię i nazwisko zgłaszającego: %s\nAdres e-mail zgłaszającego: %s");

    private final String template;

    EmailTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
