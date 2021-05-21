package seanlindev.springframework.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "petTypes")
public class PetType extends BaseEntity {

    @JoinColumn(name = "name")
    private String name;
}
