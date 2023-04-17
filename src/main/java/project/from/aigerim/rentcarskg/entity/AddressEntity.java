package project.from.aigerim.rentcarskg.entity;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "tb_address")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building_num")
    private Integer buildingNum;
}
