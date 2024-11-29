package inventory_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Table(name = "t_inventory")
public class Inventory {
    @Id
    @GeneratedValue
    private Long id;
    private String skuCode;
    private Integer quantity;
}