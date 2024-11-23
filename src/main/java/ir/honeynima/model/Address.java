package ir.honeynima.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String state;
    private String city;
    private String address;
    private String zipCode;
}
