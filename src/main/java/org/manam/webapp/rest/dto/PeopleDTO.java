package org.manam.webapp.rest.dto;

/**
 * Created by kasar on 12/21/2017.
 */
public class PeopleDTO {
        private Long id;
        private String firstName;
        private String lastName;
        private String mailId;
        private Long number;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMailId() {
            return mailId;
        }

        public void setMailId(String mailId) {
            this.mailId = mailId;
        }

        public Long getNumber() {
            return number;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

}
