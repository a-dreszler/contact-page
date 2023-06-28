package pl.adreszler.contactpage;

enum EmailAddress {
    CONTACT_PAGE_EMAIL("coding.email.tester@gmail.com"),
    CONTACT_DEPARTAMENT_EMAIL("coding.test.mail.receiver@gmail.com");

    private final String address;

    EmailAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
