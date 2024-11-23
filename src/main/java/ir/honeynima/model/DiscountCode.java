package ir.honeynima.model;

import java.time.LocalDateTime;

import ir.honeynima.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discounts")
public class DiscountCode extends BaseModel<Integer> {
    @Column(name = "discount_percent")
    private Double discountPercent;

    @Column(name = "expierd_date")
    private LocalDateTime expiredDate;
}
