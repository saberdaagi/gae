package com.teckup.core.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
@Data
@NoArgsConstructor
@Getter
@Setter
@IdClass(Absence.AssignedAbsence.class)
public class Absence extends AuditModel {

    @Id
    @ManyToOne
    @JoinColumn
    private Matiere matiere;

    @Id
    @ManyToOne
    @JoinColumn
    private User user;
    public static class AssignedAbsence implements Serializable {

        private User user;
        private Matiere matiere;

        public AssignedAbsence() {}

        public AssignedAbsence(User user, Matiere matiere) {
            this.user = user;
            this.matiere = matiere;
        }

        @Override
        public boolean equals(Object o) {

            if (o == this) {
                return true;
            }
            if (!(o instanceof Absence)) {
                return false;
            }
            Absence absence = (Absence) o;
            return Objects.equals(user, absence.getUser()) &&
                    Objects.equals(matiere, absence.getMatiere());
        }

        @Override
        public int hashCode() {
            return Objects.hash(user, matiere);
        }
    }


}
