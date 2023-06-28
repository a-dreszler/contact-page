package pl.adreszler.contactpage;

import static pl.adreszler.contactpage.EmailAddress.*;
import static pl.adreszler.contactpage.EmailTemplate.*;

class EmailBuilder {

    static Email buildApplicationEmail(EmailDto emailDto) {
        return new Email(
                CONTACT_PAGE_EMAIL.getAddress(),
                CONTACT_DEPARTAMENT_EMAIL.getAddress(),
                String.format(APPLICATION_SUBJECT.getTemplate(), emailDto.getFullName()),
                String.format(APPLICATION_CONTENT.getTemplate(),
                        emailDto.getContent(),
                        emailDto.getFullName(),
                        emailDto.getRecipient())
        );
    }

    static Email buildConfirmationEmail(EmailDto emailDto) {
        return new Email(
                CONTACT_PAGE_EMAIL.getAddress(),
                emailDto.getRecipient(),
                CONFIRMATION_SUBJECT.getTemplate(),
                String.format(CONFIRMATION_CONTENT.getTemplate(), emailDto.getFullName()));
    }
}